package com.yf.inheritancetest;


class FirstClass {

    public FirstClass() {

    }

    public FirstClass(int x) {

    }

}

class SecondClass extends FirstClass {
    
    public SecondClass() {
       //NOTE. First line in constructors is IMPORTANT.
       //The compiler automatically set HERE the call to superclass's constructor with NO perameters
       //If it doesnt exist. It will throw an error 
       
       //Others constructors besides the default can be called using super
       //Also the first line can be replaced when calling other constructors of class itself (using this)
       
       //See examples
    }
    
    public SecondClass(int a) {
        super(4);
    }
    
    public SecondClass(int a, int b) {
        this(1);
    }
}


public class Inheritance {
    
}
