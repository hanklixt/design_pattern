package com.hank.design.template;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-08 12:10
 */
public abstract class Game {

    abstract void init();

    abstract void start();

    abstract void  end();

    public final void  play(){
        init();
        start();
        end();
    }
}
