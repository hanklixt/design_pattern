package com.hank.design.facoty.simplafactory.order;

import com.hank.design.facoty.simplafactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 简单工厂披萨订购解决方案
 */
public class OrderPizza1 {

    private SimpleFactory simpleFactory;

    private void setSimpleFactory(SimpleFactory simpleFactory) {
        this.simpleFactory = simpleFactory;
    }

    public OrderPizza1() {
        setSimpleFactory(new SimpleFactory());
        Pizza pizza = null;
        String orderType;
        do {
            orderType = getType();
            pizza = simpleFactory.createPizza(orderType);
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购失败!!!暂无商品:" + orderType + "pizza");
                break;
            }
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
