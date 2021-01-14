package com.smart.pattern.eventmode.impl;

import com.smart.pattern.eventmode.Event;
import com.smart.pattern.eventmode.EventListener;

import static com.smart.pattern.eventmode.Event.DOUBLE_CLICK;

/**
 * @author yangqian
 * @date 2021/1/14
 */
public class DoubleClickEventListener implements EventListener {

    @Override
    public void processEvent(Event event) {
        if (DOUBLE_CLICK.equals(event.getType())) {
            System.out.println("双击事件触发了");
        }
    }
}
