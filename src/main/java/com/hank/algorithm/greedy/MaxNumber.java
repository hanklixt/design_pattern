package com.hank.algorithm.greedy;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-30 10:45
 *
［最大整数］设有n个正整数，将它们连接成一排，组成一个最大的多位整数。

例如：n=3时，3个整数13，312，343，连成的最大整数为34331213。

又如：n=4时，4个整数7，13，4，246，连成的最大整数为7424613。
 */
public class MaxNumber {



    public static void main(String[] args) {

        //思路--每两个字符做拼接操作，大的放在前面，而小的往后面排。。

           //原始整数
           int[] nums={7,6,5,1234,82,9};
           //转成字符串
           String [] strs=new String[nums.length];
           for (int s=0;s<nums.length;s++){
               strs[s]=String.valueOf(nums[s]);
           }

           for (int i=0;i<strs.length;i++){
               for (int j=i+1;j<strs.length;j++){
                   //两个字符串的组合进行排序，大的都放在前面
                 if ((strs[j]+strs[i]).compareTo(strs[i]+strs[j])>0){
                     String str=strs[j];
                     strs[j]=strs[i];
                     strs[i]=str;
                 }
               }
           }

         StringBuilder MaxNum= new StringBuilder();

        for (String str : strs) {
            MaxNum.append(str);
        }
        System.out.println(MaxNum.toString());


    }


}
