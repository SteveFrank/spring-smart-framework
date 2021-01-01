package com.smart.pattern.factory.abstractf;

import com.smart.pattern.factory.entity.KeyBoard;
import com.smart.pattern.factory.entity.Mouse;

/**
 * @author yangqian
 * @date 2021/1/1
 */
public interface ComputerFactory {

    Mouse createMouse();
    KeyBoard createKeyBoard();

}
