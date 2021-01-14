package com.smart.pattern.eventmode;

import lombok.Data;

/**
 * @author yangqian
 * @date 2021/1/14
 */
@Data
public class Event {

    public static final String SINGLE_CLICK = "single_click";
    public static final String DOUBLE_CLICK = "double_click";

    private String type;
}
