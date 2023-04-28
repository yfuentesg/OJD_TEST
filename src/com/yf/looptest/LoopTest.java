package com.yf.looptest;

public class LoopTest {
    
    
    public static void main(String[] args) {
        /*
        The for have 3 parts
        1. initializacion
        2. condition. Expressions that return a boolean
        3. increment/decrement
        
        They are OPTIONAL :S 
        //next for is valid :'(
        for(;;) {
            
        }
        
        by the way the curly braces are optional Too
        for(;;) ;
        
        but is mandatory at least one instruction ;
        */
        
        //yep next is valid Too. Many initializacions, many increments/decrements separated by comma
        int c=0;
        for(int a=0,b=10; a<b; a++,b--,c=0) {
            System.out.println("a = " + a);
        }
        
    }
}
