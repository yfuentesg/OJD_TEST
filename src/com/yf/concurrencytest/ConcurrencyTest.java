package com.yf.concurrencytest;

/*
    There are two types of implementing Concurrency 

    In Both types method run contains the logic 
    Method Start initiates the Thread
*/


//1. Classes that extends Thread
class ThreadType1 extends Thread {
    
    @Override
    public void run() {

    }
}

//2. classes that implements interface Runnable
class ThreadType2 implements Runnable {

    @Override
    public void run() {
        someLogic();
    }
    
    //the synchronized method cannot be executed at the same time by more than one thread 
    synchronized public void someLogic() {
        //In here should be managed some resources shared
    }
    
}

public class ConcurrencyTest {
        
    public static void main(String[] args) {
        
        //Important to remember method start is the one who send the object to the thread NOT run 
        //start method MUST NOT be called twice
        //calling run is not an error but of cource doesnt send the process to thread just run secuentially
        
        ThreadType1 taskConcurrent1 = new ThreadType1();
        taskConcurrent1.start();
                
        //In second option a theread should be created and pass the runnable object
        Thread taskConcurrent2 = new Thread(new ThreadType2());
        taskConcurrent2.start();
        
    }
}
