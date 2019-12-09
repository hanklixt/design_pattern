package com.hank.design.singleton;

/**
 * @author lxt
 * @date 2019-12-09-10:55
 * 饿汉式(静态代码块)
 */
public class SingletonTest2 {
    public static void main(String[] args) {

        final Singleton2 instance = Singleton2.getInstance();
        final Singleton2 instance1 = Singleton2.getInstance();
        System.out.println(instance == instance1);
    }
}

class Singleton2 {
    //1.构造器私有化
    private Singleton2() {


    }

    //2.内部创建实例
    private static Singleton2 instance;

    //3.静态代码块实例化
    static {
        instance = new Singleton2();
    }

    //4.提供静态获取实例方法
    public static Singleton2 getInstance() {
        return instance;
    }


}
