package com.hank.design.decorator;

/**
 * @author lxt
 * @date 2019-12-11-14:01
 * 被装饰者，基类
 */
public abstract class Drink {
    private String des;
    private float price = 0.0f;


    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract float cost();
}
