package com.hank.design.singleton;

/**
 * @author lxt
 * @date 2019-12-09-13:10
 * 懒汉式-内部类方式，推荐使用
 * 1.外部类被加载时，不会加载内部类
 * 2.利用jvm装载类时，只有一个线程能进行装载特性。
 */
public class SingletonTest6 {
    public static void main(String[] args) {
        final Singleton6 instance = Singleton6.getInstance();
        final Singleton6 instance1 = Singleton6.getInstance();
        System.out.println(instance == instance1);
    }
}

class Singleton6 {
    //1.构造方法私有化
    private Singleton6() {

    }

    //2.提供内部类实例
    private static class SingletonInstance {

        private static final Singleton6 INSTANCE = new Singleton6();

    }

    //3.提供对外获取实例方法
    public static Singleton6 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
