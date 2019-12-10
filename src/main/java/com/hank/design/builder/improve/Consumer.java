package com.hank.design.builder.improve;

/**
 * @author lxt
 * @date 2019-12-10-15:25
 */
public class Consumer {
    public static void main(String[] args) {
        final House build = new CommonHouse().build();
        System.out.println(build);

        //指挥者生产房子
        final House constructor = new HouseDirector(new CommonHouse()).constructor();
        System.out.println(constructor);
    }
}
