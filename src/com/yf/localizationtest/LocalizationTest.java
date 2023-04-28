package com.yf.localizationtest;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationTest {

    /*
        Locale class allow us working with applications with multiple languageS
        
        For that we must define some files with the structure name
        
        filename_country.properties
    
        when country is the country according to ISO369-1
    
        Those files must have a a key and a value like follows
        thekeydefined=the value assigned
        
        the value will change according to language
    
        ---
        regarding file properties if a file that corresponds to the Localization used
        java attempt to load according to default if no locale is especified, otherwise 
        the default file will be loaded...?
        
  
     */
    public static void getMessages() {
        Locale.setDefault(Locale.ITALY); //this way we can set the default locale for the system
        
        Locale loc = new Locale("fr", "FR");

        //the resource file must be loaded via 
        //it can be also reached with com//yf//localizationtest//recursos
        ResourceBundle rb = ResourceBundle.getBundle("com.yf.localizationtest.recursos", loc);
        System.out.println("The message is: " + rb.getString("key2"));

        //System.out.println("The message is: "+rb.getString("key99")); if a key doesnt exist it will throw an error
        System.out.println("The message is: " + rb.getString("key4")); //if key doesnt exist in lang file, will take the message in default file 
    }
    
    /*
      Formats can be done also according to geographic Locale  
      
      NumberFormat, DateFormat classes are abstract. SO in should be created using a factory method 
    */    
    public static void formatData() {
        double salary = 1750.97;
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        System.out.println("The salary seen in GERMANY: " + nf.format(salary));
        
        Date d = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.FRANCE);
        System.out.println("Date in seen FRANCE: " + df.format(d));
        
        LocalDate ld = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Formatting dates for new date classes: " + dtf.format(ld));
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Formatting dates in simpler way: " + sdf.format(d));
        
        LocalDate ld2 = LocalDate.of(2021, 04, 11);
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("eeee dd'th of' MMMM yyyy"); //In this example th of is added as an external particle
        System.out.println("" + dtf2.format(ld2));
        
    }

    public static void main(String[] args) {
        getMessages();
        formatData();
    }

}
