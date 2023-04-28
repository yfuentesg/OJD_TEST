package com.yf.javatimetest;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZonedDateTime;

public class InstantTest {

    /*
      An Instant represents a moment concrete in GMT Zone
      The momment taken as the base is 1970-01-01T00:00:00 (greenwich :S) 
     */
    public static void instants() {

        System.out.println("Instants...");

        Instant i1 = Instant.now();
        System.out.println("i1 = " + i1);

        var i2 = Instant.ofEpochSecond(2_000_000); //2.000.000 of seconds from base time 
        System.out.println("i2 = " + i2);

        ZonedDateTime zdt = ZonedDateTime.parse("2017-11-23T16:20:30-05:00[America/Bogota]");
        var i3 = zdt.toInstant();
        System.out.println("i3 = " + i3);

    }

    /*
        Period represents a period of time measured in years, months, days
     */
    public static void periods() {

        System.out.println("Periods...");

        Period p1 = Period.of(3, 5, 10); //3 years , 5 months, 10 days
        Period p2 = Period.ofMonths(4);
        Period p3 = Period.ofDays(15);
        var p4 = Period.ofYears(5);

        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        System.out.println("p3 = " + p3);

        LocalDate ld1 = LocalDate.parse("2017-11-23");
        LocalDate ld2 = ld1.plus(p4);  // A period can be added to dates

        System.out.println("ld1 = " + ld1);
        System.out.println("ld2 = " + ld2);

        try {
            LocalTime lt = LocalTime.of(10, 15);
            lt.plus(p1); //A period cannot be added to dates. This here will throw an error
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        //Period can be used to calculate interval between dates
        //IMPORTANT: Just apply for LocalDate NOT LocalDateTime neither LocalDate
        var ld3 = LocalDate.of(1984, Month.APRIL, 11);
        var p5 = Period.between(ld3, ld1);

        System.out.println("p5 = " + p5);

    }

    /*
       Duration represents intervals measured in hours , minutes, seconds 
     */
    public static void durations() {

        System.out.println("Durations...");

        Duration d1 = Duration.ofDays(2); //return the info in hours
        var d2 = Duration.ofHours(4);
        var d3 = Duration.ofSeconds(1500);

        var d4 = d1.plusHours(2);

        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("d3 = " + d3);
        System.out.println("d4 = " + d4);

        LocalTime lt = LocalTime.parse("03:50");
        LocalTime lt2 = lt.minus(d4);

        System.out.println("lt = " + lt);
        System.out.println("lt2 = " + lt2);

        try {
            LocalDateTime ldt = LocalDateTime.now();
            ldt.plus(d1);
            
            LocalDate ld = LocalDate.now();
            
            ld.plus(d1); //A LocalDate cannot be added time

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        
        LocalDateTime ldt1 = LocalDateTime.parse("2017-11-22T12:20:30");
        LocalDateTime ldt2 = LocalDateTime.parse("2017-11-23T16:24:35");
        
        var d = Duration.between(ldt1, ldt2);//NOTE: between apply in this case for classes with hours(LocalTime, LocalDateTime, ZonedDateTime)
        
        System.out.println("d = " + d);
    }

    public static void main(String[] args) {

        instants();

        periods();

        durations();
    }
}
