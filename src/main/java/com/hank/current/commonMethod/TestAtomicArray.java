package com.hank.current.commonMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.function.*;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-14 14:16
 */
public class TestAtomicArray {




    public static void main(String[] args) {

        demo(()->new int[10],
                (array)->array.length,
                (array,num)->array[num]++,
                (array)->System.out.println(Arrays.toString(array))
                );
        demo(()->new AtomicIntegerArray(10),
                (array)->array.length(),
                (array,num)->array.getAndIncrement(num),
                (array)->System.out.println(array)
        );


    }

    /**
     *
     * @param supplier   无中生有  ()->
     * @param function    ()-> 一个参数一个结果   BiFunction 两个参数，一个结果
     * @param consumer    ()->  一个参数没结果   BiConsumer 两个参数，没结果
     */
    private static <T> void demo(Supplier<T> supplier,
                                 Function<T,Integer> function,
                                 BiConsumer<T,Integer> biConsumer,
                                 Consumer<T> consumer) {

        List<Thread> task=new ArrayList<>();

        T value = supplier.get();

        Integer length = function.apply(value);

        for ( int j=0;j<length;j++){
            Thread t = new Thread(() -> {

                for (int i = 0; i <10000 ; i++) {
                    biConsumer.accept(value,i%length);
                }
            });
            task.add(t);
        }

        for (Thread thread:task){
            thread.start();
        }

        for (Thread thread:task){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        consumer.accept(value);

    }


}
