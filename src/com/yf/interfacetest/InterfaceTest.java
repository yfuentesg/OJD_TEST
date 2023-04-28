package com.yf.interfacetest;


//Interfaces are kinda a blueprint to define behaviour for classes 
//An interface can inherit for other interfaces (multiple allowed).

//Methods in interface are only declared but no implemented(abstract)
//First NOn-abtract class that implements interface is responsible for implementing those methods

// But in java 8 were introduced default methods, to give a default behaviour to those methods not implemented 
interface MyInterface1 {
    public void unimplementedMethod();
}

interface MyInterface2 {
    
    public default void implementedDefaultMethod() {
        System.out.println("Some logic by default");
    }
}

interface MyLastInterface extends MyInterface1, MyInterface2 {
    
}

public class InterfaceTest implements MyLastInterface {

    @Override
    public void unimplementedMethod() {
        System.out.println("Some logic implementing method");
    }
        
    public static void main(String[] args) {
        InterfaceTest itfTest = new InterfaceTest();
        
        itfTest.unimplementedMethod();
        itfTest.implementedDefaultMethod();
    }
}
