package com.day05.javaregularexpression;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Create a class CurrencyExtract to extract the currencyValue
class CurrencyExtract{
    //Create a method extractCurrencyValue to extract currency value
    public static void extractCurrencyValue(String text){
        //Create a variable to store the regular expression
        String  regex = "\\$?[0-9]+\\.[0-9]{2}";

        //Create a reference  and call the compile method to compile the regular expression
        Pattern compileExpression = Pattern.compile(regex);

        //Create a reference of Matcher class and call the method
        Matcher matcher = compileExpression.matcher(text);

        //Use while to find Currency value
        while (matcher.find()) {
            //Print the result
            System.out.println(matcher.group());
        }
    }
}

//Create a class ExtractCurrencyValuesFromText
public class ExtractCurrencyValuesFromText {
    public static void main(String[] args) {
        //Create an object of Scanner class
        Scanner input = new Scanner(System.in);

        //Create a variable and take input
        System.out.print("Enter the text: ");
        String text = input.nextLine();

        //Call the method and print the result
        CurrencyExtract.extractCurrencyValue(text);

        //Close the object
        input.close();
    }
}
