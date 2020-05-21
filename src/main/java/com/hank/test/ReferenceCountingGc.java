package com.hank.test;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-10 11:04
 */
public class ReferenceCountingGc {

    /**
     * 引用计数测试
     *
     *  [PSYoungGen: 6504K->744K(75776K)] 6504K->752K(249344K), 0.0009708 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     *
     *  并没有因为引用计数不为0放弃回收
     */

    public Object instance=null;

//    private static  final  int mb=1024*1024;
//
//    private byte[] bigByte=new byte[2*mb];


    public static void main(String[] args) {
        ReferenceCountingGc objA = new ReferenceCountingGc();
        ReferenceCountingGc objB = new ReferenceCountingGc();
        objA.instance=objB;
        objB.instance=objA;

        objA=null;
        objB=null;

        System.gc();



    }


}
