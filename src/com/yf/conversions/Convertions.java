package com.yf.conversions;

public class Convertions {
    
    public void ternary() {
        int x=100;
        int a=x++;
        int b=++x;
        int c=x++;
        int d=(a>b)?(a<c)?a:(b<c)?b:c:b;
        
        System.out.println(d);
    }
    
    
    public static void main(String[] args) {        
        /*IMPLICIT CONVERTIONS*/
        char c = 4;
        int a = 4;
        //char cerr = a; // THIS is an error. If The SOURCE TYPE IS NUMERIC(ANY TYPE) AND THE DESTINY IS CHAR 
        //buuut
        char car = 7; //Char accepts numbers
        car++;
        car+=5;
                
        float pi= 3.1416f;
        //long l = pi; //THIS is another error. IF THE DESTINY IS INTEGER AND THE SOURCE IS DECIMAL         
        
        /*NOTE:* Even if the explicit conversion fails, always is possible todo explicitly (Casting). Of course if types are related hierarchyly       
        */
        char c2 =(char) a;
        long l = (long) pi;
        
        /*NOTE: BOOLEAN IS NOT CONVERTIBLE TO ANOTHER TYPE IMPLICITY or EXPLICITLY*/
        boolean b = true;
        //int a2 = b;//NOT convertible;
        //int a2 = (int) b;//STILL NOT convertible;
        
        
        /*CONVERTION BETWEEN OBJECTS AND PRIMITIVE TYPES ARE NOT ALLOWED*/
        //A little obvious but important to mention it
        String s = "My String";
        //int a3 = s;
        //int a3 = (int) s;
        //s = 4;
        
        float f = 13;
        
        
        /*The Sum with two operands where an int is involved results in an int*/
        byte k = 7;
        //byte k1 = k1 + 3; //Error :S
        k++; //In this case its not an error since the ++ operator due the casting internally
        
        
        /*"Funny" convertion tests. Order matters folks*/
        System.out.println("2+1="+2+1);
        System.out.println("2+1="+(2+1));
        System.out.println(2+1+"=2+1");
        System.out.println('a'+1);
        System.out.println(2+1+"=2+1"+3+3);
    }
            
}
