package com.hank.current.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-19 10:12
 */
public class TestFork1 extends RecursiveTask<Integer> {


    private int n;



    public TestFork1(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        //返回直到不能拆分的结果
        if (n%2==0){
            System.out.println("n:" + n);
            return n;
        }
        //将任务进行拆分
        TestFork1 testFork1 = new TestFork1(n-1);

        testFork1.fork();
        System.out.println("t1 forrk" + n);

        //join是返回终止条件的拆分的结果
        Integer result = testFork1.join()+n;

        System.out.println("join " + n);

        return result;
    }



    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Integer invoke = forkJoinPool.invoke(new TestFork1(15));
        System.out.println(invoke);
    }
}
