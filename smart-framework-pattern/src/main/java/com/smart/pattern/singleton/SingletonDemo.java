package com.smart.pattern.singleton;

import java.lang.reflect.Constructor;

/**
 * 尝试反射是否能够打破这种单例模式
 *
 * @author yangqian
 * @date 2021/1/5
 */
public class SingletonDemo {

    public static void main(String[] args) throws Exception {
        System.out.println(EnumStarvingSingleton.getInstance());
        Class clazz = EnumStarvingSingleton.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        EnumStarvingSingleton enumStarvingSingleton = (EnumStarvingSingleton)constructor.newInstance();
        System.out.println(enumStarvingSingleton.getInstance());
    }

}
