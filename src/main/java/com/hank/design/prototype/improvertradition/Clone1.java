package com.hank.design.prototype.improvertradition;

/**
 * @author lxt
 * @date 2019-12-10-11:39
 * 直接调用父类clone方法，对于基本类型是可以拷贝的，但是对于数组和包装类型，使用的是引用方式拷贝，即浅拷贝
 */
public class Clone1 {
    public static void main(String[] args) {
        final Sheep1 sheep = new Sheep1("tom", 12, "黄色");
        sheep.friend = new Sheep1("jack", 12, "白色");
        final Sheep1 sheep1 = (Sheep1) sheep.clone();
        final Sheep1 sheep2 = (Sheep1) sheep.clone();
        final Sheep1 sheep3 = (Sheep1) sheep.clone();
        final Sheep1 sheep4 = (Sheep1) sheep.clone();
        final Sheep1 sheep5 = (Sheep1) sheep.clone();
        final Sheep1 sheep6 = (Sheep1) sheep.clone();
        System.out.println(sheep);
        System.out.println("sheep:" + sheep.hashCode() + "  sheepfriend" + sheep.friend.hashCode());
        System.out.println(sheep1);
        System.out.println("sheep1:" + sheep1.hashCode() + "  sheepfriend" + sheep1.friend.hashCode());
        System.out.println(sheep2);
        System.out.println("sheep2:" + sheep2.hashCode() + "  sheepfriend" + sheep2.friend.hashCode());
        System.out.println(sheep3);
        System.out.println("sheep3:" + sheep3.hashCode() + "  sheepfriend" + sheep3.friend.hashCode());
        System.out.println(sheep4);
        System.out.println("sheep4:" + sheep4.hashCode() + "  sheepfriend" + sheep4.friend.hashCode());
        System.out.println(sheep5);
        System.out.println("sheep5:" + sheep5.hashCode() + "  sheepfriend" + sheep5.friend.hashCode());
        System.out.println(sheep6);
        System.out.println("sheep6:" + sheep6.hashCode() + " sheepfriend" + sheep6.friend.hashCode());
    }
}
