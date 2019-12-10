package com.hank.design.builder.tradition;

/**
 * @author lxt
 * @date 2019-12-10-14:34
 */
public abstract class AbsHouse {
    //打地基
    public abstract void buildBasic();

    //砌墙
    public abstract void buildWar();

    //封顶
    public abstract void buildTop();

    /**
     * 修房子
     */
    public void build() {
        buildBasic();
        buildWar();
        buildTop();
    }

}
