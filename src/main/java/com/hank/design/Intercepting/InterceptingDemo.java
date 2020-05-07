package com.hank.design.Intercepting;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-07 13:09
 */
public class InterceptingDemo {


    public static void main(String[] args) {

        Target target = new Target();
        FilterManger filterManger = new FilterManger(target);
        AuthenticationFilter authenticationFilter = new AuthenticationFilter();
        DebugFilter debugFilter = new DebugFilter();
        filterManger.setFilter(authenticationFilter);
        filterManger.setFilter(debugFilter);

        Client client = new Client();
        client.setFilterManger(filterManger);
        client.sendRequest("test");


    }
}
