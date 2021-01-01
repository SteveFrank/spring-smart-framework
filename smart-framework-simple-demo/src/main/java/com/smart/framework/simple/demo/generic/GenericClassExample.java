package com.smart.framework.simple.demo.generic;

import lombok.Data;

/**
 * 通过尖括号指定实体类型即可
 * @author yangqian
 * @date 2021/1/1
 */
@Data
public class GenericClassExample<T> {
    /**
     * member 这个成员变量的类型为T, T类型是由外部指定
     */
    private T member;
    /**
     * 泛型构造方法形参member的类型为T, T的类型有外部指定
     * @param member
     */
    public GenericClassExample(T member) {
        this.member = member;
    }
    public T handleSomething(T target) {
        return target;
    }
    public <E> void printArray(E[] inputArray) {
        for (E e : inputArray) {
            System.out.println(e);
        }
    }
}
