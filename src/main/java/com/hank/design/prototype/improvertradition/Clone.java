package com.hank.design.prototype.improvertradition;

/**
 * @author lxt
 * @date 2019-12-10-10:34
 * 克隆羊问题传统解决方案
 */
public class Clone {
    public static void main(String[] args) {
        final Sheep sheep = new Sheep("tom", 12, "黄色");
        final Sheep sheep1 = (Sheep) sheep.clone();
        final Sheep sheep2 = (Sheep) sheep.clone();
        final Sheep sheep3 = (Sheep) sheep.clone();
        final Sheep sheep4 = (Sheep) sheep.clone();
        final Sheep sheep5 = (Sheep) sheep.clone();
        final Sheep sheep6 = (Sheep) sheep.clone();
        System.out.println(sheep);
        System.out.println(sheep.hashCode());
        System.out.println(sheep1);
        System.out.println(sheep1.hashCode());
        System.out.println(sheep2);
        System.out.println(sheep2.hashCode());
        System.out.println(sheep3);
        System.out.println(sheep3.hashCode());
        System.out.println(sheep4);
        System.out.println(sheep4.hashCode());
        System.out.println(sheep5);
        System.out.println(sheep5.hashCode());
        System.out.println(sheep6);
        System.out.println(sheep6.hashCode());
    }
}
