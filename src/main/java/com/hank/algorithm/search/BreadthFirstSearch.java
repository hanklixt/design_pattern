package com.hank.algorithm.search;

import java.util.*;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-22 15:06
 *
 * 广度优先搜索(阐述)---经销商问题（找出我的关系网里面，关系最近的经销商是谁）
 *
 */
public class BreadthFirstSearch {

    private static final Queue<String> queue=new ArrayDeque<>();


    private static final Map<String,String[]> relation=new HashMap<>();

    /**
     * 我的关系网
     */
    static {
        /**
         * 我的朋友
         */
        String[] my={"zhangsan","lisi","wangwu","zhaoliu"};
        /**
         * 张三的朋友
         */
        String[] zhangSan={"zhangSi","zhangWu","zhangLiu","zhangQi"};
        /**
         * 李四的朋友
         */
        String[] lisi={"liwu","liliu","liqi","liba","mmmm"};

        relation.put("my",my);

        relation.put("zhangSan",zhangSan);

        relation.put("lisi",lisi);
    }

    /**
     * 使用......
     */
    public static void main(String[] args) {
        BreadthFirstSearch search = new BreadthFirstSearch();
        Map<String, String[]> relation = search.getRelation();
        Queue<String> queue = search.getQueue();
        String[] mies = relation.get("my");
        //我的朋友们关系网压入队列
        queue.addAll(Arrays.asList(mies));
        //检查过的人放在这里面
        List<String> checked = new ArrayList<>();
        int count=0;
        while (!queue.isEmpty()){
            String poll = queue.poll();
            //检查过的人，就不再检查了
            if (checked.contains(poll)){
                continue;
            }
            checked.add(poll);
            count++;
            if (poll.contains("m")){
               System.out.println("找到经销商---了，经过了"+count+"个步骤--他的名字是:"+poll);
               break;
            }
            //朋友的朋友
            String[] friendsfri = relation.get(poll);
            if (friendsfri!=null&&friendsfri.length>0){
                Collections.addAll(queue, friendsfri);
            }
        }
    }



    public Map<String,String[]> getRelation(){
        return relation;
    }

    public Queue<String> getQueue(){
        return queue;
    }

    /*
     */

    public void add(String name){
        queue.add(name);
    }





}
