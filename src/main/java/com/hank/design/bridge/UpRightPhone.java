package com.hank.design.bridge;

/**
 * @author lxt
 * @date 2019-12-11-10:56
 * 滑盖式手机
 */
public class UpRightPhone extends Phone {

    public UpRightPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void open() {
        System.out.println("滑盖手机");
        super.open();
    }

    @Override
    public void call() {
        System.out.println("滑盖手机");
        super.call();
    }

    @Override
    public void close() {
        System.out.println("滑盖手机");
        super.close();
    }
}
