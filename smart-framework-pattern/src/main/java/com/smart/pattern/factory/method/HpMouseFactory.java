package com.smart.pattern.factory.method;

import com.smart.pattern.factory.entity.HpMouse;
import com.smart.pattern.factory.entity.Mouse;

/**
 * @author yangqian
 * @date 2021/1/1
 */
public class HpMouseFactory implements MouseFactory {

    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }
}
