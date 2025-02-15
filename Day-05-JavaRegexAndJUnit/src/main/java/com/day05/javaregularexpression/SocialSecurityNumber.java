package com.day05.javaregularexpression;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Create a class SocialSecurity to validate SSN
class SocialSecurity{
    //Create a static method isValidSocialSecurityNumber to check SSN is valid or not
    public static boolean isValidSocialSecurityNumber(String ssn){
        //Create a variable to store the regular expression
        String  regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";

        //Create a reference  and call the compile method to compile the regular expression
        Pattern compileExpression = Pattern.compile(regex);

        //Create a reference of Matcher class and call the method
        Matcher matcher = compileExpression.matcher(ssn);

        //Call the method and return the result
        return matcher.find();
    }
}

//Create a class SocialSecurityNumber
public class SocialSecurityNumber {
    public static void main(String[] args) {
        //Create an object of Scanner class
        Scanner input = new Scanner(System.in);

        //Create a variable and take input
        System.out.print("Enter Text: ");
        String inputText = input.nextLine();

        //Create a variable and call the method
        boolean isValid = SocialSecurity.isValidSocialSecurityNumber(inputText);

        //Print the result
        if(isValid){
            System.out.println("Valid SSN.");
        } else {
            System.out.println("Invalid SSN.");
        }

        //Close the object
        input.close();
    }
}

