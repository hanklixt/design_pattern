package com.hank.design.singleton;

/**
 * @author lxt
 * @date 2019-12-09-13:33
 * 使用枚举完成单例模式
 */
public class SingletonTest7 {
    public static void main(String[] args) {
        final Singleton7 instance = Singleton7.INSTANCE;
        final Singleton7 instance1 = Singleton7.INSTANCE;
        System.out.println(instance == instance1);
        instance.ok();
    }
}

enum Singleton7 {


    INSTANCE;

    public void ok() {
        System.out.println("i am ok");
    }

}
