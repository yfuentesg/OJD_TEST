package com.yf.collectionstest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

    /*
        Comparator is other Interface to allow ordering. It could be used for example in cases when we dont have access to class to order
        This example is exactly like Comparable Interface :|
     */
    public class Course implements Comparator<Course> {

        private int duration;
        private String name;

        public Course(String name, int duration) {
            this.name = name;
            this.duration = duration;
        }

        @Override
        public String toString() {
            return "name: " + this.name + ", duration: " + this.duration;
        }

        @Override
        public int compare(Course c1, Course c2) {
            return c1.name.compareToIgnoreCase(c2.name);
        }

    }
    
    /*
        This Class Instead doesn't have implemented the behaviour to make the ordering (see line 1)
    */
    
    public class Software {

        private String name;
        private String tecnology;
        private String company;

        public Software(String name, String tecnology, String company) {
            this.name = name;
            this.tecnology = tecnology;
            this.company = company;
        }

        @Override
        public String toString() {
            return "Name: " + this.name + ", Tecnology: " + this.tecnology + " " + this.company +"\n";
        }
    }

    public static void main(String[] args) {
        ComparatorTest test = new ComparatorTest();

        List<Course> courses = new ArrayList<>();
        courses.add(test.new Course("Economy", 5));
        courses.add(test.new Course("History", 12));
        courses.add(test.new Course("Math", 12));
        courses.add(test.new Course("Spanish", 6));
        courses.add(test.new Course("Domestic Stuff", 3));

        System.out.println("courses = " + courses);

        List<Software> softwares = new ArrayList<>();
        softwares.add(test.new Software("Sp6", "Oracle Forms, Plsql", "AspSols"));
        softwares.add(test.new Software("Sp7", "Java, Plsql", "AspSols"));
        softwares.add(test.new Software("Amerika", "Oracle Forms, Plsql", "Inassa"));
        softwares.add(test.new Software("BSCS", "Plsql, Shell", "Claro"));
        softwares.add(test.new Software("Core-API", "Java, Springboot", "Consensus"));
        softwares.add(test.new Software("Mgmt", "Java, html, css, Typescript", "Consensus"));
        softwares.add(test.new Software("CAM", "Java, Springboot, Angular", "Consensus"));
        
        
        /*
            In this example the Sort method is overloaded and we use the Version that receives 
            The Comparator (behaviour) to make the ordering
            NOTE. The example uses an annonimous class, but we could have Instanciate a variable Type Comparator<?> And pass it to the method sort
            Also, this is even easier with lamba expressions
        */
        softwares.sort(new Comparator<Software>() { //line 1
            public int compare(Software s1, Software s2) {
                return s1.name.compareToIgnoreCase(s2.name);
            }
        });
        
        
        //THIS IS a short version of ordering using lamba (Implementing interface Comparator (Exactly as line 85))
        //softwares.sort((a, b) -> a.name.compareToIgnoreCase(b.name));
        
        System.out.println("softwares = " + softwares);

    }
}
