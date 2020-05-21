package com.hank.algorithm.stack_quene;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-20 10:06
 * 【题目】
 *
 * 一个栈依次压入1、2、3、4、5，那么从栈顶到栈底分别为5、4、3、2、1。将这个栈转置后，
 * 从栈顶到栈底为1、2、3、4、5，也就是实现栈中元素的逆序，但是只能用递归函数来实现，不能用其他数据结构。
 */
public class ReverseStack {

    private Stack<Integer> stackPush;

    private Stack<Integer> stackPop;

    public ReverseStack(){
        this.stackPush=new Stack<>();
        this.stackPop=new Stack<>();
    }

    public static void main(String[] args) {
        ReverseStack stack = new ReverseStack();
        stack.push(1,2,3,4,5);
        System.out.println(stack.stackPop);
        Stack<Integer> reserve = stack.reserve(stack.stackPop);
        System.out.println(reserve);

    }




    public void push(Integer... items){

        for (Integer item:items){
            stackPop.push(item);
        }

    }

    /**
     * 获取栈底的元素并且入栈
     * @param stack
     * @return
     */
    public Integer getAndRemoveFirstElement(Stack<Integer> stack){
        //判断栈是否为空
        if (stack.empty()){
            throw new RuntimeException("stack is empty");
        }
        return stack.pop();
    }



    public Stack<Integer> reserve(Stack<Integer> stack){
       if (stack.empty()){
           return stackPush ;
       }
       Integer pop = getAndRemoveFirstElement(stack);
       stackPush.push(pop);
       reserve(stack);
        return stackPush;


    }







}
