package com.hank.current.commonMethod;

import static java.lang.Thread.sleep;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-02 10:10
 * 主线程和守护线程..
 *  守护线程在start之前，可以调用setDaemon方法,这样---其他非守护线程结束之后，守护线程也会自动结束
 */
public class DaemonTest {


    public static void main(String[] args) throws InterruptedException {

        System.out.println("开始了");

        Thread thread = new Thread(()->{
            System.out.println("线程 start"+"1");
            try {
                sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程end"+1);
        });

        thread.setDaemon(true);

        thread.start();





    }



}
