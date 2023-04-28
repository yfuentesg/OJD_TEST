package com.yf.collectionstest;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

    /*
    Set is an Interface ancestor or others abstract classes HashSet and TreeSet
    The Idea here is to save data from a group of elements (UNIQUE, NOT REPEATED) elements
     */
    public static void main(String[] args) {

        //HashSet is an implementation unordered
        Set<String> names = new HashSet<>();
        names.add("Jason");
        names.add("Karen");
        names.add("Santi");
        names.add("Oliver");
        names.add("Jason"); //If object exists does not add
        names.add(null);

        printSet(names);

        //TreeSet is ordered, of course it doesn't accept null values, because will throw an error(in runtime)
        Set<Integer> numbers = new TreeSet();
        numbers.add(60);
        numbers.add(100);
        numbers.add(10);
        numbers.add(30);
        printSet(numbers);

        //ALSO this type of stuffs are posssible, As usual this Set is unmutable  
        //so as this one Set.copyOf(names);
        Set<?> bizzareSet = Set.of(7, "HI");
        printSet(bizzareSet);

    }

    public static void printSet(Set<?> LocalSet) {
        System.out.println("Printing Set...");
        for (Object obj : LocalSet) {
            System.out.println("obj = " + obj);
        }
    }
}
