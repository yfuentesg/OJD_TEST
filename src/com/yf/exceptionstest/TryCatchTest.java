package com.yf.exceptionstest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class SomeResource implements AutoCloseable {

    private String msj;

    public SomeResource(String msj) {
        this.msj = msj;
    }

    @Override
    public void close() {
        System.out.println("Closing resources. " + this.msj);
    }
}

public class TryCatchTest {

    public static void main(String[] args) {

        /*the blocks try has the objective of catching exceptions */
        try {

        } //System.out.println("args = " + args); //ThIS is an ERROR, must not be between the exceptions
        catch (Exception ex) {

        } finally {
            //block finally is optional. Is executed ALWAYS before finish the block
            //normally used to close resources
        }

        /*This is valid :P*/
        try {

        } finally {

        }

        //This is a valid multicatch 
        //if the exceptions has some parenting between them the subclass's catch must be before superclass's catch
        //otherwise it will throw an error
        try {

            BufferedReader br = new BufferedReader(new FileReader("afiledoesntexists.txt"));

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }

        try {

            BufferedReader br = new BufferedReader(new FileReader("afiledoesntexists.txt"));

            //} catch (FileNotFoundException|IOException  ex ) {// this is invalid since for multicatching exceptions must not have relation between them
        } catch (FileNotFoundException | ArrayStoreException ex) {

        }

        //----------------------------------------------------------------------
        /*Try with resources*/
 /*
        -It has the ability to automatically close "the resources" that implements the Interface Autocloseable (with the method close)
        -Those resources are closed in the reverse order they were created        
        -Something IMPORTANT to remember is that they are closed when the TRY ends, NOT when the CATCH ends (See example)
        
         */
        try (FileReader fr = new FileReader("afiledoesntexists.txt");
             BufferedReader br = new BufferedReader(fr)) {
        } catch (Exception e) {

        }

        System.out.println("Before the try catch with resources");

        try (SomeResource sr = new SomeResource("Example 1")) {
            System.out.println("Inside the try catch");
        } catch (Exception e) {
            System.out.println("Doing the exception with resources");
        }

        System.out.println("After the try catch with resources");

        /*The resource can be created before the try/catch block 
          but, must be an effective constant (I mean should not be changed. Also can be final)
         */
        SomeResource sr = new SomeResource("Example 2");
        //sr = new SomeResource(); //This will mark an error since the compiler interprets sr variable is not a constant
        try (sr) {

        } catch (Exception e) {

        }
        
        //NOTE: This is valid. a try with resources can omit catch and finally blocks
        try (sr) {
            
        }

    }
}
