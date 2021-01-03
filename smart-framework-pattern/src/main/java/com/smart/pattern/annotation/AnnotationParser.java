package com.smart.pattern.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author yangqian
 * @date 2021/1/3
 */
public class AnnotationParser {

    /**
     * 解析类的注解
     */
    public static void parseTypeAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("com.smart.pattern.annotation.CourseEntity");
        // 获取Class对象的注解，而不是里面的方法或者成员变量的注解
        Annotation[] annotations = clazz.getAnnotations();
        // 循环获取 Class 中的注解信息
        for (Annotation annotation : annotations) {
            CourseInfoAnnotation courseInfoAnnotation = (CourseInfoAnnotation) annotation;
            System.out.println("Course Name : " + courseInfoAnnotation.courseName() + "\n"
                    + "Course Tag : " + courseInfoAnnotation.courseTage() + "\n"
                    + "Course Profile : " + courseInfoAnnotation.courseProfile() + "\n"
                    + "Course Index : " + courseInfoAnnotation.courseIndex() + "\n"
            );
        }
    }

    /**
     * 解析成员变量的注解
     * @throws ClassNotFoundException
     */
    public static void parseFieldAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("com.smart.pattern.annotation.CourseEntity");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // 判断成员变量中是否有指定注解类型的注解
            boolean hasAnnotation = field.isAnnotationPresent(PersonInfoAnnotation.class);
            if (hasAnnotation) {
                PersonInfoAnnotation personInfoAnnotation = field.getAnnotation(PersonInfoAnnotation.class);
                System.out.println("name : " + personInfoAnnotation.name() + "\n"
                    + "age : " + personInfoAnnotation.age() + "\n"
                    + "sex : " + personInfoAnnotation.gender() + "\n"
                );
                for (String language : personInfoAnnotation.language()) {
                    System.out.println("language : " + language);
                }
                System.out.println();
            }
        }
    }

    /**
     * 解析方法中的注解
     * @throws ClassNotFoundException
     */
    public static void parseMethodAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("com.smart.pattern.annotation.CourseEntity");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            // 判断成员变量中是否有指定注解类型的注解
            boolean hasAnnotation = method.isAnnotationPresent(CourseInfoAnnotation.class);
            if (hasAnnotation) {
                CourseInfoAnnotation courseInfoAnnotation = method.getAnnotation(CourseInfoAnnotation.class);
                System.out.println("Course Name : " + courseInfoAnnotation.courseName() + "\n"
                        + "Course Tag : " + courseInfoAnnotation.courseTage() + "\n"
                        + "Course Profile : " + courseInfoAnnotation.courseProfile() + "\n"
                        + "Course Index : " + courseInfoAnnotation.courseIndex() + "\n"
                );
            }
        }
    }

    public static void main(String[] args) throws Exception {
        parseTypeAnnotation();
        parseFieldAnnotation();
        parseMethodAnnotation();
    }

}
