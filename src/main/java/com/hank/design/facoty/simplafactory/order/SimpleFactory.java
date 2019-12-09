package com.hank.design.facoty.simplafactory.order;

import com.hank.design.facoty.simplafactory.pizza.CheesePizza;
import com.hank.design.facoty.simplafactory.pizza.GreekPizza;
import com.hank.design.facoty.simplafactory.pizza.PepperPizza;
import com.hank.design.facoty.simplafactory.pizza.Pizza;

/**
 * @author lxt
 * @date 2019-12-09-15:55
 * 简单工厂模式
 */
public class SimpleFactory {

    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName("GreekPizza");
        } else if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName("CheesePizza");
        } else if (orderType.equals("pepper")) {
            pizza = new PepperPizza();
            pizza.setName("PepperPizza");
        }
        return pizza;

    }
}
