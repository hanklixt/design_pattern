package com.hank.current.threadPool;


/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-16 15:32
 *
 * Step 1  自定义拒绝策略
 *
 */
@FunctionalInterface
public interface RejectPolicy<T> {

    void reject(BlockQueue<T> queue,T task);

}
