package com.hank.design.adapter.classadapter;

import com.hank.design.adapter.objectadapter.Voltage220V;
import com.hank.design.adapter.objectadapter.VoltageAdapter5V;

/**
 * @author lxt
 * @date 2019-12-10-17:11
 * 适配者-转换电压
 */
public class VoltageAdapter extends Voltage220V implements VoltageAdapter5V {
    /**
     * 电压适配操作
     *
     * @return
     */
    @Override
    public int transformation() {
        final int srcV = outVoltage();
        System.out.println("电源输出电压" + srcV);
        final int outV = srcV / 40;
        System.out.println("适配器转换电压" + outV);
        return outV;
    }
}
