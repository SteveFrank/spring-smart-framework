package com.smart.pattern.annotation;

/**
 * @author yangqian
 * @date 2021/1/3
 */
public class TypeParameterDemo<@TypeParameterAnnotation T> {
    public <@TypeParameterAnnotation U> T foo(T t) {
        return null;
    }
}
