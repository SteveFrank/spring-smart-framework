package com.smart.framework.demo.service.impl;

import com.smart.framework.demo.service.DemoService;
import org.smart.framwork.core.annotation.Service;

/**
 * @author yangqian
 * @date 2021/1/6
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public void sayHello() {
        System.out.println("hello Smart Framework!");
    }
}
