package com.hank.design.factory.factory.order;

import com.hank.design.factory.factory.pizza.LDCheesePizza;
import com.hank.design.factory.factory.pizza.LDGreekPizza;
import com.hank.design.factory.factory.pizza.Pizza;

/**
 * @author lxt
 * @date 2019-12-09-17:13
 */
public class LDFactory extends OrderPizza {

    public LDFactory() {
        
    }

    @Override
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
