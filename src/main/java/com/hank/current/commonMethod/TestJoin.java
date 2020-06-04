package com.hank.current.commonMethod;



/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-01 16:05
 */
public class TestJoin {

    public static void main(String[] args) throws InterruptedException {

        long l1 = System.currentTimeMillis();
        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        thread.join(2000);
        long l2 = System.currentTimeMillis();
        System.out.println("耗时"+(l2-l1));
    }


}
