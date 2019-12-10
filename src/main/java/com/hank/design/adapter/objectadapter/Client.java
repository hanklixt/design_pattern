package com.hank.design.adapter.objectadapter;


/**
 * @author lxt
 * @date 2019-12-10-17:14
 */
public class Client {
    public static void main(String[] args) {
        final Phone phone = new Phone();
        final VoltageAdapter voltageAdapter = new VoltageAdapter();
        voltageAdapter.setVoltage220V(new Voltage220V());
        phone.charging(voltageAdapter);
    }
}
