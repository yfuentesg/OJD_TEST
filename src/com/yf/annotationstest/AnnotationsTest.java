package com.yf.annotationstest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
@interface PredifinedAnnotation {

    int attribute1() default 1;

    String attribute2() default "N/A";
};

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@interface Resource {
    String name();          //since no default value are set here, name is MANDATORY
    int level() default 0; //hence level would be optional
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@interface ResourceType {
    
}

/*
    Annotations allows give meta-data info from code 
    they MUST ALWAYS be set before classes, methods, or attributes

    @annotationName(attribute1 = value, attribute2 = value)

    values can be primitives, wrapper classes, String or enums. (NOT other types like dates or Objects)
    
    can be created like an interface using @interface

    @Retention and @Target are known as meta annotations, the body of annotations is composed of methods
    which determine the attributes of the annotation

    @Target indicates the element type which the annotation can be applied to (TYPE, FIELD, METHOD, CONSTRUCTOR, PARAMETER... etc)
    @Retention indicates the scope (SOURCE, CLASS, RUNTIME)

    @Repetable: is a meta-annotation used to indicate that an annotation can be applied more than once in the element (... :|)
 */
public class AnnotationsTest {

    @PredifinedAnnotation(attribute1 = 2, attribute2 = "other value")
    String myField;
    
    @Resource(name = "Lalo Salamanca", level = 2)
    String myField2;
    
    @PredifinedAnnotation
    public void myMethod() {
        String testType = new @ResourceType String("Nacho Varga"); //This is unconvetional but valid :S
    }
    
    

    public void standardAnnotations() {
        
        /*
            There are some standard annotations that is convinient to know about them
            @Override: used for overriding of methods, evaluated during compiling time            
            @Deprecated: used to identify that a class, attribute or method is deprecated and is not recomended its use
            @SafeVarargs: used to indicate varargs parameter doesn't use unsafe operations
            @SuppressWarnings: used to avoid warnings in source code (value = unchecked, unused, deprecation)
        */
                
        @SuppressWarnings("unused")
        int a = 2;
    }

    public static void main(String[] args) {

    }
}
