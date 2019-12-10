package com.hank.design.builder.improve;

/**
 * @author lxt
 * @date 2019-12-10-15:14
 * 建造模式-指挥者
 * 可选择建造者实现
 */
public class HouseDirector {

    HouseBuilder houseBuilder;

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    //指挥者可以自定义先后顺序
    public House constructor() {
        final House house = new House();
        house.setBasic(houseBuilder.buildBasic());
        house.setWall(houseBuilder.buildWall());
        house.setTop(houseBuilder.buildTop());
        return house;
    }
}
