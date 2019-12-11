package com.hank.design.observer.tradition;

/**
 * @author lxt
 * @date 2019-12-11-16:12
 */
public class Client {
    public static void main(String[] args) {
        final CurrentCondition currentCondition = new CurrentCondition();
        final WeatherData weatherData = new WeatherData(currentCondition);
        weatherData.setData(32, 11, 50);
    }
}
