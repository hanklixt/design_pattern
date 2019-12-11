package com.hank.design.decorator;

/**
 * @author lxt
 * @date 2019-12-11-14:03
 * 装饰者-组合加继承
 */
public class Decorator extends Drink {

    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    //配料价格=单品咖啡+多配料
    @Override
    public float cost() {
        return getPrice() + drink.cost();
    }
}
