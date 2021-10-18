package com.ink.annotationtest;

/**
 * @author ink
 * @date 2021年05月18日10:05
 */
public class AnnotationTest {
    public static void main(String[] args) {

    }
}
@myannotation(value = "hello")
class test{
    private String name;
    private int age;

    public test(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
