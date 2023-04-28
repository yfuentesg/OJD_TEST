package com.yf.utils;

import com.yf.annotationstest.VeryImportant;

public class Cat {

    private String name;

    public Cat(String name) {
        this.name = name;
    }
    
    @VeryImportant(times = 3)
    public void bark() {
        System.out.println("Miauuu!!");
    }

    public void eat() {
        System.out.println("Cat Yummy!!");
    }
}
