package com.hank.design.prototype.tradition;

/**
 * @author lxt
 * @date 2019-12-10-10:34
 * 克隆羊问题传统解决方案
 */
public class Clone {
    public static void main(String[] args) {
        final Sheep sheep = new Sheep("tom", 12, "黄色");
        final Sheep sheep1 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        final Sheep sheep2 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        final Sheep sheep3 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        final Sheep sheep4 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        final Sheep sheep5 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        System.out.println(sheep);
        System.out.println(sheep1);
        System.out.println(sheep2);
        System.out.println(sheep3);
    }
}
