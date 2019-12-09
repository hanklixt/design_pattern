package com.hank.design.singleton;

/**
 * @author lxt
 * @date 2019-12-09-10:38
 * 单例模式 饿汉式(静态常量)
 */
public class SingletonTest1 {

    public static void main(String[] args) {
        final Singleton instance = Singleton.getInstance();
        final Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());
    }

}

/**
 *
 */
class Singleton {
    //1.构造方法私有化
    private Singleton() {
    }

    //2.本类内部创建静态实例
    private final static Singleton instance = new Singleton();

    //3.提供静态获取实例方法
    public static Singleton getInstance() {
        return instance;
    }

}