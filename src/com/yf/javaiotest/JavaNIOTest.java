package com.yf.javaiotest;

import java.nio.file.Path;
import java.nio.file.Paths;

/*
    the package java.nio.files contains several funcionalities for input/output in files
    n stands for NEW
    
 */
public class JavaNIOTest {

    public static void main(String[] args) {
        //interface Path represents a path to a filename or directory
        //The implementation of Path can be created with these Factory methods.. 
        //NOTE: that can be created in two ways (buf methods are named different) :|

        Path path1 = Path.of("C:\\workspace\\OJD_TEST\\src\\com\\yf\\javaiotest\\files\\printedbyBufferedWriter.txt");
        Path path2 = Paths.get("/users/directory");

        System.out.println("path1 = " + path1.getFileName()); //in case of a file, return its name
        System.out.println("path2 = " + path2.getFileName()); //in case of directories returns the directory name

        System.out.println("Absolute path1 = " + path1.toAbsolutePath()); //returns absolute path
        System.out.println("Absolute path2 = " + path2.toAbsolutePath()); //from the directory ?? I actually dont get this exactly :|

        //normalize, resolvs relatives path and returns path normalized
        //remember .. means go up a folder ;)
        Path path3 = Path.of("c:\\tmp\\../myFile.txt");
        System.out.println("path3 normalized = " + path3.normalize());

        //this method returns the relative path from a path in respecto to other 
        //in this example is like how to get file.txt from myFile.txt
        //so, it gets 2 levels :|
        //if one of paths is not relative it will throw an error
        //again..., it's not clear to me 
        Path path4 = Path.of("c:\\tmp\\myFile.txt");
        Path path5 = Path.of("c:\\tmp\\..\\file.txt"); //remember here is like c:\\file.txt
        System.out.println("relative path = " + path4.relativize(path5));

        //resolve Resolves a path from other
        Path path6 = Paths.get("c:\\tmp\\..\\data.txt");
        Path path7 = Paths.get("new.txt");
        //it just attach new element with each other
        System.out.println("resolve :| = " + path6.resolve(path7)); //... again spechless :'(

        //getNameCount returns the number of elements path(without the root (element 0))
        Path path8 = Path.of("c:\\tmp\\myFile.txt");
        System.out.println("nameCount = " + path8.getNameCount());
        //getName returns the elements name in the position indicated (root not included). The elements start from 0
        System.out.println("getName = " + path8.getName(0));

    }
}
