package com.hank.design.enjoyyuanmode;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-16 12:00
 */
public class CirCle implements Shape {

    private int x;

    private int y;

    private String color;

    private int radius;


    public CirCle(String color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("DrawCirCle{" +
                "x=" + x +
                ", y=" + y +
                ", color='" + color + '\'' +
                ", radius=" + radius +
                '}');
    }

    @Override
    public String toString() {
        return "CirCle{" +
                "x=" + x +
                ", y=" + y +
                ", color='" + color + '\'' +
                ", radius=" + radius +
                '}';
    }
}
