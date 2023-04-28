package com.yf.arraystest;

public class ArraysTest {

    static public void oneDimension() {
        //Examples of arrays declaration
        //Important. After declaration arrays are already initialized (In this case 0)
        int[] array1 = new int[5];
        int array2[] = new int[]{6, 4, 1, 0, 7, 8, 1, 3, 7, 9, 5}; //we can, declare, instantiate, and initialize in one single line
        int array3[] = {7, 7, 7}; //short Initialization         
        int array4[] = {}; //This is valid

        for (int i = 0; i < array1.length; i++) {
            System.out.println("array[" + i + "] = " + array1[i]);
        }

        //this is other way to navigate arrays
        //NOTE: the variable named data doesnt represent the array values. In the example array2 hasnt been modified
        for (int data : array2) {
            System.out.println("data = " + data);
            data = 5;
        }
    }

    static void multipleDimensions() {
        //examples of multi dimensional declarations
        int[][] table1 = new int[5][5];
        int table2[][] = {{1, 1, 3}, {5, 6, 7}};
        int[] cube1[][] = new int[3][3][4];

        for (int i = 0; i < table1.length; i++) {
            for (int j = 0; j < table1[i].length; j++) {
                System.out.println("table1[" + i + "][" + j + "] = " + table1[i][j]);
            }
        }

        for (int[] s : table2) {
            for (int n : s) {
                System.out.println("n = " + n);
            }
        }

    }

    //When creating multidimensional arrays its possible not asign last dimensions
    static void irregularArrays() {
        int[][] d = new int[5][];
        int[][][] n = new int[5][][];
        int[][][] v = new int[2][10][];       
        
        /*       
       //next examples are incorrect, first/intermidiate positions must be defined
       int[][][] h = new int[5][][8];
       int[][][] l = new int[][3][3];
       int[][] lk = new int[][];
       */
        
        int[][] data = new int[5][];
        data[0] = new int[]{4, 5, 7};
        data[1] = new int[]{3, 2, 1};
        
        //data[2] = {4, 5, 7}; //short Initialization not allowed
    }

    //Arrays are objects of same data type grouped continously :|
    public static void main(String[] args) {
        oneDimension();
        multipleDimensions();
        irregularArrays();
    }
}
