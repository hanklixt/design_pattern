package com.hank.design.decorator;

/**
 * @author lxt
 * @date 2019-12-11-14:53
 * 被装饰者
 */
public class ItalianCoffee extends Coffee {

    public ItalianCoffee(int num) {
        super(num);
        setDes("意大利咖啡");
        setPrice(5.8f);
        System.out.println("订购" + num + "杯意大利咖啡");
    }
}
