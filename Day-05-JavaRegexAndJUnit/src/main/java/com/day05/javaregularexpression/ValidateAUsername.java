package com.day05.javaregularexpression;

import java.util.*;
import java.util.regex.*;

//Create a class UserNameValidation to check the valid name
class UserNameValidation{

    //Create a static method isValidUserName to check username is valid or not
    public static boolean isValidUserName(String username){
        //Create a variable to store the regular expression
        String  regularExpression = "^[a-zA-z][a-zA-Z0-9_]{4,15}$";

        //Create a reference  and call the compile method to compile the regular expression
        Pattern compileExpression = Pattern.compile(regularExpression);

        //Create a reference of Matcher class and call the method
        Matcher matcher = compileExpression.matcher(username);

        //Call the method and return the result
        return matcher.matches();
    }
}

//Create a class ValidateAUsername
public class ValidateAUsername {
    public static void main(String[] args) {

        //Create an object of Scanner class
        Scanner input = new Scanner(System.in);

        //Create a variable and take input
        System.out.print("Enter username: ");
        String userName = input.nextLine();

        //Create a variable and call the method
        boolean isValid = UserNameValidation.isValidUserName(userName);

        //Print the result
        if(isValid){
            System.out.println("Valid Username");
        } else {
            System.out.println("Invalid Username");
        }

        //Close the object
        input.close();
    }
}
