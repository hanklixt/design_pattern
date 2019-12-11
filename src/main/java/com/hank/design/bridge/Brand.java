package com.hank.design.bridge;

/**
 * @author lxt
 * @date 2019-12-11-10:41
 * 桥接模式-定义品牌手机都有的功能
 */
public interface Brand {
    //开机
    public void open();

    //打电话
    public void call();

    //关机
    public void close();
}
