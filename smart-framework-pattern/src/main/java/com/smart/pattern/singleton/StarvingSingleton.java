package com.smart.pattern.singleton;

/**
 * 饿汉模式
 * 线程安全
 *
 * 但是通过反射可以直接创建新的
 *
 * @author yangqian
 * @date 2021/1/5
 */
public class StarvingSingleton {

    private static final StarvingSingleton starvingSingleton = new StarvingSingleton();
    private StarvingSingleton() {
    }
    public static StarvingSingleton getInstance(){
        return starvingSingleton;
    }


}
