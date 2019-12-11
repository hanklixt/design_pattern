package com.hank.design.decorator;

/**
 * @author lxt
 * @date 2019-12-11-14:51
 * 该类定义单品咖啡公有的方法处理
 */
public class Coffee extends Drink {


    //直接返回单品咖啡的价格
    @Override
    public float cost() {
        return getPrice();
    }
}
