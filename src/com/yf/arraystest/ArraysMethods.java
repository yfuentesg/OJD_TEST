package com.yf.arraystest;

import java.util.Arrays;

public class ArraysMethods {

    public static void main(String[] args) {
        /*
        Arrays Class provides some statics methods to use. Some of them might be subject of test's questions
        NOTE: IMPORTANT. This methods require the arrays are ordered.
         */

        //1. binarySearch is a method which search a key into an array. And returns the position of that key
        int[] numbers = new int[]{2, 7, 14, 20, 1, 9};
        Arrays.sort(numbers);
        printArray(numbers);

        System.out.println("The number 14 has the position= " + Arrays.binarySearch(numbers, 14));

        //In case key is not inside the array the returned value is negative: -positionwhereshouldbe-1. (See example) :S
        System.out.println("The number 18 has the position= " + Arrays.binarySearch(numbers, 18));
        //of course if array is not ordered, returned value is aleatory
        
        //2. compare indicate if an array is bigger than other one. 
        //The returned values are the same for interfaces Comparable / Comparator
        //0:  arrays are the same
        //1:  array1 is bigger than array2
        //-1: array2 is bigger than array1
        int[] arr1 = new int[]{1, 7, 8, 4};
        int[] arr2 = new int[]{1, 7, 8, 1};
        System.out.println("Comparison between arrays = " + Arrays.compare(arr1, arr2));

        //3. 
        int[] arrl = new int[]{40, 70, 80};
        int[] arrk = new int[]{40, 70, 80, 84};
        int[] arrf = new int[]{40, 70, 80, 84};

        //if there is a difference returns the POSITION of difference
        System.out.println("The first difference between Arrl vs arrk is in position " + Arrays.mismatch(arrl, arrk));
        //if no diference is found, then returns -1
        System.out.println("The first difference between Arrl vs arrk is in position " + Arrays.mismatch(arrk, arrf));

    }

    public static void printArray(int[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            System.out.println("myArray[" + i + "] = " + myArray[i]);
        }
    }

}
