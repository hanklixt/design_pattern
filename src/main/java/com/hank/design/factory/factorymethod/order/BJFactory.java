package com.hank.design.factory.factorymethod.order;

import com.hank.design.factory.factorymethod.pizza.BJCheesePizza;
import com.hank.design.factory.factorymethod.pizza.BJGreekPizza;
import com.hank.design.factory.factorymethod.pizza.BJPepperPizza;
import com.hank.design.factory.factorymethod.pizza.Pizza;

/**
 * @author lxt
 * @date 2019-12-09-17:09
 */
public class BJFactory extends OrderPizza {
    @Override
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
