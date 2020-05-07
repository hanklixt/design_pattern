package com.hank.design.Intercepting;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-07 11:31
 * 拦截过滤器模式
 * 1.首先定义接口
 */
public interface Filter {


    public void execute(String request);


}
