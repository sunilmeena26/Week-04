package com.day04.javaexception;

import java.util.Scanner;

//Create a class UseFinallyBlock to use finally block if we compulsory execute some of code in any condition
class UseFinallyBlock{
    //Create a static method integerDivision to print the result of division and handle the exception
    public static void integerDivision(){
        Scanner input=new Scanner(System.in);
        //Use try-catch block to handle the exception
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

        //use finally block to compulsory execute some code in any condition
        finally {
            System.out.println("Operation completed");

            //close the scanner
            input.close();
        }

    }
}

//Create a class FinallyBlockExecution to use UseFinallyBlock class
public class FinallyBlockExecution {
    public static void main(String[] args) {
        //call the method integerDivision
        UseFinallyBlock.integerDivision();
    }

}
