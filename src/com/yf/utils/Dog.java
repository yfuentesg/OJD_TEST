package com.yf.utils;

import com.yf.annotationstest.VeryImportant;

@VeryImportant
public class Dog {
    
    @VeryImportant
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public void bark() {
        System.out.println("Guauuu!!");
    }

    public void eat() {
        System.out.println("Dog Yummy!!");
    }
}
