package com.yf.streamstest;

import com.yf.utils.Person;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMethodsTest {

    /*
        SOMETHING VERY IMPORTANT to remember is that when used some method the stream is closed.
        And cannot be used again (Thats why i'll use several local variables for the examples (before the refactor ... :S))
     */
    public static void basicMethods() {

        System.out.println("*** Basic methods ***");

        //NOTE: Is common using pipelines doing something in a Stream and then processing again with a Stream method
        //The main idea is calling intermediate methods an then calling a method final (if apply)
        Stream<Integer> streamInt1 = Stream.of(7, 4, 9, 12, 1, 2, 8);
        Long streamCount = streamInt1.count(); // method final. Returns the count of elements (The data type returned is Long)
        System.out.println("streamCount = " + streamCount);

        Stream<Integer> streamInt2 = Stream.of(7, 4, 9, 12, 1, 2, 8);
        streamInt2.forEach(a -> System.out.println(a)); //method final. (returns void) navegate a Stream using a lamba expression (Consumer<T>)

        Stream<Integer> streamInt3 = Stream.of(7, 4, 7, 7, 1, 2, 8);
        System.out.println("The count with no duplicates: " + streamInt3.distinct().count()); //Distinct is an intermediate method. quit duplicates(according to equals) and returns a Stream

        System.out.println("The first n elements of a Stream");
        Stream<Integer> streamInt4 = Stream.of(7, 4, 9, 12, 1, 2, 8);
        streamInt4.limit(3).forEach(a -> System.out.println(a)); //Limit is an intermediate method.

        System.out.println("The Stream Skipping n elements");
        Stream<Integer> streamInt5 = Stream.of(7, 4, 9, 12, 1, 2, 8);
        streamInt5.skip(3).forEach(a -> System.out.println(a)); //Skip is an intermediate method.
    }

    public static void validationMethods() {

        System.out.println("*** Validations ***");

        //Validate the Stream content evaluating some condition (Predicate<T>)
        //Important these methods work in short circuit (See ShortCircuitOperatorsTest for examples)
        Stream<Integer> streamInt6 = Stream.of(7, 4, 9, 12, 1, 2, 8);
        System.out.println("is There at least one element > 10 ? : " + streamInt6.anyMatch(a -> a > 10)); //method final.

        Stream<Integer> streamInt7 = Stream.of(7, 4, 9, 12, 1, 2, 8);
        System.out.println("Are ALL the elements > 10 ? : " + streamInt7.allMatch(a -> a > 10)); //method final.

        Stream<Integer> streamInt8 = Stream.of(7, 4, 9, 12, 1, 2, 8);
        System.out.println("NONE of the elements > 10 ? : " + streamInt8.noneMatch(a -> a > 10)); //method final. Returns true if none of the elements fulfill the condition

        Stream<Integer> streamInt9 = Stream.of(7, 4, 9, 12, 1, 2, 8);
        System.out.println("FILTERING/Count elements > 3  : " + streamInt9.distinct().filter(a -> a > 3).count()); //method Intermediate. Filter according to a predicate
    }

    public static void searchMethods() {

        System.out.println("*** Search ***");

        Stream<Integer> streamInt10 = Stream.of(7, 4, 9, 12, 1, 2, 8);
        Optional<Integer> res10 = streamInt10.filter(a -> a % 2 == 0).findFirst(); //findFirst is a method final. Returns a datatype named Opcional<?> 
        if (res10.isPresent()) { //Optional wrapps the results. Attempting getting a value if it doesn't exists will throw an error
            System.out.println("The first even element = " + res10.get());
        }

        /*
            Note. Optional has several methods to encapsulate the final operations of Streams
            T get()
            T orElse(T otherValue)
            boolean ifPresent()
        
            Also exists variants to primitivetypes OptionalInt, OptionalDouble etc.
         */
        Stream<Integer> streamInt11 = Stream.of(7, 4, 9, 12, 1, 2, 8);
        Optional<Integer> res11 = streamInt11.min((a, b) -> a - b); //min is a method final. Returns a Opcional<?>. receives a Comparator(To provide the ordering method)
        if (res11.isPresent()) {
            System.out.println("The min element = " + res11.get());
        }

        Stream<Integer> streamInt12 = Stream.of(7, 4, 9, 12, 1, 2, 8);
        Optional<Integer> res12 = streamInt12.max((a, b) -> a - b); //max is a method final. Returns a Opcional<?>. receives a Comparator(To provide the ordering method)
        if (res12.isPresent()) {
            System.out.println("The max element = " + res12.get());
        }

    }

    public static void transformationMethods() {

        System.out.println("*** Transformations ***");

        Stream<String> streamStr13 = Stream.of("karen", "Santi", "oliver", "Jason");
        Stream<String> streamStrRes = streamStr13.map(a -> a.toUpperCase()); //map is an intermediate method and transforms EVERY element into other according to the Function<T, R> interface it receives as parameter

        /*There are some other map methods oriented to process primitives (mapToInt, mapToDouble etc)*/
        Stream<String> streamStr14 = Stream.of("karen", "Santi", "oliver", "Jason");
        IntStream streamIntRes = streamStr14.mapToInt(a -> a.length()); //It also returns data in its own wrapper data type (IntStream, DoubleStream, LongStream )

        /*
            The Primitives Interfaces IntStream, DoubleStream, LongStream obtain with methods 
            mapToInt, mapToDouble, mapToLong respectively have some methods in common
            sum(). Returns the sum of Stream in a object IntStream or DoubleStream or LongStream
            average(). Returns a double value with the average of Stream in an object DoubleStream
            max()/min(). Returns the minimum/maximum element of the Stream in a object IntStream or DoubleStream or LongStream 
            
         */
        //flatMap ?????
    }

    public static void intermediateProcessMethods() {

        System.out.println("*** Interminium proccesing ***");

        Stream<Integer> streamInt16 = Stream.of(7, 4, 9, 12, 1, 2, 8);
        System.out.println("Count of odd elements = " + streamInt16
                .filter(a -> a % 2 == 0)
                .peek(a -> System.out.println("odd element = " + a)) //Intermediate method which process a stream and returns exact same stream to do others final methods
                .count());

        //There are indeed something important to remember here
        //in this example peek doesnt show all the elements in stream
        //Thats because final allMatch method works in short circuit mode and like all the elements don't fullfill the 
        // condition, hence just proccess the elements that comply condition
        Stream<Integer> streamInt17 = Stream.of(7, 4, 9, 12, 1, 2, 8);
        streamInt17.peek(a -> System.out.println(a)).allMatch(a -> a > 5);

    }

    public static void orderingMethods() {

        System.out.println("*** Ordering ***");

        Stream<Integer> streamInt18 = Stream.of(7, 4, 9, 12, 1, 2, 8);
        streamInt18.sorted()
                .forEach(a -> System.out.println("Ordered stream element = " + a)); //Sorted() do its magic according to Natural Order defined in class

        Stream<Person> streamPerson19 = Stream.of(new Person("Jason", 38), new Person("Karen", 38), new Person("Santi", 5));
        streamPerson19.sorted((a, b) -> a.getAge() - b.getAge())
                .forEach(a -> System.out.println(a)); //But if some specific Ordering is needed then 

    }

    public static void reductionMethods() {

        System.out.println("*** Reduction ***");

        Stream<Integer> streamInt20 = Stream.of(7, 4, 9, 12, 1, 2, 8);
        System.out.println("The Sum of ALL the elements of stream = " + streamInt20.reduce((a, b) -> a + b) //final method, reduce ALL the elements of Stream applying a single value
                .get());

        System.out.println("*** Reduction to Collection***");
        /*
            final method collect transforms the stream into a Collection.
            It receives a Collector (sg) Object which give some implementation,
            Collector object is generated by Calling one of the static methods of Collectors class (pl)
         */
        Stream<Integer> streamInt21 = Stream.of(7, 4, 9, 12, 1, 2, 8);
        List<Integer> listInt = streamInt21.distinct()
                .collect(Collectors.toList()); // In this example a Stream is turned into a Collection

        Stream<Person> streamInt22 = Stream.of(new Person("Rick", 64), new Person("Morty", 15), new Person("Summer", 17), new Person("Diane", 31), new Person("Jerry", 32));
        Map<Long, String> mapStream22 = streamInt22.collect(Collectors.toMap(p -> p.getId(), p -> p.getName()));

        Stream<Person> streamInt23 = Stream.of(new Person("Tsubasa", 10), new Person("Sanae", 10), new Person("Ryo", 11), new Person("Genzo", 11), new Person("Taro", 10), new Person("Roberto", 28));
        Map<Integer, List<Person>> mapStream23 = streamInt23
                .collect(Collectors.groupingBy(p -> p.getAge())); // GroupingBy groups by a column and return a map with a list of objects 
        mapStream23.forEach((k, v) -> System.out.println("k=" + k + ", v=" + v));

        Stream<Person> streamInt24 = Stream.of(new Person("Jake", 8), new Person("Charlie", 42), new Person("Alan", 40), new Person("Bertha", 61));
        Map<Boolean, List<Person>> mapStream24 = streamInt24
                .collect(Collectors.partitioningBy(a -> a.getAge() > 15)); // In this case partitionBy receives a predicate and returns a Map with a list of objects indicating if fullfill o doesn't the given condition
        mapStream24.forEach((k, v) -> System.out.println("k=" + k + ", v=" + v));

        /*
            Also Collectors offers others methods like:
            averagingDouble: calculate the avg from all elements (also exists averagingInt, averagingLong)
            summingInt: Calculate sum from all elements (also exists summingLong, summingDouble) 
            joining: returns a collector concatenating in a single string all the elements of stream
         */
    }

    public static void main(String[] args) {

        basicMethods();

        validationMethods();

        searchMethods();

        transformationMethods();

        intermediateProcessMethods();

        orderingMethods();

        reductionMethods();

    }
}
