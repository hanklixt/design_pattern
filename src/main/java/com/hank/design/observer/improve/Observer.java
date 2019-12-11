package com.hank.design.observer.improve;

/**
 * @author lxt
 * @date 2019-12-11-16:59
 */
public interface Observer {

    //更新天气信息
    public void update(float temperature, float pressure, float humidity);

}
