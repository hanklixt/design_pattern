package com.hank.design.observer.tradition;

/**
 * @author lxt
 * @date 2019-12-11-16:06
 * 气象局监控天气情况
 */
public class WeatherData {


    //温度
    private float temperature;
    //气压
    private float pressure;
    //气压
    private float humidity;

    private CurrentCondition condition;

    public WeatherData(CurrentCondition condition) {
        this.condition = condition;
    }

    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        dateChange(temperature, pressure, humidity);
    }

    public void dateChange(float temperature, float pressure, float humidity) {
        condition.update(temperature, pressure, humidity);

    }
}
