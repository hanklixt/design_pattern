package com.hank.design.factory.absfactory.order;

import com.hank.design.factory.absfactory.pizza.BJCheesePizza;
import com.hank.design.factory.absfactory.pizza.BJGreekPizza;
import com.hank.design.factory.absfactory.pizza.BJPepperPizza;
import com.hank.design.factory.absfactory.pizza.Pizza;

/**
 * @author lxt
 * @date 2019-12-10-9:42
 */
public class BjFactory implements AbsFactory {
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("greek")) {
            pizza = new BJGreekPizza();
            pizza.setName("BJGreekPizza");
        } else if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
            pizza.setName("BJCheesePizza");
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
            pizza.setName("BJPepperPizza");
        }
        return pizza;
    }
}
