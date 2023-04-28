package com.yf.exceptionstest;


/*
    Exceptions can be defined as abnormal situations during the execution of a program
    They differ from errors since Errors have not recovery..
    
    The super class is Exception. (This is a chopped version of hierarchy...)
                            |
                            |
    -------------------------------------------------------------------------
    |                       |                           |                   |
    RuntimeException       IOException                SQLException          ...
    |
    |
    NullPointerException
    ClassCastException
    IndexOutOfBoundException
    ...


    They are divided into:

    1. unchecked exceptions: Exceptions that JVM doesnt ask for validation
    The RuntimeException are unchecked 

    2. checked exeptions: Exceptions that JVM ASK for catching
    ALL the others exceptions are checked
    
 */
public class ExceptionsTest {

    public static void main(String[] args) {

        /*Following are examples of Uncheked Exceptions*/
        try {
            int[] numbers = new int[]{7, 8, 9};
            System.out.println("This is an error since pos 10 doesnt exists " + numbers[10]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }

        try {
            String str = null;
            System.out.println("This is an error since str hasnt been initialized " + str.length());
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

        try {
            Object obj = new String("Hello world");
            Integer integ = (Integer) obj;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        
        try {
            double d = 1/0.0; //NOTE: IMPORTANT. THIS is NOT an error, since the divition returns a double :|
            
            int n = 1/0;
        } catch (ArithmeticException ex) {
            ex.printStackTrace();
        }
                
        try {
           // Thread.sleep(-100);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }
}
