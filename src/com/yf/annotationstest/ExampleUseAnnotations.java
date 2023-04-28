package com.yf.annotationstest;

import com.yf.utils.Cat;
import com.yf.utils.Dog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExampleUseAnnotations {
    
    public static void main(String[] args) {
        
        //-------------------------------------------------------------------
        
        Dog myDog = new Dog("Oliver");
        
        if (myDog.getClass().isAnnotationPresent(VeryImportant.class)) {
            System.out.println("The Dog Class IS VeryImportant");
        } else {
            System.out.println("The Dog Class IS NOT VeryImportant");
        }
        
        Cat myCat = new Cat("Mishy");
        
        if (myCat.getClass().isAnnotationPresent(VeryImportant.class)) {
            System.out.println("The Dog Class IS VeryImportant");
        } else {
            System.out.println("The Dog Class IS NOT VeryImportant");
        }
        
        //-------------------------------------------------------------------
        System.out.println("Navigation through methods for Cat Class");
        for (Method method: myCat.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(VeryImportant.class)) {
               
               VeryImportant annotation = method.getAnnotation(VeryImportant.class);
                
               for (int i = 0; i< annotation.times(); i++) {
                   try {
                       method.invoke(myCat);
                   } catch (IllegalAccessException ex) {
                       Logger.getLogger(ExampleUseAnnotations.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (IllegalArgumentException ex) {
                       Logger.getLogger(ExampleUseAnnotations.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (InvocationTargetException ex) {
                       Logger.getLogger(ExampleUseAnnotations.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
                
            }
        }
        
        //-------------------------------------------------------------------
        
        
    }
}
