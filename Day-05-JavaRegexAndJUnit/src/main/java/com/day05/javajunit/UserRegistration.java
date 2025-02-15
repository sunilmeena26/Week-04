package com.day05.javajunit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Create a class Registration
class Registration{

    //Create a static method isValidUserName to check username is valid or not
    public static boolean isValidUserName(String username){
        //Create a variable to store the regular expression
        String  regex = "^[a-zA-z][a-zA-Z0-9_@]{4,15}$";

        //Create a reference  and call the compile method to compile the regular expression
        Pattern compileExpression = Pattern.compile(regex);

        //Create a reference of Matcher class and call the method
        Matcher matcher = compileExpression.matcher(username);

        //Call the method and return the result
        return matcher.matches();
    }

    //Create a static method isValidEmail to check Email is valid or not
    public static boolean isValidEmail(String email){
        //Create a variable to store the regular expression
        String  regex = "^[a-zA-Z0-9_.+-]+@[a-zA-z0-9-]+\\.[a-zA-z]{3,}$";

        //Create a reference  and call the compile method to compile the regular expression
        Pattern compileExpression = Pattern.compile(regex);

        //Create a reference of Matcher class and call the method
        Matcher matcher = compileExpression.matcher(email);

        //Call the method and return the result
        return matcher.matches();
    }

    //Create a static method isValidPassword to check PassWord is valid or not
    public static boolean isValidPassword(String password){
        //Create a variable to store the regular expression
        String  regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

        //Create a reference  and call the compile method to compile the regular expression
        Pattern compileExpression = Pattern.compile(regex);

        //Create a reference of Matcher class and call the method
        Matcher matcher = compileExpression.matcher(password);

        //Call the method and return the result
        return matcher.matches();
    }


    //Create a method to register User
    public static void registerUser(String username, String email, String password) throws IllegalAccessException {
        //Check the input is valid or not
        if(!(isValidEmail(email)) || !(isValidPassword(password)) || !(isValidUserName(username))){
            //Throw Exception
            throw new IllegalArgumentException("Invalid Input.");
        }

        //Print the statement
        System.out.println("User Registration Completed.");
    }
}

//Create class UserRegistration which extends Registration
public class UserRegistration extends Registration{
    public static void main(String[] args) {

        //Use try block
        try {
            //Call the method
            Registration.registerUser("anchal_sahu","sahu123@gmail.com","Abcd@123");
        }catch (IllegalAccessException e){//Catch block to handle exception
            //Print the message
            System.out.println(e.getMessage());
        }
    }
}

