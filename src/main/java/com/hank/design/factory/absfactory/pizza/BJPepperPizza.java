package com.hank.design.factory.absfactory.pizza;

/**
 * @author lxt
 * @date 2019-12-09-16:51
 */
public class BJPepperPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("BJPepperPizza准备材料");
    }
}
