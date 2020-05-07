package com.hank.design.Intercepting;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-07 13:05
 * 6.创建客户端
 */
public class Client {

    private FilterManger filterManger;

    public void setFilterManger(FilterManger filterManger){
        this.filterManger=filterManger;
    }

    public void sendRequest(String request){
        filterManger.filterRequest(request);
    }



}
