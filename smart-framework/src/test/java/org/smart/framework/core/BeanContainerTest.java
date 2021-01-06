package org.smart.framework.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.smart.framwork.core.BeanContainer;

/**
 * @author yangqian
 * @date 2021/1/6
 */

public class BeanContainerTest {

    private static BeanContainer beanContainer;

    @BeforeAll
    static void init() {
        beanContainer = BeanContainer.getInstance();
    }

    @DisplayName("加载目标类及其实例到BeanContainer：loadBeansTest")
    @Test
    public void loadBeansTest() {
        Assertions.assertEquals(false, beanContainer.isLoaded());
        beanContainer.loadBeans("com.smart.framework.demo");
        System.out.println(beanContainer.size());
    }

}
