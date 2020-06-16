package com.hank.current.commonMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-02 10:10
 * 主线程和守护线程..
 *  守护线程在start之前，可以调用setDaemon方法,这样---其他非守护线程结束之后，守护线程也会自动结束
 */
public class DaemonTest {


    public static void main(String[] args) throws InterruptedException, ParseException {




        testDaemon();
         testFormat();
    }

    private static void testDaemon() {



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


    private static void testFormat(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        List<Thread> t=new ArrayList<>();

        for (int i = 0; i <50 ; i++) {
            Thread thread = new Thread(() -> {
                try {
                    Date parse = simpleDateFormat.parse("2019-01-01");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
            t.add(thread);
        }

        t.forEach(Thread::start);
        for (int i = 0; i < t.size(); i++) {
            Thread thread = t.get(i);
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }



}
