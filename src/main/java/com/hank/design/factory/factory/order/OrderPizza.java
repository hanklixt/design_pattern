package com.hank.design.factory.factory.order;

import com.hank.design.factory.factory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lxt
 * @date 2019-12-09-17:01
 * 工厂模式披萨订购解决方案
 */
public abstract class OrderPizza {


    public abstract Pizza createPizza(String orderType);

    public OrderPizza() {
        String orderType;
        do {
            orderType = getType();
            //交给工厂类来实现
            final Pizza pizza = createPizza(orderType);
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
