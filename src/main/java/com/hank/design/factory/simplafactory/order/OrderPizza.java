package com.hank.design.factory.simplafactory.order;

import com.hank.design.factory.simplafactory.pizza.CheesePizza;
import com.hank.design.factory.simplafactory.pizza.GreekPizza;
import com.hank.design.factory.simplafactory.pizza.PepperPizza;
import com.hank.design.factory.simplafactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 传统方式披萨订购解决方案
 */
public class OrderPizza {

    public OrderPizza() {
        Pizza pizza = null;
        String orderType;
        do {
            orderType = getType();
            if (orderType.equals("greek")) {
                pizza = new GreekPizza();
                pizza.setName("GreekPizza");
            } else if (orderType.equals("cheese")) {
                pizza = new CheesePizza();
                pizza.setName("CheesePizza");
            } else if (orderType.equals("pepper")) {
                pizza = new PepperPizza();
                pizza.setName("PepperPizza");
            } else {
                break;
            }
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();

        } while (true);
    }


    //获取披萨类型
    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            return strin.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
