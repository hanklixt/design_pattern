package com.hank.design.Intercepting;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-07 11:52
 * 5.创建 FilterManger
 */
public class FilterManger {

    private FilterChain filterChain;

    public FilterManger(Target target){
        filterChain=new FilterChain();
        filterChain.setTarget(target);
    }

    public void setFilter(Filter filter){
        filterChain.addFilter(filter);
    }

    public void filterRequest(String request){
      filterChain.execute(request);
    }


}
