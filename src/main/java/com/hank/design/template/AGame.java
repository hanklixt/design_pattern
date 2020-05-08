package com.hank.design.template;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-08 13:21
 */
public class AGame extends Game {
    @Override
    void init() {
        System.out.println("A game init");
    }

    @Override
    void start() {
        System.out.println("A game start");
    }
    @Override
    void end() {

        System.out.println("A game end");

    }
}
