package com.yf.lamdatest;

import java.util.ArrayList;
import java.util.List;


/*
functional interfaces: Are interfaces with ONLY ONE abstract method.
NOTE: they can have other methods like static, and default even they can have overriden methods for class Object 

lamba expressions give implementation to functional interfaces. It Returns the implementation itself(logic /Interface type). Not a value
 */
interface I1 {

    public void print();
}

interface I2 {

    public int sum(int a, int b);
}

class Person {

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }
}

public class LambaTest {

    public static void main(String[] args) {

        I1 interface1 = () -> System.out.println("Returning of interface");

        I2 interfaceSumValues = (a, b) -> a + b;

        //As you see return is optional but requires {}
        I2 interfaceSumValues1 = (a, b) -> {
            return a + b;
        };

        //In case of multiple line {} are required
        I2 interfaceMultValuesPlusFour = (a, b) -> {
            int res = a * b;
            return res + 4;
        };

        /*This is an example of implementation for a functional interface
          based on lamba expressions.
          REMEMBER Comparator Interface has ONLY a method compare which receives 2 parameters and retuns 0, -, + values
         */
        List<Person> persons = new ArrayList<>(List.of(new Person("Jason", 38),
                                                       new Person("karen", 37),
                                                       new Person("Santi", 4),
                                                       new Person("Oliver", 1)));

        persons.sort((a, b) -> a.age - b.age);

        System.out.println("persons = " + persons);

    }
}
