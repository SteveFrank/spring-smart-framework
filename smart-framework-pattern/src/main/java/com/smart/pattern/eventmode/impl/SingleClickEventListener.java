package com.smart.pattern.eventmode.impl;

import com.smart.pattern.eventmode.Event;
import com.smart.pattern.eventmode.EventListener;

import static com.smart.pattern.eventmode.Event.SINGLE_CLICK;

/**
 * @author yangqian
 * @date 2021/1/14
 */
public class SingleClickEventListener implements EventListener {
    @Override
    public void processEvent(Event event) {
        if (SINGLE_CLICK.equals(event.getType())) {
            System.out.println("单击件触发了");
        }
    }
}
