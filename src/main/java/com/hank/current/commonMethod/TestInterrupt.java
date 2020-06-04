package com.hank.current.commonMethod;

import java.util.concurrent.locks.LockSupport;

import static java.lang.Thread.sleep;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-01 16:16
 */
public class TestInterrupt {




    public static void main(String[] args) throws InterruptedException {
//        test1();
//        test2();
//        test3();
//          test4();
            test5();
    }


    /**
     * 其他状态的线程，调用interrupt会设置中断标记
     * @throws InterruptedException
     */
    private static void test1() throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();
        Thread.sleep(3);
        t1.join();
        t1.interrupt();
        boolean interrupted = t1.isInterrupted();
        System.out.println("打断状态"+t1.getName()+interrupted);
    }

    /**
     * 线程调用了sleep之后，会清除打断标记(但是不一定能正确获取到中断标记--需要等待sleep,wait,join方法执行完毕)
     * @throws InterruptedException
     */
    private static void test2() throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        Thread t1 = new Thread(runnable,"t1");
        t1.start();
        t1.interrupt();
        boolean interrupted = t1.isInterrupted();
        System.out.println("打断状态"+t1.getName()+interrupted);
    }

    /**
     * 线程调用了park之后，会设置打断标记
     * @throws InterruptedException
     */
    private static void test3() throws InterruptedException {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
            LockSupport.park();
            System.out.println(Thread.currentThread().isInterrupted()+"---打断状态");
        };
        Thread t1 = new Thread(runnable,"t3");
        t1.start();
        sleep(500);
        t1.interrupt();
        boolean interrupted = t1.isInterrupted();
        System.out.println("打断状态"+t1.getName()+interrupted);

    }

    /**
     * 线程一直阻塞:这是因为默认许可呗占用，park()方法一直不能获取许可。
     * @throws InterruptedException
     */
    private static void test4() throws InterruptedException {

        System.out.println(Thread.currentThread().getName()+"begin....");

        LockSupport.park();

    }


    /**
     * 先调用unpark释放许可，再调用park获取许可，此时可以正常获取到许可
     * @throws InterruptedException
     */
    private static void test5() throws InterruptedException {

        System.out.println(Thread.currentThread().getName()+"begin....");

        LockSupport.unpark(Thread.currentThread());

        LockSupport.park();

    }

}
