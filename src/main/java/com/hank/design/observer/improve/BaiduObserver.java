package com.hank.design.observer.improve;

/**
 * @author lxt
 * @date 2019-12-11-16:06
 * 当前天气接口接入方
 */
public class BaiduObserver implements Observer {


    //温度
    private float temperature;
    //气压
    private float pressure;
    //气压
    private float humidity;

    //更新天气信息
    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    //展示天气信息
    public void display() {
        System.out.println("百度温度" + temperature + "***");
        System.out.println("百度湿度" + humidity + "***");
        System.out.println("百度企业" + pressure + "***");
    }


}
