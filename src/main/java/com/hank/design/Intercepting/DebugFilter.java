package com.hank.design.Intercepting;

import java.io.Serializable;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-07 11:35
 * 2.实现过滤器接口
 */
public class DebugFilter implements Filter {
    @Override
    public void execute(String request) {
        System.out.println("execute debug"+request);
    }
}
