package com.yf.switchtest;

public class SwitchTest {
    public static void main(String[] args) {
        
        int x = 5;
        int y = 6;
        switch(x) {  //Here we can use integer casteable types, as int, char, byte and String. ..
            case 1:  // the literals here must be the same type as the declared in switch (or casteable)  
                System.out.println("x=1");
                break;
            case 2:   
                System.out.println("x=2");
                break;
            case 3:   
                System.out.println("x=3");
                break;            
            default:                            //The position of default doesn't matter
                System.out.println("Default");
                break;
            case 4:   
                System.out.println("x=4");
                break;
            case 5:   
                System.out.println("x=5");
                break;
            /*//It will throw an error due to utilization of a variable. Unless its final 
            case y:
                System.out.println("x=y");
                break;
            --*/
        }
        
        final int l;
        l = 7; //NOTE. This is VALID :S
        final int k = 23;
        switch(l) {
            case 'a':
                break;
            case k:
                System.out.println("yes, this is valid because it's a final variable");
                break;
            case -10: //Yes, of course negative values are allowed (integers)
                break;
            case 100:
                break;    
        }
        
        byte b = 1;
        switch(b) {
            case 50:
            case 100:
            case -100:    
            //case 200:   // this option is INVALID, 200 doesnt fit into variable byte b
                
        }
        
        char c = 54;
        switch(c) {
            case 10:
            //case -10:  // this option is INVALID, -10 doesnt fit into char variable
            default:    
                
        }
        
        
    }
}
