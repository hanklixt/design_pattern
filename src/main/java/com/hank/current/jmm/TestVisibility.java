package com.hank.current.jmm;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-13 14:17
 * 可见性--退不出的循环
 */
public class TestVisibility {

    private static volatile boolean run=true;

    public static void main(String[] args) {

        Thread t1= new Thread(() -> {
            while (run){


            }

        },"t1");

        t1.start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        run=false;



    }

}
