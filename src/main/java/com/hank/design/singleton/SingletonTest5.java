package com.hank.design.singleton;

/**
 * @author lxt
 * @date 2019-12-09-11:38
 * 懒汉式-双重检查(保证线程可见性)，推荐使用
 */
public class SingletonTest5 {
    public static void main(String[] args) {
        System.out.println("懒汉式-双重检查(需保证线程可见性)");
        final Singleton5 instance = Singleton5.getInstance();
        final Singleton5 instance1 = Singleton5.getInstance();
        System.out.println(instance == instance1);
    }

}

class Singleton5 {
    //1.构造器私有化
    private Singleton5() {

    }

    //2.声明实例，保证可见性
    private static volatile Singleton5 instance;

    //3.提供对外静态方法

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
        }


        return instance;
    }

}
