package org.smart.framework.inject;

import com.smart.framework.demo.controller.DemoController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.smart.framwork.core.BeanContainer;
import org.smart.framwork.inject.DependencyInjector;

/**
 * @author yangqian
 * @date 2021/1/7
 */
public class DependencyInjectorTest {

    @DisplayName("依赖注入 doIoc")
    @Test
    public void doIocTest() {
        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("com.smart.framework.demo");
        Assertions.assertEquals(true, beanContainer.isLoaded());

        DemoController demoController = (DemoController) beanContainer.getBean(DemoController.class);
        Assertions.assertEquals(true, demoController instanceof DemoController);
        Assertions.assertEquals(null, demoController.getDemoService());

        new DependencyInjector().doIoc();
        Assertions.assertNotEquals(null, demoController.getDemoService());
        demoController.demoServiceSayHello();
    }

}
