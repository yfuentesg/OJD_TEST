package com.yf.generictest;

import java.awt.Container;
import javax.swing.JButton;

public class GenericsTest {

    /*
    Generic. allows a class working with ANY type of OBJECT (NOT PRIMITIVES)
     */
    public static void main(String[] args) {

        MyBean<String> bean1 = new MyBean<>("Hello world");
        MyBean<Integer> bean2 = new MyBean<Integer>(777);

        printBean(bean1);
        
        printBeanOnlyNumbers(bean2);
        
        doSomethingJButtontStuff(new MyBean<>(new Container()));
    }

    //The operator (?) comodin
    //Indicate any type
    public static void printBean(MyBean<?> bean) {
        System.out.println("bean = " + bean.getType());
    }
    
    //Also Is possible define the subtypes allowed for genetyc type 
    public static void printBeanOnlyNumbers(MyBean<? extends Number> bean) {
        System.out.println("bean = " + bean.getType());
    }
    
    //And also specify the hierarchy for the Type of object received
    public static void doSomethingJButtontStuff(MyBean<? super JButton> beanJButton) {
        
    }
    
    //Also a NON generic class can have methods using generics
    //dont be confused <T> expression is not a return type
    // example. <T extends Number> , <T super JButton> 
    // works only in this case to indicate to compiler the type definition
    public <T> void genericMethod(T genericParameter) {
        System.out.println("genericParameter = " + genericParameter.getClass().getName());
    }
}
