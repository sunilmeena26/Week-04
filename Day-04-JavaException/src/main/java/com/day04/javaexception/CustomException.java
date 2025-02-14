package com.day04.javaexception;

import java.util.Scanner;

//Create a class InvalidAgeException to perform custom exception
class InvalidAgeException extends Exception{
    //Create a constructor
    public InvalidAgeException(String message){
        //pass exception massage to present class constructor Exception to print the exception massage
        super(message);
    }
}

//Create a class GenerateCustomException to generate custom exception create by programmer and after handle the exception
class GenerateCustomException{
    //Create a static method validateAge to check user age and generate the exception if age is less the 18
    public static void validateAge(int age){
        //use try-catch to handle the exception
        try {
            //check user age condition
            if (age < 18) {
                //If age is less the 18 so generate the InvalidAgeException exception
                throw new InvalidAgeException("Age must be 18 or above");
            } else {
                System.out.println("Access granted!");
            }
        }
        //handle the exception using catch block
        catch (InvalidAgeException ex){
            System.out.println("Exception is: "+ex.getMessage());
        }
    }
}

//Create a class CustomException to use GenerateCustomException class
public class CustomException {
    public static void main(String[] args) {
        //Create a scanner class object for take user input
        Scanner input=new Scanner(System.in);

        System.out.println("Enter a age: ");
        //take age as user input
        int age=input.nextInt();

        //call the method
        GenerateCustomException.validateAge(age);

        //close the scanner
        input.close();
    }
}
