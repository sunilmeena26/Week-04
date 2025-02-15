package com.day05.javaregularexpression;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Create a class ExtractLinksFromWeb to  extract links from the sentences
class ExtractLinksFromWeb{
    //Create a method extractLink to extract Link
    public static void extractLink(String text){
        //Create a variable to store the regular expression
        String  regex = "https?://(www\\\\.)?[a-zA-Z0-9.-]+";

        //Create a reference  and call the compile method to compile the regular expression
        Pattern compileExpression = Pattern.compile(regex);

        //Create a reference of Matcher class and call the method
        Matcher matcher = compileExpression.matcher(text);

        //Use while to find the Links
        while (matcher.find()) {
            //Print the result
            System.out.println(matcher.group());
        }
    }

}
//Create a class ExtractLinksFromWebPage
public class ExtractLinksFromWebPage {
    public static void main(String[] args) {
        //Create an object of Scanner class
        Scanner input = new Scanner(System.in);

        //Create a variable and take input
        System.out.print("Enter the text: ");
        String inputText = input.nextLine();

        //Call the method and print the result
        System.out.println("Links: ");
        ExtractLinksFromWeb.extractLink(inputText);

        //Close the object
        input.close();
    }
}

