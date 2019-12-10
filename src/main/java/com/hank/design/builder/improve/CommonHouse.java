package com.hank.design.builder.improve;

/**
 * @author lxt
 * @date 2019-12-10-15:09
 * 实现者(可有多个实现)
 */
public class CommonHouse implements HouseBuilder {
    @Override
    public String buildBasic() {
        System.out.println("打地基五米");
        return "地基五米";
    }

    @Override
    public String buildWall() {
        System.out.println("砌墙30厘米");
        return "砌墙30厘米";
    }

    @Override
    public String buildTop() {
        System.out.println("封顶顶部厚50厘米");
        return "封顶顶部厚50厘米";
    }
}
