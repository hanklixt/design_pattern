package com.hank.current.commonMethod;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-05 17:42
 */
public class TestRentryLock {

    private  final static ReentrantLock lock=new ReentrantLock();


    public static void main(String[] args) {

        TestRentryLock testRentryLock = new TestRentryLock();
        testRentryLock.lock1();
    }


    public void lock1(){

        try {
            lock.lock();
            System.out.println("lock1");
            lock2();
        }finally {

            lock.unlock();
        }
    }


    public void lock2(){

        try {
            lock.lock();
            System.out.println("lock2");
            lock3();
        }finally {

            lock.unlock();
        }
    }

    public void lock3(){
        try {
            lock.lock();
            System.out.println("lock3");
        }finally {

            lock.unlock();
        }
    }
}
