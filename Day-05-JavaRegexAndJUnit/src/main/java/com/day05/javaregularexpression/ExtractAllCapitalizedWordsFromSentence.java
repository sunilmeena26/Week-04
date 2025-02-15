package com.day05.javaregularexpression;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Create a class ExtractCapitalizeWord to extract words in the sentences
class ExtractCapitalizeWord{
    //Create a method extractCapitalizeWord to extract Capitalize word
    public static void extractCapitalizeWord(String text){
        //Create a variable to store the regular expression
        String  regex = "[A-Z][a-z0-9]+";

        //Create a reference  and call the compile method to compile the regular expression
        Pattern compileExpression = Pattern.compile(regex);

        //Create a reference of Matcher class and call the method
        Matcher matcher = compileExpression.matcher(text);

        //Use while to find the Capitalize word
        while (matcher.find()) {
            //Print the result
            System.out.print(matcher.group()+" ");
        }
    }
}

//Create a class ExtractAllCapitalizedWordsFromSentence
public class ExtractAllCapitalizedWordsFromSentence {
    public static void main(String[] args) {
        //Create an object of Scanner class
        Scanner input = new Scanner(System.in);

        //Create a variable and take input
        System.out.print("Enter the sentence: ");
        String sentence = input.nextLine();

        //Call the method and print the result
        System.out.println("Capitalize word in sentence:");
        ExtractCapitalizeWord.extractCapitalizeWord(sentence);

        //Close the object
        input.close();
    }
}
