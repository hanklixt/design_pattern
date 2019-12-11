package com.hank.design.decorator;

/**
 * @author lxt
 * @date 2019-12-11-14:13
 */
public class Chocolate extends Decorator {

    public Chocolate(Drink drink) {
        super(drink);
        setPrice(7.0f);
        setDes("巧克力调料");
        System.out.println("加购一份巧克力调料");
    }


}
