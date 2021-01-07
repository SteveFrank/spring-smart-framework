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
import java.util.*;
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
        // 容器已经完成初始化加载
        loaded = true;
    }

    /**
     * 添加一个class对象及其Bean实例
     *
     * @param clazz Class对象
     * @param bean  Bean实例
     * @return 原有的Bean实例, 没有则返回null
     */
    public Object addBean(Class<?> clazz, Object bean) {
        return beanMap.put(clazz, bean);
    }

    /**
     * 移除一个IOC容器管理的对象
     *
     * @param clazz Class对象
     * @return 删除的Bean实例, 没有则返回null
     */
    public Object removeBean(Class<?> clazz) {
        return beanMap.remove(clazz);
    }

    /**
     * 根据Class对象获取Bean实例
     *
     * @param clazz
     * @return
     */
    public Object getBean(Class<?> clazz) {
        return beanMap.get(clazz);
    }

    /**
     * 获取容器管理的所有Class对象集合
     *
     * @return Class集合
     */
    public Set<Class<?>> getClasses(){
        return beanMap.keySet();
    }

    /**
     * 获取所有Bean集合
     *
     * @return Bean集合
     */
    public Set<Object> getBeans(){
        return new HashSet<>( beanMap.values());
    }

    /**
     * 根据注解筛选出的Bean的Class集合
     *
     * @param annotation
     * @return
     */
    public Set<Class<?>> getClassesByAnnotation(Class<? extends Annotation> annotation) {
        // 1、获取beanMap所有的class对象
        Set<Class<?>> keySet = getClasses();
        if (ValidationUtil.isEmpty(keySet)) {
            log.warn("nothing in keyMap");
            return null;
        }
        // 2、通过注解筛选被注解标记的class对象，并且添加到classSet中
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> clazz : keySet) {
            // 类是否有相关的注解标记
            if (clazz.isAnnotationPresent(annotation)) {
                classSet.add(clazz);
            }
        }
        return classSet.size() > 0 ? classSet : null;
    }

    /**
     * 通过接口或者父类获取实现类或者子类的Class集合，不包括其本身
     *
     * @param interfaceOrClass
     * @return
     */
    public Set<Class<?>> getClassesBySuper(Class<?> interfaceOrClass) {
        // 1、获取beanMap的所有class对象
        Set<Class<?>> keySet = getClasses();
        if(ValidationUtil.isEmpty(keySet)) {
            log.warn("nothing in beanMap");
            return null;
        }
        // 2、判断keySet里的元素是否是传入的接口或者类的子类，如果是，就将其添加到classSet里
        Set<Class<?>> classSet = new HashSet<>();
        for(Class<?> clazz : keySet) {
            // 判断keySet里的元素是否是传入的接口或者类的子类
            if(interfaceOrClass.isAssignableFrom(clazz) && !clazz.equals(interfaceOrClass)) {
                classSet.add(clazz);
            }
        }
        return classSet.size() > 0 ? classSet: null;
    }

}
