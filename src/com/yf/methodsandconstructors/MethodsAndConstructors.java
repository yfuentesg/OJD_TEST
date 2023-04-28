package com.yf.methodsandconstructors;

public class MethodsAndConstructors {
    int l;
    int k;
    
    //Initialization block are called before the constructor. One by every instance call (new)
    {
        l= 2;
    }    
    
    {k = 1;}
    
    /*
    Constructors are used to instanciate a class,
    they dont have a return type
    are named exactly as the class
    can be overloaded as following example, rules are the same as for methods
    if not declared one JVM creates it (default constructor), hence if we declare a constructor JVM doesn't create the default constructor 
    */
    public  MethodsAndConstructors(){ }   
            MethodsAndConstructors(double d){ }   
    private MethodsAndConstructors(int a){ }    //even if it doesn't look like it private constructors are valid :S (can be called inside other constructors)
    public  MethodsAndConstructors(int a, int b){this(4);} //We can call others constructors using this, Buuut MUST be the first instruction
        
    /*
    Overloading of methods are allowed under the rule: same method name, different argument list, regardless return type. Doesn't matter the access modifier
    when deciding which method to use. The compiler attempts matching the parameters send according to the following order
    1. Same type as defined in signature
    2. Attempts to promote the parameter.(see example)
    3. Unboxing    
    */    
    static public void  myMethod() {}
    static public float myMethod(double a) {System.out.println("method called: myMethod(double a)"); return 3f;}
    static public float myMethod(Double a) {System.out.println("method called: myMethod(Double a)"); return 4f;}
    static public void  myMethod(int a, Long b) {}
    static public int   myMethod(Float a, int b) {return 0;}
    
    public static void main(String[] args) {
        /*Compiler is unable to find an appropiate signature to this call*/
        //myMethod(3, 3);
        float f = myMethod(3d);
        float j = myMethod(3);
        
    }
}
