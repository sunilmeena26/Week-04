package com.day05.javaregularexpression;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Create a class RepeatingWord to repeating word
class RepeatingWord{
    //Create a method findRepeatingWordsInSentence to FInd the repeating word
    public static void findRepeatingWordsInSentence(String text){
        //Create a variable to store the regular expression
        String  regex = "\\b([a-zA-Z0-9]+)\\b\\s+\\1\\b";

        //Create a reference  and call the compile method to compile the regular expression
        Pattern compileExpression = Pattern.compile(regex);

        //Create a reference of Matcher class and call the method
        Matcher matcher = compileExpression.matcher(text);

        //Use while to find the Repeated word
        while (matcher.find()) {
            //Print the result
            System.out.println(matcher.group(1));
        }
    }
}

//Create a class FindRepeatingWordsInSentence
public class FindRepeatingWordsInSentence{
    public static void main(String[] args) {
        //Create an object of Scanner class
        Scanner input = new Scanner(System.in);

        //Create a variable and take input
        System.out.print("Enter the text: ");
        String text = input.nextLine();

        //Call the method and print the result
        RepeatingWord.findRepeatingWordsInSentence(text);

        //Close the object
        input.close();
    }
}
