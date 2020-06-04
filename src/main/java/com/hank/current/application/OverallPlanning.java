package com.hank.current.application;

import static java.lang.Thread.sleep;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-02 11:22
 * 应用统筹，泡茶烧水
 *
 */
public class OverallPlanning {



    public static void main(String[] args) throws InterruptedException {

        test1();
    }


    /**
     * wait-notify
     */
    private static void  test2(){
           //todo
    }



    /**
     * park-unPark
     */
    private static void  test3(){
        //todo
    }


    /**
     * 老王洗---，小王烧水--水烧好--泡茶
     * @throws InterruptedException
     */
    private static void test1() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"烧开水");
            try {
                sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"小王");

        Thread t2 = new Thread(() -> {
            System.out.println("洗茶壶");
            System.out.println("洗水壶");
            System.out.println("洗水杯");
            System.out.println("拿茶叶");
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("泡茶叶----end");
        },"老王");
        t1.start();
        t2.start();


    }

}
