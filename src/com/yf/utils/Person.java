package com.yf.utils;

/*This is a utility Class for doing Some calling when the examples need it*/
public class Person implements Comparable<Person> {

    private static long idCount;
    private long id;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.id = ++idCount;
        this.name = name;
        this.age = age;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ID: " + id + " ; Name: " + name + " ; Age: " + age;
    }

    @Override
    public int compareTo(Person p) {
        return (int) (this.id - p.getId());
    }
}
