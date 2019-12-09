package com.hank.design.factory.factory.pizza;

/**
 * @author lxt
 * @date 2019-12-09-16:50
 */
public class LDGreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("LDGreekPizza,准备材料");
    }
}
