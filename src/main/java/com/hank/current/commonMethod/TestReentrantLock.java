package com.hank.current.commonMethod;

import sun.nio.fs.AbstractFileTypeDetector;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-05 17:42
 */
public class TestReentrantLock {

    private  final static ReentrantLock lock=new ReentrantLock();


    public static void main(String[] args) {
        TestReentrantLock lock = new TestReentrantLock();
        lock.testFairLock();
    }


    private void lock1(){
        try {
            lock.lock();
            System.out.println("lock1");
            lock2();
        }finally {
            lock.unlock();
        }
    }


    private void lock2(){

        try {
            lock.lock();
            System.out.println("lock2");
            lock3();
        }finally {

            lock.unlock();
        }
    }

    private void lock3(){
        try {
            lock.lock();
            System.out.println("lock3");
        }finally {

            lock.unlock();
        }
    }

    /**
     * 可打断模式
     */
    private void canInterrupt(){
        Thread t1 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName()+"在等待获取锁的过程中被打断了");
            }finally {
                lock.unlock();
            }
        });
        t1.start();
        lock.lock();
        System.out.println("获取到了锁");
        try {
            Thread.sleep(10);
            t1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }


    private void canNotInterrupt(){
        Thread t1 = new Thread(() -> {
            try{
                lock.lock();
            }catch (Exception e){
                System.out.println("打断我了");
            }
            finally
             {
                lock.unlock();
            }
        },"t1");


        lock.lock();;
        try {
            Thread.sleep(10);
            t1.interrupt();
            System.out.println("想去打断t1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }


    private void tryLock(){
        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            System.out.println("启动");
                try {
                    if (!lock.tryLock(800, TimeUnit.MILLISECONDS)) {
                        System.out.println("获取锁失败");
                        return;
                    }
                    System.out.println("获取到了锁");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("释放..结束了");
                    lock.unlock();
                }
        }, "T1");

        try {
            lock.lock();
            t1.start();
            Thread.sleep(1000);
            System.out.println("。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }



    private void  testFairLock(){


        ReentrantLock lock=new ReentrantLock(true);

        for (int i=0;i<50;i++){
            Thread t = new Thread(() -> {
                try{
                    lock.lock();
                    System.out.println(Thread.currentThread().getName());
                }finally {
                    lock.unlock();
                }

            },i+1+"");

            t.start();
        }


    }

    /**
     * 多条件变量
     */
    private void condition(){



    }

}
