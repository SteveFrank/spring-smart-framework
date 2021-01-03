package com.smart.pattern.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yangqian
 * @date 2021/1/3
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseInfoAnnotation {

    // 课程名称
    public String courseName();
    // 课程标签
    public String courseTage();
    // 课程简介
    public String courseProfile();
    // 课程序号
    public int courseIndex() default 1;

}
