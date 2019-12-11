package com.hank.design.bridge;

/**
 * @author lxt
 * @date 2019-12-11-10:47
 * 手机-聚合品牌
 */
public abstract class Phone {
    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    public void open() {
        brand.open();
    }

    public void call() {
        brand.call();
    }

    public void close() {
        brand.close();
    }


}
