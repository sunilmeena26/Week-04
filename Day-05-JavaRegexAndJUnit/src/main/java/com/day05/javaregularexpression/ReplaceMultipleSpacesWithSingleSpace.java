package com.day05.javaregularexpression;


import java.util.*;

//Create a class ReplaceSpace to replace space
class ReplaceSpace{
    //Create a method replaceMultipleSpaces to replace Multiple spaces with single spaces
    public static String replaceMultipleSpaces(String text){
        //Create a variable to store the regular expression
        String  regex = "\\s+";

        //return the replaced text
        return text.replaceAll(regex," ");
    }
}

//Create a class ReplaceMultipleSpacesWithSingleSpace
public class ReplaceMultipleSpacesWithSingleSpace {
    public static void main(String[] args) {
        //Create an object of Scanner class
        Scanner input = new Scanner(System.in);

        //Create a variable and take input
        System.out.print("Enter the sentence: ");
        String sentence = input.nextLine();

        //Create  a variable and Call the method
        String result = ReplaceSpace.replaceMultipleSpaces(sentence);

        //print the result
        System.out.println(result);

        //Close the object
        input.close();
    }
}
