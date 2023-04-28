package com.yf.stringtest;

public class StringTest {
    
    /*
    Due to string inmutability the new reference remains only into local
    variable (str) and it's not translated into (s) variable.
    */
    static void changeString(String str) {
        str = str + "World";
    }
    
    /*
    StringBuffer is mutable, so object string can be changed
    Take in considetation that ALWAYS is passed a copy of reference value
    */
    static void changeStringBuffer(StringBuffer strB) {
        strB.append(" World");
    }
    
    public static void main(String[] args) {
        String s= "Hello ";
        changeString(s);
        System.out.println("s = " + s);        
        
        StringBuffer sb = new StringBuffer("Hello");
        changeStringBuffer(sb);
        System.out.println("sb = " + sb);
    }
}
