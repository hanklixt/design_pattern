package com.hank.design.prototype.tradition;

/**
 * @author lxt
 * @date 2019-12-10-10:31
 * 克隆羊
 */
public class Sheep {
    private String name;
    private int age;
    private String color;

    public Sheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "name:" + name + ", age:" + age + ", color:" + color;
    }
}
