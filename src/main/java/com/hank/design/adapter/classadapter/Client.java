package com.hank.design.adapter.classadapter;

import com.hank.design.adapter.objectadapter.Phone;
import com.hank.design.adapter.objectadapter.VoltageAdapter;

/**
 * @author lxt
 * @date 2019-12-10-17:14
 */
public class Client {
    public static void main(String[] args) {
        final Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}
