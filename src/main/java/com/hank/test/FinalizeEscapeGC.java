package com.hank.test;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-10 11:45
 */
public class FinalizeEscapeGC {

    /**
     * 可达性分析
     * 假如对象没有覆盖finalize()方法，或者finalize()方法已经被虚拟机调用
     *
     * 过，那么虚拟机将这两种情况都视为“没有必要执行”
     *
     * 其余情况，会调用该对象的finalize()判断是否继续调用，这是判断该对象是否存活的最后一步
     */
    public static FinalizeEscapeGC SAVE_Hook=null;

    public void isAlive(){
        System.out.println("yes , i am still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize execute");
        FinalizeEscapeGC.SAVE_Hook=this;
    }

    public static void main(String[] args) {
        SAVE_Hook = new FinalizeEscapeGC();

        SAVE_Hook=null;

        System.gc();
        /**
         * 对象的finalize方法会延迟执行，这里等待一下
         */
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (SAVE_Hook!=null){
            SAVE_Hook.isAlive();
        }
        SAVE_Hook=null;
        System.gc();
         /**
         * 对象的finalize方法会延迟执行，这里等待一下
        */
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (SAVE_Hook!=null) {
            SAVE_Hook.isAlive();
        }else {System.out.println("no, i am dead :(");
        }



    }

}
