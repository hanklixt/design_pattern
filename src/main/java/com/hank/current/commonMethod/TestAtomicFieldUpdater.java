package com.hank.current.commonMethod;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-14 15:44
 */
public class TestAtomicFieldUpdater {

    private  volatile int field;

    public TestAtomicFieldUpdater(int field) {

        this.field = field;
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    public static void main(String[] args) {
        test();
    }

    private static void test(){

        new LongAdder();

        TestAtomicFieldUpdater test = new TestAtomicFieldUpdater(100);
        AtomicIntegerFieldUpdater<TestAtomicFieldUpdater> updater = AtomicIntegerFieldUpdater.newUpdater(TestAtomicFieldUpdater.class,"field");

        Thread thread = new Thread(()->{
            boolean b = updater.compareAndSet(test, 100, 200);
            System.out.println("更新属性field——>" + 100 + "-->200:"+b+":"+updater.get(test));

            boolean b1 = updater.compareAndSet(test, 200, 300);
            System.out.println("更新属性field——>" + 200 + "-->300:"+b1+":"+updater.get(test));
        });

        thread.start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean a = updater.compareAndSet(test, 400, 300);

        System.out.println("更新属性field——>" + 200 + "-->300:"+a+":"+updater.get(test));


        new LongAdder();


    }


}


