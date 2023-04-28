package com.yf.javaiotest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/*
    The input/output states operations for retreive/send information to a source  

    There are two packages to do this
    1. java.io classic package
    2. java.nio (n states for NEW. Available since java 5), provides several enhancements
 */
public class JavaIOTest {

    static String path = "C:\\workspace\\OJD_TEST\\src\\com\\yf\\javaiotest\\files\\";

    /*
        Outputstream: Abstract class, represents an output to any source
        PrintStream: Subclass from Outputstream gives methods to send data to any source (System.out IS a PrintStream to send info to screen)
        FileOutputStream: Subclass from Outputstream gives methods to send data to a file
        FileWriter: Specific class for writing a file    
     */
    public static void writeFiles() {
        //There are several alternatives to write in a file
        //1. Using PrintStream
        try {
            PrintStream out = new PrintStream(path + "printedbyPrintStream.txt");
            out.println("VERY IMPORTANT TO REMEMBER");
            out.println("The data is saved in overwriting mode");
            out.println("If file doesn't exist, it's created");
            out.println("Of course if path doesn't exists, it will throw an error");
            out.close(); // Also if resource is not closed, then we wont see info in file :)
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2. Using FileOutputStream
        try {
            FileOutputStream fos = new FileOutputStream(path + "printedbyFileOutputStream.txt", true); //This method here, allow us to write in append mode or not 
            PrintStream out = new PrintStream(fos);
            out.println("In this case the PrintStream is used as an auxiliary object");
            out.println("We can specify if it goes on append mode or not ;)");

            out.close();
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //3. Using FileWriter
        try {
            FileWriter fw = new FileWriter(path + "printedbyFileWriter.txt");
            fw.write("The data is saved in overwriting mode\n");
            fw.write("If file doesn't exist, it's created\n");
            fw.close();

            FileWriter fw2 = new FileWriter(path + "printedbyFileWriter.txt", true);
            fw2.write("Also, the append mode can be specified :)");
            fw2.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
        //4. BufferedWriter :)        
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(path + "printedbyBufferedWriter.txt", true));
            br.write("The buffered writer is the fastest way due to improvements\n");

            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    /*
        Inputstream: Abstract class, represents an input from any source        
        FileInputStream: Subclass from Outputstream gives methods to read data from a file
        FileReader: Specific class for reading a file  
        BufferedReader: class with enhancements to reading operations
     */
    public static void dataInput() {
        System.out.println("This is the input using keyboard");

        //Scanner class is in java.utils :)
        Scanner sc = new Scanner(System.in); //System.in contains an static member of type Inputstream
        System.out.println("Text input using Scanner: ");
        String line = sc.nextLine();

        try {
            System.out.println("Text input using BufferedReader: ");
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(reader);
            line = br.readLine(); //This line can throw an exception            
            br.close();
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void readFiles() {
        System.out.println("Reading file printedbyBufferedWriter.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(path + "printedbyBufferedWriter.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("line = " + line);
            }
            
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        //For reading Binary files
        System.out.println("Reading file printedbyFileOutputStream.txt");
        try {
            File file = new File(path + "printedbyFileOutputStream.txt");
            FileInputStream fis = new FileInputStream(file);
            byte[] res = new byte[(int) file.length()];
            fis.read(res);
            
            fis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    
    /*
        Class File. Represents a path or a directory It contains several useful methods like :
        exists(): Indicate if exists
        isFile(): Indicate if a it is a file
        isDirectory(): Indicate if a it is a directory
        delete(): Indicate if it succeded (or not) when deleting a file
    */
    
    public static void main(String[] args) {
        writeFiles();
        dataInput();
        readFiles();
    }
}
