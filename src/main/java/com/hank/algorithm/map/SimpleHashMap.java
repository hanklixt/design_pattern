package com.hank.algorithm.map;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-22 9:19
 *
 * 你可以结合散列函数和数组来创建散列表。
 *
 * 冲突很糟糕，你应使用可以最大限度减少冲突的散列函数。
 *
 * 散列表的查找、插入和删除速度都非常快。
 *
 * 散列表适合用于仿真映射关系。
 *
 * 一旦填装因子超过0.7，就该调整散列表的长度。
 *
 * 散列表可用于缓存数据（例如，在Web服务器上）。
 *
 * 散列表非常适合用于防止重复
 */
public class SimpleHashMap<K,V> {

    /**
     * 散列表冲突，根据hash与数组长度进行求模,求出key对应的索引
     * 再将k,v放在对应的索引位置上。如两个key hash值相同，此时就会有冲突（填充因子会增加-散列表位置/位置总数）
     * 首先---应该尽量减少hash冲突，此外，冲突之后有一种简单的解决方法:在冲突的索引位置上放一个链表，冲突之后的键和值往链表尾部存放。
     * 弊端:冲突过多后散列表的整体时间复杂度都会增加。
     * 其实--通过拓展容量，重新计算hash,数组长度，将k,v放在新的索引位置上，这样，复杂度问题得到解决，但是，性能上来说，在不停拓展容量的时候，仍然是会很耗性能
     *
     * 填充因子=3/4的时候，重新创建一个数组，通常拓展后容量为之前容量的1倍，接下来使用hash函数将元素重新放在散列表的位置。这个新的散列表填充因就会变成3/8，一般来说
     * 当填充因子=3/4时，就考虑拓展容量。
     *
     * 在这里---只是非常简单-粗陋的实现，（计算key对应的索引位置-将元素放在上面....）
     *
     */

    private static final int INIT_CAPACITY=1<<4; //aka_16

    int size;

    private ListNode<K, V>[] table=null;

    public SimpleHashMap(){
       setUp(INIT_CAPACITY);
    }

    public SimpleHashMap(int capacity){
        setUp(capacity);
    }

    void setUp(int capacity){
        this.size=capacity;
        table=(ListNode<K,V>[])new ListNode[size];
    }

    private int hash(K k){
        //计算出key对应数组下标存储的位置(取绝对值)

        return Math.abs(k.hashCode() & (table.length-1));//相当于 (k.hashcode)%(table.length) ..
    }

    public V put(K k,V v){
        if (k==null){
         putForNullKey(v);
        }
        int i = hash(k);
        ListNode<K, V> kvListNode = table[i];
        for (ListNode node=table[i];node!=null;node=node.nextNode){
              if (node.getKey().equals(k)){
                  V oldValue = (V) node.getV();
                  node.setV(v);
                  return oldValue;
              }
        }
        addListNode(i,k,v);
        return null;
    }


    /**
     * null对应value值进行覆盖
     * @return
     */
    private V putForNullKey(V v){

        for (ListNode node=table[0];node!=null;node=node.nextNode){
            if (node.getKey()==null){
                return (V) node.getV();
            }
        }
        return null;
    }

    /**
     * 添加节点
     */
    public void addListNode(int i,K k,V v){
        ListNode<K, V> temp = table[i];
        table[i]=new ListNode<>(k,v);
        table[i].nextNode=temp;
    }

    public V  get(K k){

        int i = hash(k);
        ListNode<K, V> curNode = table[i];
        for (ListNode node=curNode;node!=null;node=node.nextNode){
            if (node.getKey().equals(k)){
                return (V) node.getV();
            }
        }
        return null;
    }
    public static void main(String[] args) {

        SimpleHashMap<String, String> map = new SimpleHashMap<>();

        map.put("123","456");
        map.put("1234","4567");

        System.out.println(map.get("123"));
        System.out.println(map.get("1234"));
        System.out.println(map.size);

    }










}
