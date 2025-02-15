package com.day05.javajunit;

//Create a class EvenNumber to check number is even or not
class EvenNumber{
    //Create a method to check if a number is even
    public static boolean isEven(int number) {
        if(number % 2 == 0)
            return true;
        return false;
    }
}

//Create class CheckEverNumber to use EvenNumber class
public class CheckEverNumber extends EvenNumber{
    public static void main(String[] args) {
        //call the method and print the result
        boolean result=EvenNumber.isEven(2);
        System.out.println("Number is even: "+result);
    }
}
