package com.hank.algorithm.queue;

/***
 * 顺序队列--入栈复杂度O(1),出栈复杂度O(n)
 * @param <T>
 */
public class ArrayQueue<T> {
    private Object[] objects;
    //头标记位
    private int head;
    //尾标记位
    private int tail;
    //容量
    private int capability;
    //元素个数
    private int count;

    public ArrayQueue(int capability) {
        objects=new Object[capability];
        this.capability = capability;
    }
    /**
     * 入队
     * @param data
     * @return
     */
    private T queue(T data){
        if (count>=capability){
            return null;
        }
        objects[count]=data;
        ++count;
        ++tail;
        return data;
    }

    private Object[] getObj(){
        return objects;
    }

    //head最终保持不变，出队后把所有元素全部前移
    private T deQueue(){
        if (tail==head){
            return null;
        }
        Object object = objects[head];
        ++head;
        for (int n=head;n<tail;n++){
          objects [n-1] =  objects[n];
        }
        tail--;
        head--;
        count--;
        return (T) object;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(10);
        int i=0;
        while (i<10){
            queue.queue(i);
            i++;
        }

        while (i>0){
            System.out.println(queue.deQueue());
            i--;
        }

        while (i<10){
            queue.queue(i);
            i++;
        }

        Object[] obj = queue.getObj();
        for (int j=0;j<obj.length;j++){
            System.out.println(obj[j]);
        }


    }


}
