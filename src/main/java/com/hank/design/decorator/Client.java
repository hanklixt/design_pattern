package com.hank.design.decorator;

/**
 * @author lxt
 * @date 2019-12-11-14:23
 * 装饰者模式，订购咖啡，加购调料
 */
public class Client {
    public static void main(String[] args) {

        Drink order = new LongBlackCoffee();
        System.out.println(order.getDes());
        System.out.println(order.cost());
        order = new Chocolate(order);
        System.out.println(order.cost());

        order = new Chocolate(order);
        System.out.println(order.cost());
        order = new Chocolate(order);
        System.out.println(order.cost());
        order = new Milk(order);
        System.out.println(order.cost());


    }
}
