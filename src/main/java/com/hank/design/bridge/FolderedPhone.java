package com.hank.design.bridge;

/**
 * @author lxt
 * @date 2019-12-11-10:51
 */
public class FolderedPhone extends Phone {

    public FolderedPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void open() {
        System.out.println("翻盖手机");
        super.open();
    }

    @Override
    public void call() {
        System.out.println("翻盖手机");
        super.call();
    }

    @Override
    public void close() {
        System.out.println("翻盖手机");
        super.close();
    }

}
