package com.hank.current.commonMethod;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-05 14:53
 */
public class TestDeadLock {

    private final  static Object a=new Object();

    private final  static  Object b=new Object();


    public static void main(String[] args) {


        Thread t1 = new Thread(() -> {
            synchronized (a){
                System.out.println(Thread.currentThread().getName()+"获取到A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b){
                    System.out.println(Thread.currentThread().getName()+"获取B");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        },"t1");

        Thread t2 = new Thread(() -> {
            synchronized (b){
                System.out.println(Thread.currentThread().getName() + "获取到B");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a){
                    System.out.println(Thread.currentThread().getName() + "获取到A");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        },"t2");


        t1.start();
        t2.start();

    }



}
