package com.hank.current.pojo;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-15 10:10
 */
public class Student {

    private volatile int age;
    private volatile String name;

    public Student() {

    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
