package org.smart.framework.core;

import com.smart.framework.demo.controller.DemoController;
import com.smart.framework.demo.service.DemoService;
import com.smart.framework.demo.service.impl.DemoServiceImpl;
import org.junit.jupiter.api.*;
import org.smart.framwork.core.BeanContainer;
import org.smart.framwork.core.annotation.Controller;

/**
 * @author yangqian
 * @date 2021/1/6
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BeanContainerTest {

    private static BeanContainer beanContainer;

    @BeforeAll
    static void init() {
        beanContainer = BeanContainer.getInstance();
    }

    @DisplayName("加载目标类及其实例到BeanContainer：loadBeansTest")
    @Order(1)
    @Test
    public void loadBeansTest() {
        Assertions.assertEquals(false, beanContainer.isLoaded());
        beanContainer.loadBeans("com.smart.framework.demo");
        System.out.println(beanContainer.size());
    }

    @DisplayName("根据类获取其实例：getBeanTest")
    @Order(2)
    @Test
    public void getBeanTest() {
        DemoController controller = (DemoController) beanContainer.getBean(DemoController.class);
        Assertions.assertEquals(true, controller instanceof DemoController);
        System.out.println("load DemoController success");
        controller.demoServiceSayHello();
    }

    @DisplayName("根据注解获取对应的实例：getClassesByAnnotationTest")
    @Order(3)
    @Test
    public void getClassesAnnotationTest() {
        Assertions.assertEquals(true, beanContainer.isLoaded());
        Assertions.assertEquals(1, beanContainer.getClassesByAnnotation(Controller.class).size());
    }

    @DisplayName("根据接口获取实现类：getClassesBySuperTest")
    @Order(4)
    @Test
    public void getClassesBySuperTest() {
        Assertions.assertEquals(true, beanContainer.isLoaded());
        Assertions.assertEquals(true, beanContainer.getClassesBySuper(DemoService.class).contains(DemoServiceImpl.class));
    }

}
