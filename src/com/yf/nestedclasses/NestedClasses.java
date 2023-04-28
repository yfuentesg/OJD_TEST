package com.yf.nestedclasses;

/* README FIRST
    A top level class is a class that is not a nested class.
    A nested class is any class whose declaration occurs within the body of another class or interface.
    An inner class is a nested class that is NOT explicitly or implicitly declared static.


    Nested classes are divided into two categories: static and non-static. Nested classes that are declared static are simply called static nested classes. 
    Non-static nested classes are called inner classes.

    Further, a static nested class is behaviorally a top-level class that has been nested in another top-level class for packaging convenience.

    Inner classes can declare a static members only if it is a constant (i.e. final). To create a class variable for an inner class, 
    the programmer must place the desired variable in an enclosing class. It is helpful at this point to abuse the terminology somewhat, 
    and say, loosely, that the static keyword always marks a "top-level" construct (variable, method or class), which is never subject to an enclosing instance. 
    This shows why an inner class cannot declare a static member, because the entire body of the inner class is in the scope of one or more enclosing instances.

    Declaring a nested class static only means that instances of the class are created without having an outer instance. 
    It does not put any limits on whether the members of the class can be static or not.
*/

public class NestedClasses {

    int a;
    static int b;

    //1. This is an Example of internal class. Defined into other class
    //ALL access modifiers are permited even private
    private class Interna {
        //methods y attributes
    }

    //2. Static classes can be created
    //therefore this type of classes can ONLY access other static members of external class (NestedClasses)
    static class InternaStatic {
        //methods y attributes

        /*
        //twrows an error since a is not static        
        void increaseA() {
            a++;
        };*/
        void increaseB() {
            b++;
        }
    ;

    }
    
    
    public void method() {
        int variable1 = 1;
        final int variable2 = 2;

        variable1++; //line 1

        //3. This classes exists ONLY in method environment
        //ONLY can be instanciated inside the method and ONLY can access to FINAL variables 
        class LocalInMethod {

            /*
            //due to compiler assumes variable1 might change its value (hence not final) is not allowed to be used
            //NOTE: if "line 1" is commented "variable1" can be used since compiler understands its final :S. Very clever            
            boolean isOne(){
                return variable1 == 1;
            }*/
            boolean isTwo() {
                return variable2 == 2;
            }
        }

    }

    //-----
    public class InnerClass1 {
        //following validations apply ONLY for INNER CLASSES, non STATIC INNER CLASSES
        
        public int val1 = 4;

        int val2;

        //static int VAL3 = 5; //This is Wrong, static member are allowed ONLY When final
        static final int VAL4 = 4;

        public void method1() {

        }

        //This is Wrong, static member not allowed to methods
        /*static public void method2() {

        }*/
    }

    public static void main(String[] args) {
        //1. For creating instances of internal classes is needed a reference to external class
        //NOTE: this example was created as privated, hence cannot be used outside the class NestedClasses
        NestedClasses exter = new NestedClasses();
        NestedClasses.Interna inter = exter.new Interna();

        //2. in the case of static classes, is NOT needed a reference since its static 
        NestedClasses.InternaStatic interStic = new NestedClasses.InternaStatic();

        //4. This is the example of a annonimus class
        //ONLY apply with functional interfaces(interfaces with ONLY a method(Not counted the methods inherited from Object. Ex overriding toString))
        Runnable rn = new Runnable() {
            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
    }
}
