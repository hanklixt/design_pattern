package com.hank.design.template;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-08 13:23
 */
public class BGame extends Game {
    @Override
    void init() {
        System.out.println("B game init");
    }

    @Override
    void start() {
        System.out.println("B game start");
    }

    @Override
    void end() {
        System.out.println("C game end");
    }
}
