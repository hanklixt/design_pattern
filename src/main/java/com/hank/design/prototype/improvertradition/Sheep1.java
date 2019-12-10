package com.hank.design.prototype.improvertradition;

import java.io.Serializable;

/**
 * @author lxt
 * @date 2019-12-10-10:31
 * 克隆羊
 */
public class Sheep1 implements Cloneable, Serializable {
    private String name;
    private int age;
    private String color;
    public Sheep1 friend;

    public Sheep1(String name, int age, String color) {
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

    @Override
    protected Object clone() {
        Sheep1 sheep = null;
        try {
            sheep = (Sheep1) super.clone();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sheep;
    }
}
