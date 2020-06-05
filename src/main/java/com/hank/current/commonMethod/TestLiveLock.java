package com.hank.current.commonMethod;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-05 15:55
 *
 * 活锁(两个线程互相改变对方的执行条件，导致最后，谁也无法停止)
 */
public class TestLiveLock {


    private static int count=10;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
          while (count>0){
              count--;
              try {
                  Thread.sleep(2);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        },"t1");
        Thread t2 = new Thread(() -> {
            while (count<20){
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
            }
        }, "t2");
        t1.start();
        t2.start();
    }

}
