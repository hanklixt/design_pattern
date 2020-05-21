package com.hank.design.template.fun;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-10 10:40
 */
public class FunDemo {

    public static void main(String[] args) {

        String str1 = new StringBuilder("计算机").append("软件").toString();

        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();

        System.out.println(str2.intern() == str2);

    }

}
