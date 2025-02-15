package com.day05.javaregularexpression;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Create a class ExtractProgramming
class ExtractProgramming{
    //Create a list to store languages
    private static List<String> languages = List.of("C","C++","Java","Python","Go","JavaScript","CSS");

    //Create a static method to extractProgramingLanguage
    public static void extractProgramingLanguage(String text){

        //Use for loop
        for (String val : languages){
            //Create a variable to store the regex
            String regex = "\\b"+val+"\\b";

            //Create a reference  and call the compile method to compile the regular expression
            Pattern compileExpression = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);

            //Create a reference of Matcher class and call the method
            Matcher matcher = compileExpression.matcher(text);

            //Use while loop to find the languages
            while (matcher.find()){
                //Print the result
                System.out.println(matcher.group());
            }
        }
    }
}

//Create a class ExtractProgrammingLanguageNamesFromText
public class ExtractProgrammingLanguageNamesFromText {
    public static void main(String[] args) {
        //Create an object of Scanner class
        Scanner input = new Scanner(System.in);

        //Create a variable and take input
        System.out.print("Enter the sentence: ");
        String sentence = input.nextLine();

        //Create  a variable and Call the method
        ExtractProgramming.extractProgramingLanguage(sentence);

        //Close the object
        input.close();
    }
}