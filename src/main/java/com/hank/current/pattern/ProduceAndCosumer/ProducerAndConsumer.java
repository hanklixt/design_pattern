package com.hank.current.pattern.ProduceAndCosumer;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-04 15:43
 */

public class ProducerAndConsumer extends Thread {

    //生产者---
    //最大容量
    private  int max_capcity;

    private  String name;

    private Queue<Integer> queue;

    private int i;

    public ProducerAndConsumer(int max, String name, Queue<Integer> queue){
        super(name);
        this.queue=queue;
        this.max_capcity=max;
        this.i=max;
    }


    //生产数据
    @Override
    public void run() {
        synchronized (queue){
            while (queue.size()==max_capcity){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //生产
            }
            System.out.println(Thread.currentThread().getName()+ "produce value " + i);
            queue.add(++i);
            queue.notifyAll();
            //继续生产
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



    //test
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer(10,"producer",queue);
        producerAndConsumer.start();
        Consumer consumer = new Consumer(queue, "consumer");
        consumer.start();
    }
}

/**
 * 消费者
 */
class Consumer extends Thread{

    /**
     */
    private Queue<Integer> queue;

    private String name;


    public  Consumer(Queue<Integer> queue,String name){
        super(name);
        this.queue=queue;
    }


    @Override
    public void run() {
        synchronized (queue){
            while (queue.isEmpty()){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //使用
            Integer poll = queue.poll();
            System.out.println(Thread.currentThread().getName() + poll + " do someThing...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            queue.notifyAll();
        }
    }
}
