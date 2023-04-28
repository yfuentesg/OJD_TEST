package com.yf.annotationstest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD}) //TYPE means that can be used in declarations of class, interfaces or enums 
public @interface VeryImportant {
    int times() default 1;
}
