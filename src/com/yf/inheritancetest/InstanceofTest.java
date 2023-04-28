package com.yf.inheritancetest;


class Father {
    
}

class Son extends Father {
    
}


class Neighbor {
    
}

public class InstanceofTest {
    /*
        instanceof is an operator that allow us validate parenting between an object and a class.
    */
    public static void main(String[] args) {
        Father f = new Father();
        Son s = new Son();
        Neighbor n = new Neighbor();
        
        if (s instanceof Son) {
            System.out.println("s is an instance of SON");
        }
        
        if (s instanceof Father) {
            System.out.println("of course s is an instance of FATHER");
        }
        
        /*IMPORTANT to remember, classes to be compared must be related, otherwise
          it will mark a compiling error  
        */
        
        /*
        if (n instanceof Father) {
          System.out.println("of course n is NOT a FATHER");  
        }*/
        
        /*
        if (f instanceof Number) {
          System.out.println("of course f is NOT a NUMBER");    
        }*/
        
    }
}
