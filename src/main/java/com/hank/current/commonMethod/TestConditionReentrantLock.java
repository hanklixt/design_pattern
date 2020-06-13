package com.hank.current.commonMethod;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-13 13:25
 * 多条件静态变量
 */
public class TestConditionReentrantLock {

    private static ReentrantLock lock=new ReentrantLock();

    /**
     * 获取一个条件变量的任务等待队列
     */
    private static Condition waitCigaretteQueue = lock.newCondition();
    /**
     * 获取另外一个条件变量的任务等待队列
     */
    private static Condition waitBreakfastQueue = lock.newCondition();
    /**
     * 有烟没
     */
    private static volatile Boolean hasCigarette =false;
    /**
     * 有饭没
     */
    private static volatile Boolean hasBreakFast =false;


    public static void main(String[] args) {

        Thread breakFast = new Thread(()->{
            try{
                lock.lock();
                System.out.println("有没有饭呀"+ hasCigarette);
                while (!hasBreakFast){
                    System.out.println("没有我就等了");
                    try {
                        //加入等待队列，同时释放锁
                        waitBreakfastQueue.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("我吃饭了");
            }finally {
                lock.unlock();
            }

        });

        Thread cigarette = new Thread(() -> {
            try {
                System.out.println("有没有香烟");
                lock.lock();
                while (!hasCigarette){
                    System.out.println("没有烟我只能等会再问了");
                    try {
                        waitCigaretteQueue.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("抽烟了");
            }finally {
                lock.unlock();
            }
        });

        breakFast.start();
        cigarette.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sendBreakFast();
        sendCigaretteQuene();

    }

    /**
     * 送快餐
     */
    private static void sendBreakFast(){
        try{
            lock.lock();
            System.out.println("我来送饭了");
            hasBreakFast =true;
            //唤醒
            waitBreakfastQueue.signal();
        }finally {
           lock.unlock();
        }
    }

    /**
     * 送烟
     */
    private static void sendCigaretteQuene(){
        try {
            lock.lock();
            System.out.println("我来送烟了");
            hasCigarette =true;
            //通知开饭
            waitCigaretteQueue.signal();
        }finally {
            lock.unlock();
        }

    }


}
