package com.hank.design.decorator;

/**
 * @author lxt
 * @date 2019-12-11-14:07
 * 被装饰者
 */
public class LongBlackCoffee extends Coffee {

    public LongBlackCoffee() {
        setPrice(5.0f);
        setDes("美式咖啡");
        System.out.println("订购1杯美式咖啡");
    }


}
