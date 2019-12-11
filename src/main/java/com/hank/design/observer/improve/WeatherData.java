package com.hank.design.observer.improve;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author lxt
 * @date 2019-12-11-16:06
 * 气象局监控天气情况
 */
public class WeatherData implements Subject {

    //温度
    private float temperature;
    //气压
    private float pressure;
    //气压
    private float humidity;

    private CopyOnWriteArrayList<Observer> observers = new CopyOnWriteArrayList<Observer>();


    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        dateChange(this.temperature, this.pressure, this.humidity);
    }

    public void dateChange(float temperature, float pressure, float humidity) {
        notifyObservers(temperature, pressure, humidity);
    }

    //注册观察者
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    //移除观察者
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    //给观察者发送通知
    @Override
    public void notifyObservers(float temperature, float pressure, float humidity) {
        observers.forEach(x -> {
            x.update(temperature, pressure, humidity);
        });
    }
}
