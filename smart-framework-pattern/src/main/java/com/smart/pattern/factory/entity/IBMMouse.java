package com.smart.pattern.factory.entity;

/**
 * @author yangqian
 * @date 2021/1/1
 */
public class IBMMouse extends LenovoMouse {

    @Override
    public void sayHi() {
        System.out.println("IBM Mouse From Lenovo ~~");
    }
}
