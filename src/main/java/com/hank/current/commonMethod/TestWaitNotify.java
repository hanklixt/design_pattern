package com.hank.current.commonMethod;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-04 11:45
 */
public class TestWaitNotify {


    private  final static Object obj=new Object();

    public static void main(String[] args) {

        new TestWaitNotify().test1();

    }
    public void test1(){
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                todo();
            }
        },"this one");


        Thread t2 = new Thread(() -> {
            synchronized (obj) {
                todo();
            }
        }, "this two");
        t1.start();
        t2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (obj){
//            obj.notify();       //唤醒obj上的waitSet中等待的一个线程
            obj.notifyAll();      //唤醒obj上waitSet中等待的所有线程
        }

    }

    //模拟代码
    private void todo() {
        System.out.println("执行中"+Thread.currentThread().getName());
        try {

            obj.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("其他代码");
    }


}
