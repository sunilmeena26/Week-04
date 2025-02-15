package com.day05.javaregularexpression;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Create a class CensorBadWord
class CensorBadWord{
    //Create a list to store teh bad words
    private static List<String> badWordList = List.of("damn","stupid","bloody","hell","idiot");

    //Create a static method to censorBadWordAndReplace to replace the bad word
    public static String censorBadWordAndReplace(String text){

        //Use for loop
        for (String val : badWordList){
            //Create a variable to store the regex
            String regex = "\\b"+val+"\\b";

            //Create a reference  and call the compile method to compile the regular expression
            Pattern compileExpression = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);

            //Create a reference of Matcher class and call the method
            Matcher matcher = compileExpression.matcher(text);

            //Call the replaceAll method
            text = matcher.replaceAll("****");
        }
        return text;
    }
}

//Create a class CensorBadWordsInSentence
public class CensorBadWordsInSentence {
    public static void main(String[] args) {
        //Create an object of Scanner class
        Scanner input = new Scanner(System.in);

        //Create a variable and take input
        System.out.print("Enter the sentence: ");
        String sentence = input.nextLine();

        //Create  a variable and Call the method
        String result = CensorBadWord.censorBadWordAndReplace(sentence);

        //print the result
        System.out.println(result);

        //Close the object
        input.close();
    }
}

