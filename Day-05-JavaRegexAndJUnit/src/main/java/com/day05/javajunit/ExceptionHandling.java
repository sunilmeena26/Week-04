package com.day05.javajunit;

//Create class to exception to generate ArithmeticException
class Exception {

    // Create a static method to divide two integers
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
}

//Create a class ExceptionHandling to use Exception class
public class ExceptionHandling extends Exception {
    public static void main(String[] args) {
        //use try-catch block to handle exception
        try{
            Exception.divide(10,0);
        }catch (ArithmeticException ex){
            System.out.println(ex.getMessage());
        }
    }
}
