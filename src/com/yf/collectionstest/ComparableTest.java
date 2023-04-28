package com.yf.collectionstest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableTest {

    /*
    Arrays and lists can be ordered according to The Natural order of its objects
    Those objects MUST implement an interface named Comparable
    
    (NOTE: Wrapper classes and String class have already implemented this interface. In case of String class
    natural order is Alphabetically)
    
    In case objects dont implement Interface Comparable Natural Order can be defined with 
    Other Interface named Comparator
    
     */
    static class Person implements Comparable<Person> {

        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;

        }

        /*
        //Comparable only have one method to implement.
        
        There are three possibilities to return
        0: objects are equals
        >0: current object is bigger than object to compare
        <0: object to compare bigger than current object
         */
        @Override
        public int compareTo(Person o) {
            //In this example we order according to age, but if age is equal, order according name
            if (this.age - o.age == 0) {
                return this.name.compareTo(o.name);
            } else {
                return this.age - o.age;
            }
        }

        @Override
        public String toString() {
            return this.name + ": " + this.age;
        }
    }

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Yeison", 38));
        personList.add(new Person("Karen", 37));
        personList.add(new Person("Santi", 5));
        personList.add(new Person("Oliver", 2));
        personList.add(new Person("Mati", 12));
        personList.add(new Person("Sebas", 5));

        Collections.sort(personList); //This method sorts Collections. Of course if it receives an inmutable object it will throw an error 
        System.out.println("personList = " + personList);

        Integer[] numbers = {20, 15, 7, 1, -3, 19};
        Arrays.sort(numbers); //Method to sort arrays

        printArray2(numbers);

        int[] numbers2 = {20, 15, 7, 1, -3, 19};
        Arrays.sort(numbers2);  //As you see works with primitives too. :)

        Person[] persons2 = new Person[3];
        persons2[0] = new Person("Vilma", 65);
        persons2[1] = new Person("Alberto", 33);
        persons2[2] = new Person("Tas", 13);
        Arrays.sort(persons2);
        printArray2(persons2);
    }

    //Generic works only with objects ;)
    static <T> void printArray2(T[] myArray) {
        for (T o : myArray) {
            System.out.println("o = " + o);
        }
    }
}
