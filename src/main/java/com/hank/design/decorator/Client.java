package com.hank.design.decorator;

/**
 * @author lxt
 * @date 2019-12-11-14:23
 * 装饰者模式，订购咖啡，加购调料
 */
public class Client {
    public static void main(String[] args) {

        final LongBlackCoffee longBlackCoffee = new LongBlackCoffee(2);
        System.out.println(longBlackCoffee.getDes());
        System.out.println(longBlackCoffee.cost());
        final Chocolate chocolate = new Chocolate(longBlackCoffee);
        System.out.println(chocolate.cost());

        final Chocolate chocolate1 = new Chocolate(chocolate);
        System.out.println(chocolate1.cost());
        final Chocolate chocolate2 = new Chocolate(chocolate1);
        System.out.println(chocolate2.cost());


    }
}
