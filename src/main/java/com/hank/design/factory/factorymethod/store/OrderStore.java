package com.hank.design.factory.factorymethod.store;

import com.hank.design.factory.factorymethod.order.BJOrderPizza;

/**
 * @author lxt
 * @date 2019-12-09-17:15
 */
public class OrderStore {
    public static void main(String[] args) {
        //订购不同的披萨
        new BJOrderPizza();
    }
}
