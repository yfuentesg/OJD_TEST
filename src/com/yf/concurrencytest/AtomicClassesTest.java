package com.yf.concurrencytest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicClassesTest {
    
    /*
        Atomic Classes are wrapper classes prepared to work in thread safe mode.
        
    AtomicInteger: 
        incrementAndGet()
        decrementAndGet()
        addAndGet(int delta)
        get()
    
    AtomicLong:
        It's similar to AtomicInteger
    
    AtomicBoolean:
        set(boolean newValue)
        get()
        compareAndSet(boolean expected, boolean newValue)
    */
    
    public static void main(String[] args) {
        
        //In this example num variable is thread safe, that means its consistent when changing by differents threads (3 in the example)
        //neverthe less the order in which the values will be printed wont be in order, since multiple concrrent executions are working with the variable
        //(run example)
        ExecutorService e = Executors.newCachedThreadPool();
        AtomicInteger num = new AtomicInteger(0);
        for (int i = 0; i < 3; i++) {
            e.submit(() -> System.out.println("Number in thread: "+num.incrementAndGet()));            
        }
        
        e.shutdown();
    }

}
