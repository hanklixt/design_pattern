package com.hank.current.commonMethod;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-04 9:51
 * 1.Monitor 对象锁，只有一个线程可以获取，如果没有获取到对象的 Monitor ,调用 notify 或者 notifyAll 会抛出异常IllegalMonitorStateException
 */

public class TestMonitor {

    private static final Object obj=new Object();
    /**
     *获取的不是对象锁，然后调用notify---，即指获得了object的Monitor---抛出异常
     */
    public void test(){
        synchronized (obj){
            notify();
        }
    }


    public void test2(){
        synchronized (obj){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取对象锁，调用notify--正常运行
     */
    public void  test1(){
        synchronized (this){
            notify();
        }
    }






    public static void main(String[] args) {

        new Thread(()->{
            new TestMonitor().test2();
        }).start();
    }



}
