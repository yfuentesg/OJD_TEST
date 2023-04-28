package com.yf.variabledeclaration;

public class VariableDeclaration {
    
    
    public static void main(String[] args) {
        int a,b,c;        
        int l=5,m,n; //HERE Just l is beign initialized to 5. m, n are not
        int x,y,z=10; //same goes here
        
        int d=3,e=7,f=4; //HERE ALL variables are initialized
        
        int v1,v2,v3;
        
        //THIS is Valid
        v1= v2= v3 =100; //HERE ALL variables are initialized to 100
        
        //but...
        
        //int j1 = j2 = j3 = 300; //This is NOT VALID
        
        //VAR can be ONLY used in local methods. CAN NOT be used as an instance variable
        var k = 5;
        
        /*The following examples are ilegal for var uses*/
        //var l1; //the type must be defined
        //var l2=null; //same here
        //var l3=400, l4= 900; //multiple asignement into one line
        
    }
}
