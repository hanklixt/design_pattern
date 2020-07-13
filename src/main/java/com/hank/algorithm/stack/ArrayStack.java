package com.hank.algorithm.stack;

/**
 * 顺序栈简单实现
 */
public class ArrayStack<T> {

    private Object[] objects;

    private int count;

    private int length;

    public ArrayStack(int count, int length) {
        this.objects = new Object[length];
        this.count = count;
        this.length = length;
    }

    private T push(T data){
        if (count>=length){
            Object[] newObj=objects;
            int n=length<<1;
            objects=new Object[n];
            System.arraycopy(newObj,0,objects,0,length);
            length=n;
        }
        objects[count]=data;
        count++;
        return data;
    }

    private  T pop(){
        if (count==0){
            return null;
        }
       T d = (T)objects[count-1];
        objects[count-1]=null;
        count--;
        return d;
    }


    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(0, 3);
        for (int i=0;i<10;i++){
            stack.push(i);
        }
        System.out.println("ss");
        for (int i=0;i<10;i++){
            System.out.println(stack.pop());
        }
        System.out.println("nb");
    }



}
