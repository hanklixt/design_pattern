package com.hank.design.factory.absfactory.order;

import com.hank.design.factory.absfactory.pizza.Pizza;

/**
 * @author lxt
 * @date 2019-12-10-9:41
 * 抽象工厂父类
 */
public interface AbsFactory {
    Pizza createPizza(String orderType);
}
