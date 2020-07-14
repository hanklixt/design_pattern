package com.hank.algorithm.queue;

import com.hank.current.commonMethod.DaemonTest;

/**
 * 链式无界队列
 * @param <T>
 */
public class ListQueue<T> {

    private Node<T> node;

    private int head;

    private int tail;
    public ListQueue() {

     }

    private T enqueue(T data){
        if (node==null){
            node=new Node<>(data);
            return data;
        }
        Node n=node;
        while (n.next!=null){
        n=n.next;
        }
        n.next=new Node(data);
        ++tail;
        return data;
    }

    private T dequeue(){
        if (node.data==null){
            return null;
        }
        T data;
        int i=0;
        Node t;
        for (t=node;t.next!=null;t=t.next ){
              if (i==head){
                  head++;
                  data= (T) t.data;
                  return data;
              }
            ++i;
        }
        if (t==null){
            i++;
            return null;
        }

        return (T) t.data;
    }

    private class Node<T>{
        private Node next;
        private T data;
        public Node( T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        ListQueue<Integer> queue = new ListQueue<>();
        for (int i=0;i<10;i++){
            Integer enqueue = queue.enqueue(i);
        }
        System.out.println("入队完毕");
        for (int i=0;i<10;i++){
            System.out.println(queue.dequeue());
        }
        System.out.println("全部出队");
    }
}
