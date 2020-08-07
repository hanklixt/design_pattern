package com.hank.algorithm.str;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lxt
 * @Date: 2020/8/7 17:38
 * 字符串查找子串
 */
public class BfSearch {

    public static void main(String[] args) {
        List<Integer> num = findNum("aabbaabbaabb", "bb");
        System.out.println(num);
    }

    private static List<Integer> findNum(String str, String sub){
        List<Integer> array = new ArrayList<>();
        if (sub==null||str==null){
            return array;
        }
        char[] chars = str.toCharArray();
        char[] subChar = sub.toCharArray();
        int n = chars.length;
        int m = subChar.length;
        for (int i = 0; i <= n-m; i++) {
            int j=0;
            for (;j<m;j++){
                if (chars[j+i]!=subChar[j]){
                    break;
                }
            }
            if (j==subChar.length){
                array.add(i);
            }
        }
        return array;
    }


}
