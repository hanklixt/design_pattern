package com.hank.design.builder.improve;

/**
 * @author lxt
 * @date 2019-12-10-15:06
 * 建造者
 */
public interface HouseBuilder {

    House house = new House();

    public String buildBasic();

    public String buildWall();

    public String buildTop();

    public default House build() {
        house.setBasic(buildBasic());
        house.setWall(buildWall());
        house.setTop(buildTop());
        return house;
    }

}
