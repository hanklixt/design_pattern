package com.hank.design.factory.absfactory.pizza;

/**
 * @author lxt
 * @date 2019-12-09-16:50
 */
public class LDCheesePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("LDCheesePizza,准备材料");
    }
}
