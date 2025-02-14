package com.day04.javaexception;

import java.util.InputMismatchException;
import java.util.Scanner;

//Create a class HandleUncheckedException to handle unchecked exception Like ArithmeticException and InputMismatchException
class HandleUncheckedException{
    //Create a static method handleUncheckedException to print the result of division and handle the exception
    public static void handleUncheckedException(){
        Scanner input=new Scanner(System.in);
        //Use try-catch block to handle the uncheck exception
        try{
            //Create a variable number1 and number2 to store user input
            System.out.print("Enter A Number: ");
            int number1=input.nextInt();
            System.out.print("Enter A Number: ");
            int number2=input.nextInt();

            //Create a variable divideResult to store division result
            int divideResult=number1/number2;

            //print the result
            System.out.println("Division Reasult is: "+divideResult);
        }
        //Handle the ArithmeticException exception when Denominator is 0
        catch (ArithmeticException ex){
            System.out.println("Denominator should not be 0! "+ex.getMessage());
        }
        //Handle the InputMismatchException exception user input is non numeric value
        catch (InputMismatchException ex){
            System.out.println("Enter Numeric Value! "+ex.getMessage());
        }
        //close the scanner
        input.close();
    }
}

//Create a class UncheckedException to use HandleUncheckedException class
public class UncheckedException {
    public static void main(String[] args) {
        //call the method
       HandleUncheckedException.handleUncheckedException();
    }
    
}
