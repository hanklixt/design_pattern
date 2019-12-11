package com.hank.design.adapter.interfaceadapter;

/**
 * @author lxt
 * @date 2019-12-11-9:23
 * 接口适配器模式，不用全部实现适配器里面的方法
 */
public class Client {
    public static void main(String[] args) {
        final AbsAdapter absAdapter = new AbsAdapter() {
            @Override
            public void m1() {
                System.out.println("实现m1方法");
            }
        };
        absAdapter.m1();
    }
}
