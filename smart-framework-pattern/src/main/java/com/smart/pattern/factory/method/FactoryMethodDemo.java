package com.smart.pattern.factory.method;

import com.smart.pattern.factory.entity.Mouse;

/**
 * 不会对于开闭原则造成影响
 * 不用对于代码作出调整
 * 需要同等数量的factory，没有办法从根本上解决问题
 * @author yangqian
 * @date 2021/1/1
 */
public class FactoryMethodDemo {

    public static void main(String[] args) {
        MouseFactory mf = new HpMouseFactory();
        Mouse mouse = mf.createMouse();
        mouse.sayHi();

        MouseFactory ibm = new IBMMouseFactory();
        Mouse mouseIBM = ibm.createMouse();
        mouseIBM.sayHi();
    }

}
