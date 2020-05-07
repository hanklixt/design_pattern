package com.hank.design.observer.tradition;

/**
 * @author lxt
 * @date 2019-12-11-16:06
 * @update
 * 当前天气接口接入方
 */
public class CurrentCondition {

    //温度
    private float temperature;
    //气压
    private float pressure;
    //气压
    private float humidity;

    //更新天气信息
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    //展示天气信息
    public void display() {
        System.out.println("温度" + temperature + "***");
        System.out.println("湿度" + humidity + "***");
        System.out.println("企业" + pressure + "***");
    }


}
