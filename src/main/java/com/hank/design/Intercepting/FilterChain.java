package com.hank.design.Intercepting;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-07 11:40
 * 4.创建filterChain
 */
public class FilterChain {

    private List<Filter> filterList=new ArrayList<>();

    private Target target;

    public void addFilter(Filter filter){
        filterList.add(filter);
    }

    public void execute(String request){
        filterList.forEach(x->{
            x.execute(request);
        });
        target.execute(request);
    }

    public void setTarget(Target target){
        this.target=target;
    }



}
