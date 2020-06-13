package com.hank.current.commonMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-13 16:54
 */
public class TestCas {


    private static AtomicInteger balance=new AtomicInteger(100);

    public static void main(String[] args) {

        String str="";
        str.substring(1);

       List<Thread> task=new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            Thread thread = new Thread(()->{
                windowDraw(1);
            });
            task.add(thread);
        }
        task.forEach(Thread::start);
        //等....
        for (Thread thread : task) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(balance.get());
    }


    private static void windowDraw(Integer amt){

        while (true){

            int pre = balance.get();

            int next=pre-amt;

            if (balance.compareAndSet(pre,next)){
                break;
            }

        }

        //以上可简化为---
//        balance.addAndGet(-1*amt);

    }




}
