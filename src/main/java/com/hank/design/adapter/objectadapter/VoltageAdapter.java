package com.hank.design.adapter.objectadapter;


/**
 * @author lxt
 * @date 2019-12-10-17:11
 * 适配者-转换电压
 */
public class VoltageAdapter implements VoltageAdapter5V {

    private Voltage220V voltage220V;

    public void setVoltage220V(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    /**
     * 电压适配操作
     *
     * @return
     */
    @Override
    public int transformation() {
        if (voltage220V == null) {
            System.out.println("无法获取被适配电源电源");
            return 0;
        }
        final int srcV = voltage220V.outVoltage();
        System.out.println("电源输出电压" + srcV);
        final int outV = srcV / 40;
        System.out.println("适配器转换电压" + outV);
        return outV;
    }
}
