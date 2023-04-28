package com.yf.equality;

class MyClass { }

public class Equality {
    public static void main(String[] args) {
        int a = 4;
        int b = 4;
        
        /*we can check the equality in two operands with ==*/        
        if(a == b)
            System.out.println("a equal b");
        
        /*for objects the == is valid ONLY to compare references*/
        MyClass c = new MyClass();
        MyClass d = new MyClass();
        
        if(c == d) {
            System.out.println("1. The references are the same");
        } else {
            System.out.println("1. The references are NOT the same");
        }
        
        /*The same goes for strings, unless we speak about the pools*/
        String e = new String("cadena");
        String f = new String("cadena");
        
        if(e == f) {
            System.out.println("2. the String references are the same");
        } else {
            System.out.println("2. the String references are NOT the same");
        }
        
        /*the pool example works according to inmutability*/
        String l = "cadena";
        String k = "cadena";
        
        if(l == k) {
            System.out.println("3. the String references(String pool) are the same");
        } else {
            System.out.println("3. the String references(String pool) are NOT the same");
        }
        
        /*the string can be compared used equals method, its because the string class overwrites the equals method(inherited by object)*/
        if(l.equals(k)) {
            System.out.println("The comparation using equals works");
        }
                
        /*here it works also according to inmutability */
        Integer i= 4;
        Integer j= 4;
        
        if(i == j) {
            System.out.println("the Integer references(Integer pool) are the same");
        } else {
            System.out.println("the Integer references(Integer pool) are NOT the same");
        }
        
        /*But Look watch out .. the string builder class in mutable, and its equals method ONLY compares references, due to its equals class is not overwritten*/
        StringBuilder fl = new StringBuilder("cadena");
        StringBuilder cl = new StringBuilder("cadena");
        if(fl.equals(cl)) {
            System.out.println("Comparing references with String builder");
        } else {
            System.out.println("The references with String builder are not the same ");
        }
        
        
    }
}
