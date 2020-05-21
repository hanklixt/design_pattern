package com.hank.design.template.fun;

import java.util.function.Consumer;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-08 22:00
 */
public class Game {

    public  void play(String game,Consumer<String> ... funs){
        for (Consumer aa: funs) aa.accept(game);
    }
}
