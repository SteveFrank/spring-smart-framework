package com.smart.pattern.factory.abstractf;

import com.smart.pattern.factory.entity.KeyBoard;
import com.smart.pattern.factory.entity.Mouse;

/**
 * 解决了一个生产工厂只生产一种方式的弊端
 * @author yangqian
 * @date 2021/1/1
 */
public class AbstractFactoryDemo {

    public static void main(String[] args) {
        ComputerFactory computerFactory = new HpComputerFactory();
        Mouse mouse = computerFactory.createMouse();
        KeyBoard keyBoard = computerFactory.createKeyBoard();
        mouse.sayHi();
        keyBoard.sayHello();
    }

}
