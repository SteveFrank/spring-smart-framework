package com.smart.pattern.factory.simple;

import com.smart.pattern.factory.entity.DellMouse;
import com.smart.pattern.factory.entity.HpMouse;
import com.smart.pattern.factory.entity.LenovoMouse;
import com.smart.pattern.factory.entity.Mouse;

/**
 * 简单工厂模式
 * 分支语句过多
 * 客户端不用关心创建
 * 开闭原则，选择性的追求
 * @author yangqian
 * @date 2021/1/1
 */
public class MouseFactory {

    public static Mouse createMouse(int type) {
        switch (type) {
            case 0: return new DellMouse();
            case 1: return new HpMouse();
            case 2: return new LenovoMouse();
            default: return new DellMouse();
        }
    }

    public static void main(String[] args) {
        Mouse mouse = MouseFactory.createMouse(1);
        mouse.sayHi();
    }

}
