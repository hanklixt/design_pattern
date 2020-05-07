package com.hank.design.Intercepting;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-07 11:37
 * 3.创建target
 */
public class Target {
    public void execute(String request){
        System.out.println("execute request"+request);
    }


}
