package com.yf.statictest;

public class StaticTest {
    //static attributes belong to class not instance   
    static int staticAttribute;
    public int nonStaticAttribute = 17;
    
    //the static blocks are used ONLY ONE time in order to innitialize the class
    static {
        staticAttribute = 10;
    }
    //i didn't know we can create several blocks :S
    static {
        staticAttribute = 4;
    }
    
    //inside an static method we can use ONLY static members(variables or methods)
    //we cannot use non static members
    static void staticIncrement() {
        staticAttribute++;
        //nonStaticAttribute++; //compile ERROR
        //nonStaticMethod();//also compile error
    }
    
    public void nonStaticMethod() {
        staticAttribute++;
    }
    
    public static void main(String[] args) {
        System.out.println("staticAttribute = " + staticAttribute);
        
        StaticTest a = new StaticTest();
        StaticTest.staticIncrement();
        System.out.println("staticAttribute = " + a.staticAttribute);        
       
        StaticTest b = new StaticTest();
        StaticTest.staticIncrement();
        System.out.println("staticAttribute = " + b.staticAttribute);
        
    }
}
