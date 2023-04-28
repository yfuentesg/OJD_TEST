package com.yf.exceptionstest;

/*
 The custom exceptions are exceptions customized by user
 Just simply inheriting from Exception/RuntimeException.... etc
 */
class CustomException1 extends Exception {

    public CustomException1() {

    }
    
    public CustomException1(String m) {
        super(m); //in this example propagates a message
    }
}

class CustomException2 extends RuntimeException {

    public CustomException2(String m) {
        super(m); //in this example propagates a message
    }
}

public class CustomExceptionsTest {

    public void myMethod1() throws CustomException1 {
        throw new CustomException1(); //in this case throws is mandatory since CustomException1 is Checked
    }

    public void myMethod2() {
        throw new CustomException2("A message :)"); //in this case throws is NOT mandatory since CustomException2 is UnChecked
    }

    public static void main(String[] args) {

    }

}
