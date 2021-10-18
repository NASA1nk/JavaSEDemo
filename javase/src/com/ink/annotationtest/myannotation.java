package com.ink.annotationtest;

public @interface myannotation {
    String value() default "hello";
}
