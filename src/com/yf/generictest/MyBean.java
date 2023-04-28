package com.yf.generictest;

//In theory the letter used for generic doesnt matter, buuut. 
//T stands for Type
//K stands for key.
//... and others :S
public class MyBean<T> {

    private T data;

    public MyBean(T input) {
        this.data = input;
    }

    MyBean() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setType(T input) {
        this.data = input;
    }

    public T getType() {
        return this.data;
    }

}
