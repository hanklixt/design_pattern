package com.hank.test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-19 11:43
 */
public class test {
    public static void main(String[] args) {

        int aim=60;

        LinkedHashMap<Object, Object> objectObjectLinkedHashMap = new LinkedHashMap<>();

        List<Integer> objects = new ArrayList<>(101);
        for (int i=0;i<103;i++){
            objects.add(i+1);
        }
        System.out.println(Rounding(objects, aim));
    }

    private static Integer Rounding(List<Integer> obj,int target){
        if (obj==null||obj.size() == 0) return null;
        int low=0;
        int high=obj.size();
     while (low<high){
            int mid=(low+high)/2;
            Integer res = obj.get(mid);
            if (res==target){
                return mid;
            }else if (target> res){
                low=mid;
            }else {
                high=mid;
            }
        }
        if (low==0){
            return -1;
        }
        return null;
    }
}
