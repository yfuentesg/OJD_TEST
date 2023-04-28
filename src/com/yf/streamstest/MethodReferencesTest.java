package com.yf.streamstest;

import com.yf.utils.Person;
import java.util.Comparator;
import java.util.stream.Stream;

public class MethodReferencesTest {
    
    /*
        This is other form to substituite lamba expressions which call a method
        
        parameters are NOT needed since they are deduced by context
    
        class/object::method_name
    */
    public static void main(String[] args) {
        Stream<Integer> streamInt1 = Stream.of(1,7,14,2,9,7);
        streamInt1
                .forEach(System.out::println); //printing the value
        
        Stream<Person> streamPerson2 = Stream.of(new Person("Jason", 38), new Person("Santi", 5), new Person("Bobull", 2));
        streamPerson2
                .sorted(Comparator.comparing(Person::getAge)) //ordering throught age
                .forEach(a -> System.out.println(a.getName())); //here is not easy to deduce which attribute will be used, that why I dont use method reference
        
    }
}
