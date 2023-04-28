package com.yf.javaiotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/*
    java.nio.Files provides some static methods to deal with file operations.
 */
public class FilesTest {

    public static void main(String[] args) {
        Path path = Path.of("C:\\workspace\\OJD_TEST\\src\\com\\yf\\javaiotest\\files\\filetotestnio.txt");

        System.out.println("Retreiving content file ");

        //NOTE: line and readAllLines give us the content file, but one is Stream and the other a List
        try {
            Stream<String> streamOfFileContent = Files.lines(path);
            streamOfFileContent.forEach(System.out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            List<String> listOfFileContent = Files.readAllLines(path);
            System.out.println("listOfFileContent.size = " + listOfFileContent.size());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //the static method newBufferedReader provides a Bufferedreader (easier than java.io) ;)
        try {
            String line;
            BufferedReader br = Files.newBufferedReader(path);
            while ((line = br.readLine()) != null) {
                System.out.println("line = " + line);
            }
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        //This method writeString allow us to write a String in appen mode.
        //NOTE: ... if file doen't exist it will throw an error :|
        try {
            Files.writeString(path, "Adding this line in append mode\n", 
                              Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            Logger.getLogger(FilesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //This method write receives an iterable (List) and append the info in a single file
        List<String> characters = List.of("Evony Maw", "Shang chi", "Cross bones");
        try {
            Files.write(path, characters, 
                              Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            Logger.getLogger(FilesTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //copy ... :'( 
        //move
    }

}
