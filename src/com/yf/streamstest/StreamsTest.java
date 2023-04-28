package com.yf.streamstest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamsTest {
        
    /*Streams are objects which allow us go over a bunch of data 
    and performs operations like search, processing etc 
    
    the interface is java.utils.Stream
    
    There are certain Streams to work with primitive data example IntStream, DoubleStream etc.
    
    There are two types of methods (See StreamMethodsTest Class for examples)
    
    a. intermediate: The result of those is a new Stream
    example, filtering, ordering, data transformations etc
    
    b. finals: The result of those is a result
    Example a void, a sum, a search etc.    
    */
    public static void main(String[] args) {
        
        /*Streams can be created in several ways*/
        
       //1. via Collections
        List<Integer> listInt = new ArrayList<>(List.of(10, 14, 20, 5, 9, 7, 1, 15));
        Stream<Integer> streamInt = listInt.stream();
        
        //2. via arrays
        String [] strings = new String[]{"Hi", "How it's", "Going", "Buddy!"} ;
        Stream<String> streamStr = Arrays.stream(strings);
        
        //3. via a series of data
        Stream<Double> streamDbl = Stream.of(2.1, 7.0, 1.0, 3.14);
        
        //via. range of data
        IntStream streamInt2 = IntStream.range(1, 10);
        IntStream streamInt3 = IntStream.rangeClosed(1, 10);
        
    }
}
