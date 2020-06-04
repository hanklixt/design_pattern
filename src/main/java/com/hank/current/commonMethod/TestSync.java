package com.hank.current.commonMethod;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-03 11:52
 */
public class TestSync {

    static Integer a=0;

    private static final Object lock=new Object();

    public static void main(String[] args) {
        TestSync testSync = new TestSync();
        testSync.test();
        TestSync testSync1 = new TestSync();
        testSync1.test();
    }

    public  void  test(){
        Thread t1 = new Thread(() -> {
            synchronized (this){
                for (int i = 0; i < 1000; i++) {
                    a++;
                }
            }
        }, "1");

        Thread t2 = new Thread(() -> {
            synchronized (lock){
                for (int i = 0; i < 1000; i++) {
                    a--;
                }
            }
        }, "2");

        t1.start();

        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);
    }


}
