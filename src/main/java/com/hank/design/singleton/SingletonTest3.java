package com.hank.design.singleton;

/**
 * @author lxt
 * @date 2019-12-09-11:16
 * 需要时才创建-懒汉式(存在线程安全问题)
 */
public class SingletonTest3 {
    public static void main(String[] args) {
        System.out.println("懒汉式-线程不安全");
        final Singleton3 instance = Singleton3.getInstance();
        final Singleton3 instance1 = Singleton3.getInstance();
        System.out.println(instance == instance1);
    }

}

class Singleton3 {
    //1.构造器私有化
    private Singleton3() {

    }

    //2.声明实例
    private static Singleton3 instance;


    //3.提供对外静态方法获取实例
    public static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
