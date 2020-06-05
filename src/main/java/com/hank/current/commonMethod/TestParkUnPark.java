package com.hank.current.commonMethod;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-04 16:57
 */
public class TestParkUnPark {




    public static void main(String[] args) {
       test();
    }


    /**
     *测试park 和UnPark
     */
    public static void test(){

        System.out.println("开始");

        Thread t1 = new Thread(() -> {
            System.out.println("开始阻塞");
            LockSupport.park();
            System.out.println("继续执行");
            //继续阻塞
            LockSupport.park();
            System.out.println("再次继续");
        });
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        };
        LockSupport.unpark(t1);

        //再次发放许可
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(t1);


    }

}
