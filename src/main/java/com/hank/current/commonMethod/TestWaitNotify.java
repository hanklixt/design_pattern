package com.hank.current.commonMethod;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-04 11:45
 */
public class TestWaitNotify {


    private  final static Object obj=new Object();

    public static void main(String[] args) {

//        new TestWaitNotify().test1();
        new TestWaitNotify().test2();

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



    //工作状态
    private static boolean WORK_STATE=false;

    /**
     * wait(long n)
     */
    public void  test2(){
        Thread t1 = new Thread(() -> {
            synchronized (obj){
                System.out.println("开始准备");
                if (!WORK_STATE){
                    try {
                        obj.wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println("开始工作啦");
                }
                //做其他事
                if (WORK_STATE){
                    System.out.println("还是干活吧");
                }
            }
        },"t1");
        t1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WORK_STATE=true;




    }

}
