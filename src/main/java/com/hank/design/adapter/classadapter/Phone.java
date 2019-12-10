package com.hank.design.adapter.classadapter;

/**
 * @author lxt
 * @date 2019-12-10-17:08
 */
public class Phone {
    public void charging(VoltageAdapter5V voltageAdapter5V) {
        if (voltageAdapter5V.transformation() == 5) {
            System.out.println("可以充电");
        } else {
            System.out.println("不能充电");
        }
    }
}
