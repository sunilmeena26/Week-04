package com.day05.javaregularexpression;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Create a class IPAddressValidation to check the IP Address is valid or not
class IPAddressValidation{

    //Create a static method isValidPlateNumber to check Plate number is valid or not
    public static boolean isValidIPAddress(String ipAddress){
        //Create a variable to store the regular expression
        String  regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        //Create a reference  and call the compile method to compile the regular expression
        Pattern compileExpression = Pattern.compile(regex);

        //Create a reference of Matcher class and call the method
        Matcher matcher = compileExpression.matcher(ipAddress);

        //Call the method and return the result
        return matcher.matches();
    }
}

//Create a class ValidateLicensePlateNumber
public class ValidateAnIPAddress {
    public static void main(String[] args) {
        //Create an object of Scanner class
        Scanner input = new Scanner(System.in);

        //Create a variable and take input
        System.out.print("Enter IP Address: ");
        String ipAddress = input.nextLine();

        //Create a variable and call the method
        boolean isValid = IPAddressValidation.isValidIPAddress(ipAddress);

        //Print the result
        if(isValid){
            System.out.println("Valid IP Address.");
        } else {
            System.out.println("Invalid IP Address.");
        }

        //Close the object
        input.close();
    }
}
