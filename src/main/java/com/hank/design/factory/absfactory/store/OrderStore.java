package com.hank.design.factory.absfactory.store;

import com.hank.design.factory.absfactory.order.BjFactory;
import com.hank.design.factory.absfactory.order.OrderPizza;

/**
 * @author lxt
 * @date 2019-12-10-9:41
 * 抽象工厂模式
 */
public class OrderStore {
    public static void main(String[] args) {
        new OrderPizza(new BjFactory());
    }
}
