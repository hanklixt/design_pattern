package com.hank.design.factory.absfactory.pizza;

public abstract class Pizza {
    protected String name;

    //准备原材料
    public abstract void prepare();

    //烘焙
    public void bake() {
        System.out.println(name + " baking;");
    }

    //切割
    public void cut() {
        System.out.println(name + " cutting;");
    }

    //打包
    public void box() {
        System.out.println(name + " boxing;");
    }

    public void setName(String name) {
        this.name = name;
    }
}
