package com.day04.javaexception;

//Create a class ExceptionPropagation to perform exception propagation
class ExceptionPropagation{
    //Create a static method method1 to generate ArithmeticException exception
    public static void method1(){
        int divide=10/0;
    }

    //Create a static method method2 throw method2 call the method1
    public static void method2(){
        method1();
    }
}

//Create a class ExceptionPropagationInMethods to use ExceptionPropagation class
public class ExceptionPropagationInMethods {
    public static void main(String[] args) {
      //Use a try-catch block to handle the exception
      try{
          //call the method method2
          ExceptionPropagation.method2();
      }
      catch (ArithmeticException ex){
          //print the massage
          System.out.println("Handled exception in main");
      }
    }
}
