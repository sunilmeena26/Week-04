package com.day05.javaregularexpression;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Create a class PlateNumberValidation
class PlateNumberValidation{
    //Create a static method isValidPlateNumber to check Plate number is valid or not
    public static boolean isValidPlateNumber(String plateNumber){
        //Create a variable to store the regular expression
        String  regex = "^[A-Z]{2}[0-9]{4}$";

        //Create a reference  and call the compile method to compile the regular expression
        Pattern compile = Pattern.compile(regex);

        //Create a reference of Matcher class and call the method
        Matcher matcher = compile.matcher(plateNumber);

        //Call the method and return the result
        return matcher.matches();
    }
}

//Create a class ValidateALicensePlateNumber
public class ValidateALicensePlateNumber {
    public static void main(String[] args) {
        //Create an object of Scanner class
        Scanner input = new Scanner(System.in);

        //Create a variable and to take user input
        System.out.print("Enter Plate Number: ");
        String plateNumber = input.nextLine();

        //Create a variable and call the method
        boolean isValid = PlateNumberValidation.isValidPlateNumber(plateNumber);

        //Print the result
        if(isValid){
            System.out.println("Valid Plate Number.");
        } else {
            System.out.println("Invalid Plate Number.");
        }

        //Close the object
        input.close();
    }
}
