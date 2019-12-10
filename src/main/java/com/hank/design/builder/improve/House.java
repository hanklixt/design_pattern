package com.hank.design.builder.improve;

/**
 * @author lxt
 * @date 2019-12-10-15:01
 * 所需产品
 */
public class House {
    private String basic;
    private String wall;
    private String top;

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    @Override
    public String toString() {
        return "House{" +
                "basic='" + basic + '\'' +
                ", wall='" + wall + '\'' +
                ", top='" + top + '\'' +
                '}';
    }
}
