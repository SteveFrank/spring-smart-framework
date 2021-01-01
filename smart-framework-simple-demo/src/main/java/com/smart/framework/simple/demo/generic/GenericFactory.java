package com.smart.framework.simple.demo.generic;

/**
 * @author yangqian
 * @date 2021/1/1
 */
public interface GenericFactory<T, N> {

    T nextObject();

    N nextNumber();

}
