package com.hank.algorithm.stack_quene;

import java.util.Stack;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-19 17:28
 * 【题目】
 *
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 *
 * 【要求】
 *
 * 1.pop、push、getMin操作的时间复杂度都是O (1)。
 *
 * 2．设计的栈类型可以使用现成的栈结构。
 */
public class GetMinStack {

    /**
     * 存放栈数据
     */
    private Stack<Integer> stackData;

    /**
     * 存放stack最小值
     */
    private Stack<Integer> stackMin;


    public GetMinStack(){
        this.stackData =new Stack<>();
        this.stackMin =new Stack<>();
    }


    public static void main(String[] args) {

        GetMinStack stack = new GetMinStack();
        for (int j=10;j>0;j--){
            stack.push(j);
        }

        System.out.println(stack.getMin());

    }

    public Integer getMin(){
        return stackMin.peek();
    }

    /**
     * 出栈
     */
    public void pop(){
        Integer pop = stackData.pop();
        if (stackData.isEmpty()|| pop.equals(stackMin.peek())){
            stackMin.pop();
        }
    }

    /**
     *
     * @param value
     */
    public void push(Integer value){

        if (value==null) {
            return;
        }
        if (stackMin.isEmpty()){
            stackMin.push(value);
        }else{
            Integer currentMin = stackMin.firstElement();
            if (currentMin>this.getMin()){
                stackMin.pop();
                stackMin.push(value);
            }
        }
        stackData.push(value);
    }


}
