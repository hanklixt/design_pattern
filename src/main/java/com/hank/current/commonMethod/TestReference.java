package com.hank.current.commonMethod;


import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-13 19:44
 */
public class TestReference {

    private static AtomicReference<BigDecimal> sb=new AtomicReference<>(new BigDecimal("0"));


    public static void main(String[] args) {
//        test1();
//         testAba();
//    resolveABA();
        testMarkAble();
    }


    /**
     * casReference
     */
    private static void test1() {
        BigDecimal sh = sb.getAndUpdate((x) -> {
            return sb.get().add(BigDecimal.valueOf(2));
        });

        System.out.println(sh.toString());

        System.out.println(sb.get().toString());
    }

    /**
     * ABA问题test
     */
    private static void testAba(){
        AtomicReference<String> ref = new AtomicReference<>("A");

        String mains = ref.get();

        Thread thread = new Thread(() -> {
            System.out.println("change A->B");
            String prv = ref.get();
            //cas是原子操作
            ref.compareAndSet(prv,"B");

            String s = ref.get();

            System.out.println("change B->A");
            ref.compareAndSet(s,"A");
        });

        thread.start();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ref.compareAndSet(mains,"B");
        System.out.println("main change" + mains + "->" + ref.get());

    }

    private static void resolveABA(){

        AtomicStampedReference<String> ref = new AtomicStampedReference<>("A",0);

        //获取值
        String reference = ref.getReference();

        //获取版本号
        int stamp = ref.getStamp();

        Thread thread = new Thread(() -> {

            //cas是原子操作,更新知道版本号
            boolean a = ref.compareAndSet(ref.getReference(), "A", ref.getStamp(), ref.getStamp() + 1);

            System.out.println("change A->B:"+a);
            System.out.println("change B->A");
            boolean b = ref.compareAndSet(ref.getReference(), "B", ref.getStamp(), ref.getStamp() + 1);
            System.out.println("change B->A"+b);
        });

        thread.start();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean b = ref.compareAndSet(reference, "B", stamp, stamp + 1);
        System.out.println("main change "+"main ---->" + b);
        System.out.println(ref.getReference()+":"+ref.getStamp());


    }

    /**
     * AtomicMarkableReference
     */
    private static void testMarkAble(){

        GarbageBag garbageBag = new TestReference.GarbageBag("垃圾袋装满了");

        // mark可以当做一个垃圾袋，表示垃圾袋装满了
        AtomicMarkableReference<GarbageBag> markAble = new AtomicMarkableReference<GarbageBag>(garbageBag,true);

        System.out.println("主线程start");
        GarbageBag ref = markAble.getReference();
        Thread t1 = new Thread(() -> {
            System.out.println("打扫卫生的线程");
            ref.setDesc("垃圾被我倒了");
            //垃圾倒了，更新下标记
            markAble.compareAndSet(markAble.getReference(),ref,true,false);
            System.out.println("现在是个空垃圾袋");
        });

        t1.start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("现在main想换个垃圾袋");




        boolean b = markAble.compareAndSet(ref, markAble.getReference(), true, false);

        System.out.println("垃圾袋换了没?" + b);
    }

     static class GarbageBag{
        private String desc;

         public GarbageBag(String desc) {
             this.desc = desc;
         }

         public String getDesc() {
             return desc;
         }

         public void setDesc(String desc) {
             this.desc = desc;
         }

         @Override
         public String toString() {
             return "GarbageBag{" +
                     "desc='" + desc + '\'' +
                     '}';
         }
     }


}
