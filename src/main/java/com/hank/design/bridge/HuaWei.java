package com.hank.design.bridge;

/**
 * @author lxt
 * @date 2019-12-11-10:46
 */
public class HuaWei implements Brand {
    @Override
    public void open() {
        System.out.println("华为手机开机");
    }

    @Override
    public void call() {
        System.out.println("华为手机打电话");
    }

    @Override
    public void close() {
        System.out.println("华为手机开机");
    }
}
