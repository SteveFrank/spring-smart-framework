package com.smart.pattern.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解的功能
 *  1) 作为特定的功能，用于告诉编译器一些基础信息
 *  2) 编译时动态处理，如动态生成代码
 *  3) 运行时动态处理，作为额外信息的载体，如获取注解信息
 *
 * 标准注解: @override等等
 * 元注解:
 *  -> @Retention  注解的生命周期(在什么范围内有效)
 *      SOURCE => 只能在被标注的源文件中保留, 编译后会被去除
 *      CLASS  => 编译后标注的注解还会出现在class文件中
 *      RUNTIME => 运行时候有效，运行时候保留（程序运行的时候经常使用该注解）
 *  -> @Target     注解的作用目标
 *  -> @Inherited  是否允许子类继承该注解
 *  -> @Documented 注解是否应当被包含在JavaDoc文档中
 * 自定义注解
 * @author yangqian
 * @date 2021/1/1
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface TestAnnotation {
}
