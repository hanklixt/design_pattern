package com.hank.design.builder.tradition;

/**
 * @author lxt
 * @date 2019-12-10-14:36
 */
public class CommonHouse extends AbsHouse {
    @Override
    public void buildBasic() {
        System.out.println("普通房子打地基");
    }

    @Override
    public void buildWar() {
        System.out.println("普通房子砌墙");
    }

    @Override
    public void buildTop() {
        System.out.println("普通房子封顶");
    }

}
