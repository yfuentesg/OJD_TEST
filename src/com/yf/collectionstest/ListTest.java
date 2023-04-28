package com.yf.collectionstest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListTest {

    /*
        List is an Interface ancestor or other classes like ArrayList, LinkedList ... 
     */
    public static void main(String[] args) {

        List<String> cadenas = new ArrayList<>();
        cadenas.add("Hello");
        cadenas.add("World");
        cadenas.add("How it's going");

        List<String> listas = List.of("100", "200", "America", "Junior", "Nacional");
        //listas.add("x");  //The lists created using This factory method are inmutable. That said, it cannot be changed. It does not accept null values either

        List<Integer> numer = Arrays.asList(9, 2, 3, 4, 7, 14, 28, 0);
        //numer.remove(3);  //The lists created using This factory are ALSO inmutable. That said, it cannot be changed. It does not accept null values either

        List<Integer> otherInmutableList = List.copyOf(numer); //This factory is also inmutable, and doesnt accept null values

        //Lists can be iterated via for or enhanced loop. ALSO lamba expressions can be used to do this
        for (int i = 0; i < cadenas.size(); i++) {
            System.out.println("cadenas = " + cadenas.get(i));
        }

        for (String item : listas) {
            System.out.println("item = " + item);
        }

        List<Integer> numMutable = new ArrayList(Arrays.asList(9, 2, 3, 4, 7, 14, 28, 0)); //IN this way list can be mutable :)
        numMutable.remove(4);

        for (int i : numMutable) {
            System.out.println("i = " + i);
        }

        String strIntegers = "14 17 32 1";
        List<String> list = Arrays.asList(strIntegers.split(" ")); //NOTE: This lists is ALSO inmutable.
        //list.add("4"); //So this operation throws an error during execution time

        /*Eliminations :S*/
        List myLista = new ArrayList(); //if not type specyfied we can enter whatever we want ;)
        myLista.add("8");
        myLista.add("0");
        myLista.add("1");
        myLista.add("9");
        myLista.add("8");
        myLista.add(1);

        //The Important thing here to remember is that remove method has 2 implementations
        //the one receiving an object, returns true/false. The other one receiving an index returns the removed object itself ;S
        System.out.println(myLista.remove("8") + " " + myLista.remove(2));

        //myLista.remove(7); //hence this wold throw index out of bound exception
        myLista.remove("7"); //and this doesnt throw an error but retuns false instead

        System.out.println("myLista = " + myLista);

        unmodifiableMethods();

    }

    public static void weirdInitializations() {
        Iterable<Integer> iter = List.of(7, 4, 5);
        var data = new ArrayList<>();
        Collection<?> col = List.of(7, 7, 7);

        //ArrayList<String> cad = List.of("HI", "THERE"); //Warning. This might seem valid, but remember List.of returns a List object, and its being initializated to an ArrayList(which implements List)        
    }
    
    /*Collection class has some methods to create a VIEW unmodifiable of list, Set, etc*/
    public static void unmodifiableMethods() {
        
        System.out.println("*** unmodifiableMethods ***");

        List initialList = new ArrayList();
        initialList.add("one");
        initialList.add("two");
        initialList.add("three"); //This part instanciate a list

        List inmutableList = Collections.unmodifiableList(initialList); 

        try {
            inmutableList.add("four"); //this VIEW is inmutable. That means no changes allowed, so this will throw an exception
        } catch (Exception e) {
            e.printStackTrace();
        }

        initialList.add("five"); //modifying initial list will affect the VIEW
        inmutableList.stream().forEach(System.out::println);

    }

}
