package com.hank.design.prototype.deepclone;

import java.io.IOException;

/**
 * @author lxt
 * @date 2019-12-10-13:52
 */
public class Clone {
    public static void main(String[] args) throws CloneNotSupportedException, IOException {
        final DeepProtoType deepProtoType = new DeepProtoType();
        deepProtoType.name = "张三";
        deepProtoType.deepCloneableTarget = new DeepCloneableTarget("李四", "deepCloneableTarget");
        //验证方式1克隆
        final DeepProtoType deepProtoType1 = (DeepProtoType) deepProtoType.clone();
        System.out.println(deepProtoType.hashCode() + ",deepCloneableTarget:" + deepProtoType.deepCloneableTarget.hashCode());
        System.out.println(deepProtoType1.hashCode() + ",deepCloneableTarget:" + deepProtoType1.deepCloneableTarget.hashCode());
        //验证方式2克隆
        final DeepProtoType deepProtoType2 = deepProtoType.deepClone();
        System.out.println(deepProtoType2.hashCode() + ",deepCloneableTarget:" + deepProtoType2.deepCloneableTarget.hashCode());

    }
}
