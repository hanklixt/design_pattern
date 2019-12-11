package com.hank.design.decorator;

/**
 * @author lxt
 * @date 2019-12-11-15:23
 */
public class Milk extends Decorator {
    public Milk(Drink drink) {
        super(drink);
        setDes("牛奶");
        setPrice(1.3f);
        System.out.println("加购一份牛奶");

    }
}
