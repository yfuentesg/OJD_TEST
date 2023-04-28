package com.yf.collectionstest;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueTest {

    /*
    This special type allows working as a queue or a stack (colas dobles)
    Work with generics
    
     */
    public static void main(String[] args) {
        Deque<String> tail = new ArrayDeque();
        tail.add("Rick"); //add method add element at beggining of queue
        tail.add("Morty");
        tail.add("Summer");

        printQueue(tail);

        Deque<String> head = new ArrayDeque();
        head.push("Beth"); //push method add element at beggining of queue
        head.push("Jerry");
        head.push("Naruto");

        printQueue(head);

        //pool and remove method removes the first element of queue, doing the efect of stack or queue
        //both methods works the same
        tail.poll();
        printQueue(tail);

        head.remove();
        printQueue(head);

        //element, peek methods return first element (with no deleting)
        String firstElement = head.element();
        System.out.println("firstElement = " + firstElement);

        firstElement = tail.peek();
        System.out.println("firstElement = " + firstElement);

        System.out.println("head.size() = " + head.size());
        System.out.println("tail.size() = " + tail.size());
    }

    public static void printQueue(Deque<?> q) {
        System.out.println("Printing queue...");
        for (Object o : q) {
            System.out.println("o = " + o);
        }
    }
}
