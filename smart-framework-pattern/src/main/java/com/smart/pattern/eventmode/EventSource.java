package com.smart.pattern.eventmode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangqian
 * @date 2021/1/14
 */
public class EventSource {

    private List<EventListener> listenerList= new ArrayList<>();

    public void register(EventListener listener) {
        listenerList.add(listener);
    }

    public void publishEvent(Event event) {
        for (EventListener listener : listenerList) {
            listener.processEvent(event);
        }
    }

}
