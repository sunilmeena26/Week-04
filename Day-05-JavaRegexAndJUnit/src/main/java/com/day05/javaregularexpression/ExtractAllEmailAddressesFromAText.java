package com.day05.javaregularexpression;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Create a class ExtractAllEmail to extract the email address
class ExtractAllEmail{
    //Create a method extractEmailAddress to extract email address
    public static void extractEmailAddress(String text){
        //Create a variable to store the regular expression
        String  regex = "[a-zA-Z0-9_.+-]+@[a-zA-z0-9-]+\\.[a-zA-z]{3,}";

        //Create a reference  and call the compile method to compile the regular expression
        Pattern compileExpression = Pattern.compile(regex);

        //Create a reference of Matcher class and call the method
        Matcher matcher = compileExpression.matcher(text);

        //Use while to find the email address
        while (matcher.find()) {
            //Print the result
            System.out.println(matcher.group());
        }
    }
}

//Create a class ExtractAllEmailAddressesFromAText
public class ExtractAllEmailAddressesFromAText {
    public static void main(String[] args) {
        //Create an object of Scanner class
        Scanner input = new Scanner(System.in);

        //Create a variable and take input
        System.out.print("Enter the text: ");
        String text = input.nextLine();

        //Call the method and print the result
        ExtractAllEmail.extractEmailAddress(text);

        //Close the object
        input.close();
    }
}
