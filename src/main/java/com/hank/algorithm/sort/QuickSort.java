package com.hank.algorithm.sort;



/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-21 10:39
 */
public class QuickSort {
    public static void main(String[] args) {
         //快速排序
        int [] a ={7,9,6,4,3,5,2,1,8,10};
        QuickSort.quickSort(a,0,a.length-1);
        System.out.println(QuickSort.toString(a));

    }







    public static String toString(int [] a) {
        StringBuilder str= new StringBuilder();
        for (int i=a.length-1;i>=0;i--){
            str.insert(0, a[i]);
        }
        return str.toString();
    }
    /**
     * 基准条件  left>=right
     * 递归条件  left<right
     * @param array  ---
     * @return   ----
     */
    public static void quickSort(int [] array,int left,int right){
        //如果left>=right  则right给点数据
        if (left>=right){
            return ;
        }
        // 基准值
        int base = array[left];
        int i=left;
        int j=right;
        while (i<j){
            //从后往前查找
            while (array[j]>=base&&i<j){
                j--;
            } while (array[i]<=base&&i<j) {
                i++;
            }
            //交换i j 位置
            if (i<j){
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }
        //交换基准值(当i=j时)
        array[left]=array[i];
        array[i]=base;
//        left=array[0];
        //基准值放到自己应该存在的位置，同时拆分数组(此为小于基准值的数组)
        quickSort(array,0,i-1);
        //此为大于基准值的数组
        quickSort(array,i+1,right);
    }
}
