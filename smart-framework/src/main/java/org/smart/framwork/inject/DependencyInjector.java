package org.smart.framwork.inject;

import lombok.extern.slf4j.Slf4j;
import org.smart.framwork.core.BeanContainer;
import org.smart.framwork.inject.annotation.Autowired;
import org.smart.framwork.utils.ClassUtil;
import org.smart.framwork.utils.ValidationUtil;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * @author yangqian
 * @date 2021/1/7
 */
@Slf4j
public class DependencyInjector {

    /**
     * Bean容器
     */
    private BeanContainer beanContainer;

    public DependencyInjector() {
        this.beanContainer = BeanContainer.getInstance();
    }

    /**
     * 执行IOC操作
     */
    public void doIoc() {
        // 首先进行校验
        if (ValidationUtil.isEmpty(beanContainer.getClasses())) {
            log.warn("empty classSet in BeanContainer");
            return;
        }
        // 1、遍历Bean容器中所有的Class对象
        for (Class<?> clazz : beanContainer.getClasses()) {
            // 2、遍历Class对象的所有成员变量
            Field[] fields = clazz.getDeclaredFields();
            if (ValidationUtil.isEmpty(fields)) {
                continue;
            }
            for (Field field : fields) {
                // 3、找出被Autowired标记的成员变量
                if (field.isAnnotationPresent(Autowired.class)) {
                    // 同时获取 value 值

                    Autowired autowired = field.getAnnotation(Autowired.class);
                    String autowiredValue = autowired.value();

                    // 4、获取成员变量类型
                    Class<?> fieldClass = field.getType();
                    // 5、获取这些成员变量对应类型在容器中对应的实例
                    Object fieldValue = getFieldInstance(fieldClass, autowiredValue);
                    if (fieldValue == null) {
                        // 如果获取失败则直接抛出异常信息
                        throw new RuntimeException("unable to inject relevant type, target fieldClass is:"
                                        + fieldClass.getName()
                                        + " autowiredValue is : " + autowiredValue);
                    } else {
                        // 6、通过反射将对应的成员变量实例注入到成员变量所在的类实例中
                        Object targetBean = beanContainer.getBean(clazz);
                        // 支持私有成员变量注入
                        ClassUtil.setField(field, targetBean, fieldValue, true);
                    }
                }
            }
        }
    }

    /**
     * 根据Class在beanContainer里面获取其实例或者实现类
     *
     * @param fieldClass
     * @return
     */
    private Object getFieldInstance(Class<?> fieldClass, String autowiredValue) {
        Object fieldValue = beanContainer.getBean(fieldClass);
        if (fieldValue != null) {
            return fieldValue;
        } else {
            // 获取实现类
            Class<?> implementedClass = getImplementClass(fieldClass, autowiredValue);
            if (implementedClass != null) {
                // 获取到实现类直接返回
                return beanContainer.getBean(implementedClass);
            } else {
                return null;
            }
        }
    }

    /**
     * 获取接口的实现类
     *
     * @param fieldClass
     * @return
     */
    private Class<?> getImplementClass(Class<?> fieldClass, String autowiredValue) {
        Set<Class<?>> classSet = beanContainer.getClassesBySuper(fieldClass);
        if (!ValidationUtil.isEmpty(classSet)) {
            // 考虑到可能有多个实现类的基础上，可以在注解中指定实现的类
            if (ValidationUtil.isEmpty(autowiredValue)) {
                // 用户没有精确告诉精确的实现类
                if (classSet.size() == 1) {
                    return classSet.iterator().next();
                } else {
                    throw new RuntimeException("multiple implemented classes for "
                            + fieldClass.getName()
                            + " please set @Autowired's value to pick one");
                }
            } else {
                for (Class<?> clazz : classSet) {
                    if (autowiredValue.equals(clazz.getSimpleName())) {
                        return clazz;
                    }
                }
            }
        }
        return null;
    }

}
