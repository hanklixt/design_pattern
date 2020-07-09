package com.hank.algorithm.list;

/**
 * 单向链表
 * @param <E>
 */
public class SimpleSingleList<E> {

    Node<E> head;

    public int size;

    public int modCount;


    public SimpleSingleList() {

    }

    public SimpleSingleList(Node<E> head) {
        this.head = head;
    }

    private static class Node<E>{
        Node<E> next;
        E data;
        public Node(Node<E> next, E data) {
            this.next = next;
            this.data = data;
        }
    }


    public boolean add(E data){
        Node<E> node;
        final Node<E> newNode = new Node<>(null, data);
            if (head!=null){
                node=head.next;
                while (node!=null&&node.next!=null){
                    node=node.next;
                }
                if (node!=null){
                    node.next=newNode;
                }else {
                    head.next=newNode;
                }
            }else {
                head=newNode;
            }
        size++;
        modCount++;
        return true;
    }

    public boolean remove(E data){
        Node<E> prev=null;
        for (Node<E> node=head;node.next!=null;node=node.next){
            if (data.equals(node.data)){
                if (prev!=null){
                    prev.next=node.next;
                    size--;
                    modCount++;
                    return true;
                }
                //上一个节点为空，就
              }
            prev=node;
        }
        return false;
    }


    public static void main(String[] args) {
        SimpleSingleList<String> singleList = new SimpleSingleList<>();
        for (int i=0;i<10;i++){
            singleList.add(String.valueOf(i));
        }
        boolean remove = singleList.remove("3");

        System.out.println(remove);

    }







}
