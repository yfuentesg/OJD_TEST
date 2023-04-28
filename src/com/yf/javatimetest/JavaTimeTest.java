package com.yf.javatimetest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class JavaTimeTest {

    /*
        java.time is a class included since java 8 to handle dates
        It have several Classes to do iT
    
        They dont have public constructors , instead they have static factory methods to create new objects (of method)
    
        IMPORTANT: They are inmutable, that means they cannot be changed, methods like plus, addHour .. etc returns NEW objects

     */
    public static void creatingDateTime() {

        System.out.println("Creating objects");
        LocalDate ld1 = LocalDate.of(2023, 04, 11); //year, month, day        
        LocalDate ld2 = LocalDate.of(2023, Month.NOVEMBER, 4); //This factory class is overloader and can also work with enums

        LocalTime lt = LocalTime.of(10, 50); //hour, minute

        //They are very very overloaded, this one can work with seconds or not, with enums or not ... :|
        LocalDateTime ldt = LocalDateTime.of(2023, Month.NOVEMBER, 23, 16, 20, 30);//year, month, day, hour , minutes, seconds
        LocalDateTime ldt2 = LocalDateTime.of(ld2, lt); //created from LocalDate and a LocalTime :S

        ZoneId zi = ZoneId.of("America/Bogota");
        ZonedDateTime zdt = ZonedDateTime.of(ldt, zi);

        System.out.println("ld1 = " + ld1);
        System.out.println("lt = " + lt);
        System.out.println("ldt = " + ldt);
        System.out.println("zi = " + zi);
        System.out.println("zdt = " + zdt);

        //of course creating this objects with incorrect data according of its type will throw an exception
        try {
            LocalDate ldbad = LocalDate.of(2022, 17, 04);
        } catch (Exception e) {
            System.out.println("ERROR: " +e.getMessage());
        }
    }

    /*
        A string can be used to create them using standard format
     */
    public static void parsingDateTime() {

        System.out.println("Parsing strings");
        LocalDate ld1 = LocalDate.parse("1984-04-11");

        LocalTime lt = LocalTime.parse("10:27");

        LocalDateTime ldt = LocalDateTime.parse("2017-11-23T16:20:30");

        ZonedDateTime zdt = ZonedDateTime.parse("2017-11-23T16:20:30-05:00[America/Bogota]");

        var ldt2 = LocalDate.parse("04/11/1984", DateTimeFormatter.ofPattern("dd/MM/yyyy")); //Also an specific format can be indicated

        System.out.println("ld1 = " + ld1);
        System.out.println("lt = " + lt);
        System.out.println("ldt = " + ldt);
        System.out.println("zdt = " + zdt);
        System.out.println("ldt2 = " + ldt2);
    }
    
    /*
        as I already said this objects are inmmutables, so applying methods to them dont change its info
    */
    public static void manipulatingDateTime() {
        
        System.out.println("Manipulating....");
        
        LocalDate ld = LocalDate.parse("1984-04-11");
        LocalDateTime ldt = LocalDateTime.parse("2017-11-23T16:20:30");
        
        var newld = ld.minusDays(2);
        
        System.out.println("ld = " + ld); //hasn't been changed
        System.out.println("newld = " + newld);
        
        try {
            ldt.minusHours(2);
            //ld.minusHours(2); //this method doesnt exist in class (dates dont have hours :S)
            
            ld.plus(1, ChronoUnit.HOURS); //this method will throw an error since dates dont have hours
        } catch(Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        
        
    }
    
    public static void main(String[] args) {

        creatingDateTime();

        parsingDateTime();
        
        manipulatingDateTime();

    }
}
