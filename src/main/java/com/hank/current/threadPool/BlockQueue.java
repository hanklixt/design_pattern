package com.hank.current.threadPool;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-16 15:36
 */
public final class BlockQueue<T> {

    private  Deque<T> deque=new ArrayDeque<>();

    private static ReentrantLock lock=new ReentrantLock();

    //生产者条件变量
    private  Condition producerCondition = lock.newCondition();

    //消费者条件变量
    private  Condition consumerCondition = lock.newCondition();

    //定义池中容量
    private int capacity;


    public BlockQueue(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 阻塞获取--消费方法
     * @return
     */
    public T take(){
        try{
            lock.lock();
            while (deque.isEmpty()){
                try {
                    consumerCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T result = deque.getFirst();
            producerCondition.signal();
            return result;
        }finally {
            lock.unlock();
        }
    }

    /**
     * 阻塞获取--消费方法
     * @param timeUnit
     * @param mills
     * @return
     */
    public T take(TimeUnit timeUnit,long mills){
        try{
            lock.lock();
                try {
                    long nanos = timeUnit.toNanos(mills);
                    while (true){
                        if (nanos<=0){
                            break;
                        }
                        //时间统一转成毫秒
                         nanos = consumerCondition.awaitNanos(nanos);
                    }
                        } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            if (deque.isEmpty()){
                return null;
            }
            return deque.getFirst();
        }finally {
            lock.unlock();
        }
    }


    /**
     * 生产者--当达到指定队列数，进行阻塞
     * @param task
     */
    public void put(T task){
        try {
            lock.lock();
            //超过最大容量
            while (deque.size()==capacity){
                try {
                    producerCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            deque.addLast(task);
            consumerCondition.signal();
        }finally {
            lock.unlock();
        }
    }

    /**
     * 超时阻塞
     */
    public boolean put(TimeUnit unit,long mills,T task){
        try {
            lock.lock();
            //统一转成毫秒进行处理
            long nanos = unit.toNanos(mills);
            while (deque.size()==capacity){
                if (nanos<=0){
                    return false;
                }
                try {
                  //返回剩余的等待时间
                  nanos= producerCondition.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean add = deque.add(task);
            consumerCondition.signal();
            return add;
        }finally {
            lock.unlock();
        }
    }

    /**
     *
     */
    private int getSize(){
        try{
            lock.lock();
            return deque.size();
        }finally {
            lock.unlock();
        }

    }

    /**
     * 使用拒绝策略
     */
    public void tryPut(RejectPolicy<T> reject,T task){
        try {
            lock.lock();
            if (deque.size()>=capacity){
                reject.reject(this,task);
            }else {
                System.out.println("加入队列");
                deque.addLast(task);
                consumerCondition.signal();
            }
        }finally {
            lock.unlock();
        }
    }




}
