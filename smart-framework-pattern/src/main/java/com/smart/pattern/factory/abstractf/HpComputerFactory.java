package com.smart.pattern.factory.abstractf;

import com.smart.pattern.factory.entity.HpKeyBoard;
import com.smart.pattern.factory.entity.HpMouse;
import com.smart.pattern.factory.entity.KeyBoard;
import com.smart.pattern.factory.entity.Mouse;

/**
 * @author yangqian
 * @date 2021/1/1
 */
public class HpComputerFactory implements ComputerFactory {

    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new HpKeyBoard();
    }
}
