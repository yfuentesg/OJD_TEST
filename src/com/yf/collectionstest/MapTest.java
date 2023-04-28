package com.yf.collectionstest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapTest {

    /*
        Map is an Interface ancestor or other classes like HashMap, TreeMap, hastable
        The Idea here is to save data tied to an unique key index
     */
    public static void main(String[] args) {

        //NOTE: IMPORTANT. HashMap doesn't store the elements in an specific ORDER, is aleatory
        Map<Integer, String> tableMap = new HashMap<>();
        tableMap.put(40, "Hello");
        tableMap.put(10, "World");
        tableMap.put(30, "How its going");
        tableMap.put(null, "Bujijiji bu"); //IMPORTANT put method accepts null values (key, value)

        tableMap.putIfAbsent(10, "Hi");
        tableMap.put(null, "Kishishishi"); //To remember, put can change the current map value if the key already exists

        printMap(tableMap);

        //But, TreeMap orders by its key 
        Map<Integer, String> tableMap2 = new TreeMap<>();
        tableMap2.put(90, "Hello");
        tableMap2.put(10, "World");
        tableMap2.put(30, "How its going");
        tableMap2.put(100, null); //IMPORTANT of course here null values at KEY are not allowed. due its key ordering 

        printMap(tableMap2);

        Map<Integer, String> tableMap3 = new HashMap<>();
        populateMap(tableMap3);
        printMap(tableMap3); //Doesnt show nothing here due to inmutability :S

    }

    public static void printMap(Map<Integer, String> map) {
        System.out.println("Printing map... ");
        Set<Integer> keys = map.keySet(); //method to return ALL the keys
        for (Integer key : keys) {
            System.out.println("key = " + key + ", value=" + map.get(key)); //Get the value from its key
        }
    }

    public static void showValues(Map<Integer, String> map) {
        for (String value : map.values()) { //method to return ALL the values
            System.out.println("value = " + value);
        }
    }

    public static void populateMap(Map<Integer, String> map) {
        //IMPORTANT. The Maps created using this way are inmutable and doesn't accept null (key or value)
        //copyOf also returns an inmutable Map Map.copyOf(map);
        map = Map.ofEntries(Map.entry(1, "Championship"),
                Map.entry(17, "Marvel"),
                Map.entry(23, "Contest"),
                Map.entry(18, "of"));

    }

}
