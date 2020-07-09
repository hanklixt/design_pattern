package com.hank.algorithm.list;


import java.util.LinkedList;

/**
 * 模仿linkedList的实现
 * @param <T>
 */
public class SimpleList<T> {

    //头节点
    Node<T> first;

    //尾节点
    Node<T> last;

    /**
     * 节点长度
     */
    public int size;

    //修改次数
    transient int modCount;


    public SimpleList() {
    }


    private Node<T> node(int index){

      if (index>=size){
          throw new RuntimeException("index out of size");
      }
        //类似二分的操作
        if (index<(size>>1)){
            Node<T> node=first;
            for (int i=0;i<index;i++){
                node=node.next;
            }
            return node;
        }else {
            Node<T> node=last;
            for (int i=0;i<index;i++){
                node=node.prev;
            }
            return node;
        }
    }



    //
    public T remove(int index){
        Node<T> node = node(index);
        T data = node.data;
        if (node.prev==null){
             first=node;
        }else {
            node.prev.next=node.next;
        }
        if (node.next==null){
            last=node;
        }else {
            node.next.prev=node.prev;
        }
        size--;
        modCount++;
        return data;
    }

    //双向链表
    public void add(T data) {
        final Node<T> node = last;
        final Node<T> newNode = new Node<T>(null, node, data);
        last = newNode;
        if (first == null){
            first = newNode;
        }else {
            if (node!=null){
                node.next=newNode;
            }else {
                first.next=newNode;
            }
        }
            modCount++;
            size++;
    }

    //从头开始查找--删除
    public boolean remove(T data){
        for (Node<T> node=first;node.next!=null;node=node.next){
            if (data.equals(node.data)){
                node.prev.next=node.next;
                node.next.prev=node.prev;
                size--;
                modCount++;
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        SimpleList<Integer> list = new SimpleList<>();
        for (int i=0;i<10;i++){
            list.add(i);
        }
        boolean remove = list.remove(Integer.valueOf(10));
        System.out.println(remove);
        list.remove(0);

        System.out.println("co");

    }


    private static class Node<T>{
        Node prev,next;
        T data;

        public Node(Node next, Node prev, T data) {
            this.prev = prev;
            this.next = next;
            this.data =  data;
        }
    }

}

