package com.hank.current.pattern.ProtectiveSuspension;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-04 15:00
 * 同步模式之保护性暂停
 */
public class GuardedObject {

    private Object response;

    public static void main(String[] args) {


        GuardedObject guardedObject = new GuardedObject();
        long l = System.currentTimeMillis();
        Thread completed = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            guardedObject.complete("completed");
        });
        completed.start();
        Object o = guardedObject.get();
        long l1 = System.currentTimeMillis();
         //同步方法
        System.out.println("耗时"+(l1 - l));
    }

    /**
     * 等待返回结果
     * @return
     */
    public Object get(){
        synchronized (this){
            while (response==null){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return response;
    }

    /**
     *将this对象上的waitSet上等待的线程全部唤醒
     */
    public void complete(Object response){
        synchronized (this){
            this.response=response;
            this.notifyAll();
        }


    }



}
