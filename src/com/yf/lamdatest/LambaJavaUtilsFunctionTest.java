package com.yf.lamdatest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
    The class java.utils.Function provides several funcional interfaces in order to be implemented according to funcionality needed.
 */
public class LambaJavaUtilsFunctionTest {

    /*
    1. interfaces Predicate<T> ; BiPredicate<T, U>
    contains a method: boolean test(T t) ; boolean test(T t, U u). Used to evaluate according to parameters send. Returning a boolean
    
    2. interfaces Function<T, R> ; BiFunction<T, U, R>
    contains a method: R apply(T t) ; R apply(T t, U u). Used in context of data transformations T object in an object of type R. 
    
    3. interfaces Consumer<T> ; BiConsumer<T, U>
    contains a method: void accept(T t) ; void accept(T t, U u). Used in contex of processing. Example: printing data
    
    4. Supplier<T>
    contains a method: T get(). Used to implementate operations of data extraction
    
    5. UnaryOperator<T>
    contains a method: T apply(T t). Used in contex of data transformations T object in an object of type same type T. 
    Its variant is BinaryOperator<T> equivalent to BiFunction<T, U, R>
    
    
    NOTE: To primitive type are some variants like: IntPredicate, IntFunction, IntConsumer etc. And so on according to data type
     */
    public static void main(String[] args) {

        //1. example of interface Predicate<T>
        List<Integer> listIntegers = new ArrayList<>(List.of(7, 14, 4, 11, 23, 18, 1));

        //This method receives a Predicate which only limit for example is parameter beign subclass of Integer
        listIntegers.removeIf(a -> a % 2 != 0);//It removes ONLY odd numbers 
        System.out.println("listIntegers with even elements= " + listIntegers);

        //2. example of interface Function<T, R>. Receives a type T and transforms into R type
        listIntegers.stream().map(a -> "Integer converted in String: " + a).forEach((a) -> System.out.println(a));

        //3. example of interface Consumer<T>
        //Used in all the elements of list. Ex printing
        listIntegers.forEach((x) -> System.out.println("Navigating in lamba expressions is really short ;) " + x));

        //4. example of interface Supplier<T>
        //This generates a Stream of numbers between 1 and 500
        Stream.generate(() -> (int) (Math.random() * 500 + 1));

        //5. example of interface UnaryOperator<T>
        //In this example, the listcontext is replaced by its double value 
        listIntegers.replaceAll((a) -> a * 2);
        listIntegers.forEach((a) -> System.out.println(a));

    }

}
