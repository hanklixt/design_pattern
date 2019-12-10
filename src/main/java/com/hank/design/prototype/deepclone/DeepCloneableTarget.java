package com.hank.design.prototype.deepclone;

import java.io.Serializable;

public class DeepCloneableTarget implements Serializable, Cloneable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String cloneName;

    private String cloneClass;

    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    //由于都是基本类型和String,直接调用父类的clone既可
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
