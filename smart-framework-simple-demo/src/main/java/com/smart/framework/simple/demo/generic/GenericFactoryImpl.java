package com.smart.framework.simple.demo.generic;

/**
 * @author yangqian
 * @date 2021/1/1
 */
public class GenericFactoryImpl<T, N> implements GenericFactory<T, N> {

    @Override
    public T nextObject() {
        return null;
    }

    @Override
    public N nextNumber() {
        return null;
    }
}
