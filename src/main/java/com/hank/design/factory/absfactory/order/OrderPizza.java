package com.hank.design.factory.absfactory.order;


import com.hank.design.factory.absfactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lxt
 * @date 2019-12-09-17:01
 * 抽象工厂模式披萨订购解决方案
 */
public class OrderPizza {

    private AbsFactory absFactory;

    private void setAbsFactory(AbsFactory absFactory) {
        this.absFactory = absFactory;
        String orderType;
        do {
            orderType = getType();
            //交给工厂类来实现
            final Pizza pizza = this.absFactory.createPizza(orderType);
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

    public OrderPizza(AbsFactory absFactory) {
        setAbsFactory(absFactory);
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
