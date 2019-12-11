package com.hank.design.observer.improve;

/**
 * @author lxt
 * @date 2019-12-11-16:55
 */
public interface Subject {
    //消费者方注册
    public void registerObserver(Observer observer);

    //移除订阅方
    public void removeObserver(Observer observer);

    //通知消费方
    public void notifyObservers(float temperature, float pressure, float humidity);

}
