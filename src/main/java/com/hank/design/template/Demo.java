package com.hank.design.template;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-08 13:25
 */
public class Demo {

    /**
     * 模板方法模式
     * @param args
     */

    public static void main(String[] args) {
        AGame aGame = new AGame();
        aGame.play();


        System.out.println("----------------------------");

        BGame bGame = new BGame();
        bGame.play();
    }
}
