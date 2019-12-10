package com.hank.design.prototype.deepclone;

import java.io.*;

public class DeepProtoType implements Serializable, Cloneable {

    public String name;
    //引用类已经集成Cloneable且实现clone方法
    public DeepCloneableTarget deepCloneableTarget;

    public DeepProtoType() {
        super();
    }

    //1.实现深拷贝克隆方法之重写clone方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //1.对基本类型和String进行克隆
        final DeepProtoType deepProtoType = (DeepProtoType) super.clone();
        //对其他类型的属性进行clone
        deepProtoType.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();
        return deepProtoType;
    }
    //2.实现深拷贝克隆方法之通过序列化方式实现，(推荐)

    public DeepProtoType deepClone() throws IOException {

        ByteArrayInputStream bis = null;
        ByteArrayOutputStream bos = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            //序列化
            bos = new ByteArrayOutputStream();
            //创建对象输出流
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            return (DeepProtoType) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                bis.close();
            }
            if (bos != null) {
                bos.close();
            }
            if (ois != null) {
                ois.close();
            }
            if (oos != null) {
                oos.close();
            }
        }
        return null;
    }

}
