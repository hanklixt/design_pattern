package com.hank.design.enjoyyuanmode;

import java.util.HashMap;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-16 13:27
 */
public class ShapeFactory {

    private static final HashMap<String,CirCle> map=new HashMap<>();

    public static CirCle getCirCle(String color){
        CirCle cirCle = map.get(color);
        if (cirCle==null){
            cirCle = new CirCle(color);
            map.putIfAbsent(color,cirCle);
        }
        return cirCle;
    }




}
