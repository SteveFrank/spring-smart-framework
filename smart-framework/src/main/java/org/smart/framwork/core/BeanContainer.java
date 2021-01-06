package org.smart.framwork.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.smart.framwork.core.annotation.Component;
import org.smart.framwork.core.annotation.Controller;
import org.smart.framwork.core.annotation.Repository;
import org.smart.framwork.core.annotation.Service;
import org.smart.framwork.utils.ClassUtil;
import org.smart.framwork.utils.ValidationUtil;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Bean 容器
 * @author yangqian
 * @date 2021/1/6
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanContainer {
    /**
     * 存放所有被配置标记的目标对象的Map
     */
    private final Map<Class<?>, Object> beanMap = new ConcurrentHashMap<>();
    /**
     * 加载bean的注解列表
     * * 配置的管理与获取
     */
    private static final List<Class<? extends Annotation>> BEAN_ANNOTATION
            = Arrays.asList(Component.class, Controller.class, Service.class, Repository.class);
    private enum ContainHolder {
        /**
         * 饿汉模式安全的单例模式
         */
        HOLDER;

        private BeanContainer instance;
        ContainHolder() {
            instance = new BeanContainer();
        }
    }

    /**
     * 容器是否已经加载过bean
     */
    private volatile boolean loaded = false;

    /**
     * 判断容器是否已经加载过了，避免重复加载
     * @return
     */
    public boolean isLoaded() {
        return loaded;
    }

    /**
     * 获取Bean实例的数量
     * @return
     */
    public int size() {
        return beanMap.size();
    }

    /**
     * 获取Bean容器的实例
     */
    public static BeanContainer getInstance() {
        return ContainHolder.HOLDER.instance;
    }

    /**
     * 扫描加载所有的Bean
     * @param packageName
     */
    public synchronized void loadBeans(String packageName) {

        // 判断 bean 容器收已经被加载过
        if (isLoaded()) {
            log.warn("BeanContainer has been loaded");
            return;
        }

        Set<Class<?>> classSet = ClassUtil.extractPackageClass(packageName);

        if (ValidationUtil.isEmpty(classSet)) {
            log.warn("extract nothing from packageName : {}" + packageName);
            return;
        }

        for (Class<?> clazz : classSet) {
            for (Class<? extends Annotation> annotation : BEAN_ANNOTATION) {
                // 1、检查如果类上面是标记定义了注解
                if (clazz.isAnnotationPresent(annotation)) {
                    // 2、如果包含注解 => 则将目标类本身作为键，目标类的实例作为值，放入到beanMap中
                    beanMap.put(clazz, ClassUtil.newInstance(clazz, true));
                }
            }
        }

        loaded = true;

    }
}
