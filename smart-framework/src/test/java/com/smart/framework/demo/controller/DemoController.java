package com.smart.framework.demo.controller;

import com.smart.framework.demo.dao.DemoMapper;
import com.smart.framework.demo.service.DemoService;
import lombok.Getter;
import org.smart.framwork.core.annotation.Controller;
import org.smart.framwork.inject.annotation.Autowired;

/**
 * @author yangqian
 * @date 2021/1/6
 */
@Getter
@Controller
public class DemoController {

    @Autowired
    private DemoService demoService;
    @Autowired
    private DemoMapper demoMapper;

    public void demoServiceSayHello() {
        demoService.sayHello();
    }

}
