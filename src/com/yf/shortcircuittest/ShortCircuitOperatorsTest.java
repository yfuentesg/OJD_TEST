package com.yf.shortcircuittest;

public class ShortCircuitOperatorsTest {
    
    /*
        || and && are called short circuiting operators because if, while evaluating a logical expression, 
        at any stage, the value of the whole expression can be determined without evaluating the rest of the expression, 
        then the remaining sub-expressions are not evaluated.
    
        & and | are nor short circuit operator so. The whole expression is evaluated
    */
    public static void main(String[] args) {
        boolean bool = true; 
        int k = 10;
        
        if (bool == false && ((k = 3) == 5)) {
            //Some logic
        }
        
        System.out.println(k);
        
        //-----
        
        bool = true; 
        k = 10;
        
        if (bool == false & ((k = 3) == 5)) {
            //Some logic
        }
        
        System.out.println(k);
    }
}
