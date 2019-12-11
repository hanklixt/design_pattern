package com.hank.design.bridge;

/**
 * @author lxt
 * @date 2019-12-11-10:58
 * 桥接模式（手机-多样式-多品牌）
 */
public class Client {
    public static void main(String[] args) {
        final FolderedPhone folderedPhone = new FolderedPhone(new XiaoMi());
        folderedPhone.open();
        folderedPhone.call();
        folderedPhone.close();

        final FolderedPhone huawei = new FolderedPhone(new HuaWei());
        huawei.open();
        huawei.call();
        huawei.close();


    }
}
