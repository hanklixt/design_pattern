package com.hank.algorithm.search;

import sun.plugin.dom.core.Node;

import java.util.*;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-25 16:36
 * 迪克斯拉特算法实现
 */
public class DixsRatSearch {

    private final  static String START="start";

    private final static  String END="end";

    private final static Integer NO_WAY_SIGN=Integer.MAX_VALUE;

    public static void main(String[] args) {

        //1.构造有向图和权重
        Map<String, Map<String, Integer>> map = new HashMap<>();
        //初始化节点信息
        Map<String, Integer> start = new HashMap<>();
        start.put("A",5);
        start.put("B",2);
        map.put(START,start);;
        Map<String, Integer> a = new HashMap<>();
        a.put("C",4);
        a.put("D",2);
        map.put("A",a);
        Map<String, Integer> b= new HashMap<>();
        b.put("A",8);
        b.put("D",7);
        map.put("B",b);
        Map<String, Integer> c = new HashMap<>();
        c.put("D",6);
        c.put(END,3);
        map.put("C",c);
        Map<String, Integer> d = new HashMap<>();
        d.put(END,1);
        map.put("D",d);
        DixsRatSearch dixsRatSearch = new DixsRatSearch();
        dixsRatSearch.getMinStep(START,END,map);
    }


    public void getMinStep(String start,String end, Map<String, Map<String, Integer>> graph){

        //从start开始，最小开销的节点和权重
        Map<String, Integer> costs = graph.get(start);
       //处理过的节点，加到这里面做标记
        HashSet<String> processed = new HashSet<>();
        //记录最小开销的节点信息
        HashMap<String, String> parent = new HashMap<>();

        String lowestNode = findLowestNode(costs, processed);
        int i=0;
        while (null!=lowestNode&&graph.get(lowestNode)!=null){
            int cost=costs.get(lowestNode);
            Map<String, Integer> node = graph.get(lowestNode);
            for (Map.Entry<String, Integer> next : node.entrySet()) {
                int newCost = cost +next.getValue();
                //更新最小开销---- （start->父权重)+（父权重->当前权重）
                if (!costs.containsKey(next.getKey())||costs.get(next.getKey())>newCost){
                     costs.put(next.getKey(),newCost);
                     parent.put(next.getKey(),lowestNode);
                }
            }
            i++;
            System.out.println("第"+i+"次");
            System.out.println(costs.toString());
            System.out.println(parent.toString());
            //加入已处理的节点
            processed.add(lowestNode);
            System.out.println(processed.toString());
            lowestNode=findLowestNode(costs,processed);
        }
         printPath(parent,costs.get(END));
    }

    /**
     * 打印路径
     * @param parents
     * @param cost
     */
    public void printPath(Map<String,String> parents,int cost){
        Stack<String> stack = new Stack<String>();
        String parent = parents.get(END);
        //从终点开始回溯父节点--拼接最短路径
        while (parent != null) {
            if (START.equalsIgnoreCase(parent)) {
                stack.push(START);
                break;
            }
            stack.push(parent);
            parent = parents.get(parent);
        }
        StringBuffer path = new StringBuffer();
        while (!stack.empty()) {
            String node = stack.pop();
            if (path.length() != 0) {
                path.append("->");
            }
            path.append(node);
        }
        System.out.println("最优路线：" + START + "->" + path.toString() + "->" + END);
        System.out.println("其开销为：" + cost);

    }

    /**
     * 找到最小开销的节点
     * @param cost
     * @param processed
     * @return
     */
    public String findLowestNode(Map<String, Integer> cost,HashSet<String> processed){
        Integer lowestCost=NO_WAY_SIGN;
        String nodeKey=null;
        for (Map.Entry<String, Integer> entry : cost.entrySet()) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            if (!processed.contains(k)&&lowestCost>v){
                lowestCost=v;
                nodeKey=k;
            }
        }
        return nodeKey;
    }

}
