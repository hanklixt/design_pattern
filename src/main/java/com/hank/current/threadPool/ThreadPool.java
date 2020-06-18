package com.hank.current.threadPool;



import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-16 17:21
 */
public class ThreadPool {

    private BlockQueue<Runnable> queue=new BlockQueue<>(20);

    private static HashSet<Worker> workers=new HashSet<>();
    /**
     * 核心线程
     */
    private int coreSize;

    private TimeUnit timeUnit;

    private RejectPolicy<Runnable> rejectPolicy;


    private void execute(Runnable task){
        synchronized (workers){
            //如果池中核心线程数可用
            if (workers.size()<coreSize){
            Worker worker = new Worker(task);
            workers.add(worker);
            System.out.println("核心线程运行");
            worker.start();
        }else {
                //一直阻塞，直到加入队列
                queue.put(task);
                //拒绝策略
                rejectPolicy.reject(queue,task);
        }

        }
    }


    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(new BlockQueue<Runnable>(20),10,TimeUnit.MILLISECONDS,(queue,task)->{
            //让调用者自己自己执行
            task.run();
        });

        for (int i = 0; i <10 ; i++) {
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }

    }



    public ThreadPool(BlockQueue<Runnable> queue, int coreSize, TimeUnit timeUnit, RejectPolicy<Runnable> rejectPolicy) {
        this.queue = queue;
        this.coreSize = coreSize;
        this.timeUnit = timeUnit;
        this.rejectPolicy = rejectPolicy;
    }

    class  Worker extends  Thread{

        private Runnable task;

        public Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
           while (task!=null||(task=queue.take(timeUnit,1))!=null){
               try{
                   System.out.println("执行任务" + task);
                   //由调用线程自己调用
                   task.run();
               }finally {
                   task=null;
               }
           }
           synchronized (workers){
               System.out.println("worker"+ this+"被移除");
               //先不管是不是阻塞队列中的，每次走到这里，都把核心线程输减少
               workers.remove(this);
           }

        }
    }
}

