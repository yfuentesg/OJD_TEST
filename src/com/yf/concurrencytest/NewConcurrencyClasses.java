package com.yf.concurrencytest;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewConcurrencyClasses {

    static int counterShared = 0;

    /*
        Some of the new implementations for concurrence management
        are present since java v 5. in package java.utils.concurrent
        
    
        Executors(class)------------------ExecutorService (itf)
        (ExecutorServices Generates Obj)   |
                                           |
                                           | (works with)
                               ------------------------------------------------
                               |                        |                     |  
                               Future (itf)         Callable (itf)          Runnable (itf, we just saw)
                          (Controls execution)
     */
    public static void main(String[] args) {

        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(() -> System.out.println("Hello"));
        es.submit(() -> System.out.println("There")); //submit can receive an implementation of runnable or callable 

        es.shutdown();//if the shutdown command is not written, then the program will never ended (But threads will be executed)

        /*
            Callable is other interface which implements concurrent tasks
            Differs from Runnable in that is able to return a result and can throw Exceptions checked
            As Runnable doesn't receive anything
         */
        Callable<Integer> callExample = () -> {
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            return sum;
        };

        ExecutorService es2 = Executors.newCachedThreadPool();
        Future<Integer> res = es2.submit(callExample); //The submit method returns a Future<?> obj which can retreive the result 

        while (!res.isDone()) { //also it has some methods like isDone to know i the process has ended 
            System.out.println("Doing calculation...");
        }

        try {
            System.out.println("The result is: " + res.get()); // get Returns the value generated, if it hasn't ended wait until result
        } catch (InterruptedException ex) {
            Logger.getLogger(NewConcurrencyClasses.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(NewConcurrencyClasses.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*Those are example of valid calls to submit*/
        Future<String> res2 = es2.submit(() -> "Hi there ");
        Future<?> res3 = es2.submit(() -> new Object());

        es2.shutdown();

    }

    public static int threadSaveIncCounter() {
        //The interface Lock is used to synchronize 
        Lock l = new ReentrantLock(); //its suggested the object Lock be as an attribute of class (private, final ;))
        int res = 0;

        try {
            //boolean resT = l.tryLock(); //this method indicates if lock can be done. returns boolean and can be called multiple times
            l.lock(); //Prevents access to other threads. NOTE: This is VOID, so it doesnt return anything (And cannot be called more than once)            
            res = counterShared++; //return value and increment
        } finally {
            l.unlock(); //unlock access to code. Very important doing this in a finally section in order to unlock access
        }

        return res;
    }
    
    public void collectionsForConcurrence() {
        /*The collection objects for thread safe operations*/
        ConcurrentMap m;
        CopyOnWriteArrayList l;
        CopyOnWriteArraySet s;
    }
}
