package com.day05.javaregularexpression;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Create a class ValidateACreditCard to check the Credit card number is valid or not
class ValidateACreditCard{

    //Create a static method isValidCreditCardNumber to check the Credit card number is valid or not
    public static boolean isValidCreditCardNumber(String creditCardNumber){
        //Create a variable to store the regular expression
        String  regex = "[4-5][0-9]{15}";

        //Create a reference  and call the compile method to compile the regular expression
        Pattern compileExpression = Pattern.compile(regex);

        //Create a reference of Matcher class and call the method
        Matcher matcher = compileExpression.matcher(creditCardNumber);

        //Call the method and return the result
        return matcher.matches();
    }
}

//Create a class ValidateACreditCardNumber
public class ValidateACreditCardNumber {
    public static void main(String[] args) {
        //Create an object of Scanner class
        Scanner input = new Scanner(System.in);

        //Create a variable and take input
        System.out.print("Enter Credit Card Number: ");
        String creditCardNumber = input.nextLine();

        //Create a variable and call the method
        boolean isValid = ValidateACreditCard.isValidCreditCardNumber(creditCardNumber);

        //Print the result
        if(isValid){
            System.out.println("Valid Credit Card Number.");
        } else {
            System.out.println("Invalid Credit Card Number.");
        }

        //Close the object
        input.close();
    }
}
