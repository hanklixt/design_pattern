package com.hank.design.observer.improve;

/**
 * @author lxt
 * @date 2019-12-11-17:13
 */
public class Client {
    public static void main(String[] args) {
        final WeatherData weatherData = new WeatherData();
        weatherData.registerObserver(new CurrentCondition());
        weatherData.registerObserver(new BaiduObserver());
        weatherData.setData(20, 10, 42);
    }
}
