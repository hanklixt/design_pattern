package com.hank.current.commonMethod;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-15 11:55
 */
public  class TestAtomicData {

    private  volatile  int value;

    private static final Unsafe UNSAFE=TestUnSafeAccessor.getUnsafe();

    private static final   long OFFSET;

    static {
        try {
            Field  value1 = TestAtomicData.class.getDeclaredField("value");
            OFFSET = UNSAFE.objectFieldOffset(value1);
        } catch (Exception e) {
           throw new Error(e);
        }
    }


    /***递减
     */
    private void  Decrease(Integer amount){
        int oldValue;
        do {
            oldValue = value;
        } while (!UNSAFE.compareAndSwapInt(this, OFFSET, oldValue, oldValue - amount));

    }

    private Integer get(){
        return value;
    }

    public TestAtomicData(int value) {
        this.value = value;
    }

    public static void main(String[] args) {

        TestAtomicData testAtomicData = new TestAtomicData(1000);
        List<Thread> task=new ArrayList<>();
        for (int i = 0; i <50 ; i++) {
            Thread thread = new Thread(() -> {
                testAtomicData.Decrease(20);
            });
            task.add(thread);
        }

        task.forEach(Thread::start);

        for (Thread thread : task) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(testAtomicData.get());

    }
}
