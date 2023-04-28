package com.yf.javaiotest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
    Serialization is a process in which classes are transformed in bytes and can be 
    stored in files or transported between the network.
    
    The object serialized can be deserialized.

    The only requirement to Serialize is that the class must implement interface Serializable

    NOTE: Wrapper classes as Integer, Boolean, Double, String already implement Serializable
 */
//Interface Serializable doesn't have methods, so we dont need to implement something 
class UserApplication implements Serializable {
    String name;
    int id;
    transient String password; //This access modifier doesn't save the field in file. It will be save null value

    public UserApplication(String name, int id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

}

public class SerializationTest {

    static String path = "C:\\workspace\\OJD_TEST\\src\\com\\yf\\javaiotest\\files\\";

    public static void main(String[] args) {
        UserApplication user1 = new UserApplication("userXYZ", 1, "thesecretislove");

        try {
            FileOutputStream fos = new FileOutputStream(path + "userApp.obj");
            ObjectOutputStream out = new ObjectOutputStream(fos);

            out.writeObject(user1);

            out.close();
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(SerializationTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            FileInputStream fis = new FileInputStream(path + "userApp.obj");
            ObjectInputStream in = new ObjectInputStream(fis);

            UserApplication user2 = (UserApplication) in.readObject();

            in.close();
            fis.close();            
        } catch (Exception ex) {
            Logger.getLogger(SerializationTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
