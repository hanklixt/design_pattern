package com.hank.algorithm.map;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-22 9:16
 */
public class ListNode<K,V> {

    private K k;

    private V v;

    public K getKey(){
        return k;
    }

    public V getV(){
        return v;
    }

    public void setV(V v){
        this.v=v;
    }

    public ListNode<K,V> nextNode;

    public ListNode(K k,V v){
      this.k=k;
      this.v=v;
    }



}
