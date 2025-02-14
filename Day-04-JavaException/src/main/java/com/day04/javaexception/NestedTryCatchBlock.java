package com.day04.javaexception;

import java.util.Scanner;

//Create a class NestedTryCatch to use nested try catch block to handle the exception
class NestedTryCatch{
    //Create a static method arrayOperations to perform operations on array and handle the exception using nested try-catch block
    public static void arrayOperations(int[] numbersArray,int index,int divisor){
        //Use try-catch block to handle the exception
        try {
            int element=numbersArray[index];
            //Use Nested try-catch to handle the exception
            try {
              int result=element/divisor;
              System.out.println("Division Result is: "+result);
            }
            //Handle the ArithmeticException exception when divisor is zero
            catch (ArithmeticException ex) {
                System.out.println("Cannot divide by zero! " + ex.getMessage());
            }
        }
        //Handle the ArrayIndexOutOfBoundsException exception
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Invalid array index! "+ex.getMessage());
        }
    }
}

//Create a class NestedTryCatchBlock to use NestedTryCatch class
public class NestedTryCatchBlock {
    public static void main(String[] args) {
        //Create a scanner class object for take user input
        Scanner input=new Scanner(System.in);

        //Create a variable lengthOfArray to store the length of the array
        System.out.print("Enter Length of Array: ");
        int lengthOfArray=input.nextInt();

        //create an integer array numbersArray to store number element
        int []numbersArray=new int[lengthOfArray];

        //Use for loop to take user input
        System.out.println("Enter "+lengthOfArray+" Element: ");
        for(int i=0;i<lengthOfArray;i++){
            System.out.print("Enter "+(i+1)+" Element: ");
            numbersArray[i]=input.nextInt();
        }

        //Create a variable index to take index number of element
        System.out.print("Enter a index no of array: ");
        int index=input.nextInt();

        //Create a variable divisor to take index number of element
        System.out.print("Enter a divisor: ");
        int divisor=input.nextInt();

        //call the method arrayOperations for performing operation on array
        NestedTryCatch.arrayOperations(numbersArray,index,divisor);
    }
}