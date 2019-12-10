package com.hank.design.factory.absfactory.order;

import com.hank.design.factory.absfactory.pizza.LDCheesePizza;
import com.hank.design.factory.absfactory.pizza.LDGreekPizza;
import com.hank.design.factory.absfactory.pizza.Pizza;

/**
 * @author lxt
 * @date 2019-12-10-9:43
 */
public class LdFactory implements AbsFactory {

    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("greek")) {
            pizza = new LDGreekPizza();
            pizza.setName("LDGreekPizza");
        } else if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
            pizza.setName("LDCheesePizza");
        }
        return pizza;

    }
}
