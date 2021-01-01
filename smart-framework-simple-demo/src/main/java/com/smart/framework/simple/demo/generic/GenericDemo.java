package com.smart.framework.simple.demo.generic;


/**
 * @author yangqian
 * @date 2021/1/1
 */
public class GenericDemo {

    public static void  handlerMember(GenericClassExample<Integer> integerGenericClassExample) {
        int result = 1 + integerGenericClassExample.getMember();
        System.out.println("result is : " + result);
    }

    public static void main(String[] args) {
        GenericClassExample<String> stringGenericClassExample = new GenericClassExample<>("abc");
        GenericClassExample<Integer> integerGenericClassExample = new GenericClassExample<>(1);
        System.out.println(stringGenericClassExample.getMember().getClass());
        System.out.println(integerGenericClassExample.getMember().getClass());
        stringGenericClassExample.handleSomething("abc");
        integerGenericClassExample.handleSomething(1);

        handlerMember(integerGenericClassExample);

        Integer[] integers = {1,2,3,4,5,6};
        stringGenericClassExample.printArray(integers);
    }

}
