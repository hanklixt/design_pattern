package com.hank.algorithm.stack_quene;

import java.util.Stack;

/**
 * @Description
 * @author 李先涛
 * @create 2020-05-19 19:20
 * 编写一个类，用两个栈实现队列，支持队列的基本操作（add、poll、peek）
 */
public class StackToQuene {

    private Stack<Integer> stackPush;

    private Stack<Integer> stackPop;

    private StackToQuene(){
        this.stackPop=new Stack<>();
        this.stackPush=new Stack<>();
    }

    public static void main(String[] args) {

    }

    /**
     * 队列移出
     * @return pop
     */
    public Integer poll(){
      if (stackPush.isEmpty()&&stackPop.empty()){
          throw new RuntimeException("stackIsEmpty");
      }else if (stackPop.empty()){
          while (!stackPush.isEmpty()){
              stackPop.push(stackPush.pop());
          }
      }
      return stackPop.pop();
    }

    /**
     * 压入队列
     * @param value 压入值
     * @return   返回值
     */
    public Integer add(Integer value){
        stackPush.push(value);
        return value;
    }

    /**
     * 队列头值
     * @param value 使用value
     * @return   返回值
     */
    public Integer peek(Integer value){
        if (stackPush.isEmpty()&&stackPop.empty()){
            throw new RuntimeException("stackIsEmpty");
        }else if (stackPop.empty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();

    }




}
