package com.hank.design.singleton;

/**
 * @author lxt
 * @date 2019-12-09-11:27
 * 懒汉式，方法同步锁，线程安全，效率低下
 */
public class SingletonTest4 {
    public static void main(String[] args) {

        System.out.println("懒汉式-线程安全,效率低下");
        final Singleton4 instance = Singleton4.getInstance();
        final Singleton4 instance1 = Singleton4.getInstance();
        System.out.println(instance == instance1);
    }
}

class Singleton4 {
    //1.构造器私有化
    private Singleton4() {

    }

    //2.声明实例
    private static Singleton4 instance;


    //3.提供对外静态方法获取实例
    public static synchronized Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}