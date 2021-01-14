package com.smart.pattern.eventmode;

import com.smart.pattern.eventmode.impl.DoubleClickEventListener;
import com.smart.pattern.eventmode.impl.SingleClickEventListener;

/**
 * @author yangqian
 * @date 2021/1/14
 */
public class EventModeDemo {

    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        SingleClickEventListener singleClickEventListener = new SingleClickEventListener();
        DoubleClickEventListener doubleClickEventListener = new DoubleClickEventListener();

        eventSource.register(singleClickEventListener);
        eventSource.register(doubleClickEventListener);

        Event event = new Event();
        event.setType(Event.DOUBLE_CLICK);
        eventSource.publishEvent(event);
    }

}
