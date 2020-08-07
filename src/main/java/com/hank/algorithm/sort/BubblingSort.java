package com.hank.algorithm.sort;

public class BubblingSort {


    private static final int[] nums={7,6,5,4,3,2,1};


    /**
     * sort
     */
    private static void bubblingSort(){
        //冒泡
        for (int i = 0; i < nums.length; i++) {




        }



    }






    public static void main(String[] args) {
        for (int i=0;i<nums.length;i++){
            if (i+1<nums.length){
                if (nums[i]>nums[i+1]){
                    int num = nums[i + 1];
                    nums[i+1]=nums[i];
                    nums[i]=num;
                }
            }
            for (int j=0;j<nums.length;j++){
                if (j+1<nums.length){
                    if (nums[j]>nums[j+1]){
                        int num = nums[j + 1];
                        nums[j+1]=nums[j];
                        nums[j]=num;
                    }
                }
            }
        }

        System.out.println("so");
    }

}
