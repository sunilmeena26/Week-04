package com.day05.javaregularexpression;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Create a class HexColorCodeValidation to check the hex code is valid or not
class HexColorCodeValidation{
    //Create a static method isValidHexCode to check Hex Color COder is valid or not
    public static boolean isValidHexColorCode(String hexColorCode){
        //Create a variable to store the regular expression
        String  regex = "^#[a-fA-F0-9]{6}$";

        //Create a reference  and call the compile method to compile the regular expression
        Pattern compileExpression = Pattern.compile(regex);

        //Create a reference of Matcher class and call the method
        Matcher matcher = compileExpression.matcher(hexColorCode);

        //Call the method and return the result
        return matcher.matches();
    }
}

//Create a class ValidateAHexColorCode
public class ValidateAHexColorCode {
    public static void main(String[] args) {
        //Create an object of Scanner class
        Scanner input = new Scanner(System.in);

        //Create a variable and take input
        System.out.print("Enter Hex Color Code: ");
        String hexColorCode = input.nextLine();

        //Create a variable and call the method
        boolean isValid = HexColorCodeValidation.isValidHexColorCode(hexColorCode);

        //Print the result
        if(isValid){
            System.out.println("Hex Color Code is Valid Code.");
        } else {
            System.out.println("Hex Color Code is Invalid Code.");
        }

        //Close the object
        input.close();
    }
}
