package com.smart.pattern.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * @author yangqian
 * @date 2021/1/3
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonInfoAnnotation {
    // 名字
    public String name();
    // 年龄 默认18
    public int age() default 18;
    // 性别 默认男
    public String gender() default "男";
    // 开发语言
    public String[] language();
}
