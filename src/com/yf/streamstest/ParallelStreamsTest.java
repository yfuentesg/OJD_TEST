package com.yf.streamstest;

import java.util.List;
import java.util.stream.Stream;

/*
    Parallel Streams are a type of Streams which have the ability to process in
    threads, running at same time.
    Are exactly as sequential Streams but all the methods they call running in parallel mode.   

    Of course , they should not be used in operations needed to be done in an specific order
 */
public class ParallelStreamsTest {

    public static void main(String[] args) {
        List<Integer> listInt1 = List.of(5, 7, 9, 1, 19, 17, 14, 15, 21, 24, 30, 4, 7);
        Stream<Integer> streamInt1 = listInt1.parallelStream(); //This method creates a parallel Stream starting from a List

        Stream<Integer> streamInt2 = Stream.of(5, 7, 9, 1, 19, 17, 14, 15, 21, 24, 30, 4, 7);
        Stream<Integer> streamInt3 = streamInt2.parallel();//This method also creates a parallel Stream but starting from a Stream

        System.out.println("Number of odd elements = " + streamInt3.filter(a -> a % 2 == 0).count());
        
        System.out.println("Example of Parallel Stream ordering");
        Stream<Integer> streamInt4 = Stream.of(5, 7, 9, 1, 19, 17, 14, 15, 21, 24, 30, 4, 7);
        streamInt4
                .parallel()
                .sorted() //Here the stream is sorted
                .forEach(System.out::println); //But since is parallel the forEach is also done in parallel mode
                ;
                
        System.out.println("Example of Parallel Stream ordering and changing type");
        Stream<Integer> streamInt5 = Stream.of(5, 7, 9, 1, 19, 17, 14, 15, 21, 24, 30, 4, 7);        
        streamInt5
                .parallel()
                .sorted()
                .sequential() // here in this case the stream type is changed to secquential, so next step is not parallel
                .forEach(System.out::println);
                
    }
}
