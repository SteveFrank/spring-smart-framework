package com.smart.pattern.annotation;

/**
 * @author yangqian
 * @date 2021/1/3
 */
@CourseInfoAnnotation(
        courseName = "Java",
        courseTage = "计算机",
        courseProfile = "基础&提升&架构",
        courseIndex = 1)
public class CourseEntity {

    @PersonInfoAnnotation(name = "Frank", language = {"Java", "C++", "Python", "Scala", "Go"})
    private String author;

    @CourseInfoAnnotation(
            courseName = "Python",
            courseTage = "计算机-Extension",
            courseProfile = "基础&Flask&区块链",
            courseIndex = 2)
    public void getCourseInfo() {

    }

}
