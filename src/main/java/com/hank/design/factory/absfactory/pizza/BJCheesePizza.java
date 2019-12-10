package com.hank.design.factory.absfactory.pizza;

/**
 * @author lxt
 * @date 2019-12-09-16:50
 * 北京奶酪披萨
 */
public class BJCheesePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println(" BJCheesePizza,准备材料");
    }
}
