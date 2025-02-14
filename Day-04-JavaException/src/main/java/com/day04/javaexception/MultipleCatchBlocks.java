package com.day04.javaexception;

import java.util.InputMismatchException;
import java.util.Scanner;

//Create a class MultipleCatch to create multiple catch block and handle the multiple exception
class MultipleCatch{
    //Create a static method arrayOperations to perform some operations on array and handle the exception
    public static void arrayOperations(int[] numbers){
        //Use try-catch block to handle the exception
        try{
            //Create a scanner class object for take user input
            Scanner input=new Scanner(System.in);

            //Create a variable to store the length of the array
            int lengthOfArray=numbers.length;

            //Create a variable indexNumber to store index number of the array
            System.out.println("Enter a index number of array: ");
            int indexNumber=input.nextInt();

            //print the element of the array
            System.out.println("Value at index "+indexNumber+": "+numbers[indexNumber]);

            //close the scanner
            input.close();
        }
        //Handle the ArrayIndexOutOfBoundsException exception
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Invalid index! "+ex.getMessage());
        }
        //Handle the NullPointerException exception when array is null
        catch (NullPointerException ex){
            System.out.println("Array is not initialized! "+ex.getMessage());
        }
    }
}

//Create a class MultipleCatchBlocks to use MultipleCatch class
public class MultipleCatchBlocks {
    public static void main(String[] args) {
        //create an integer number1 and number2 array
        int []numbers1={1,2,3};
        int []numbers2=null;

        //call the method arrayOperations for performing operation on array
        MultipleCatch.arrayOperations(numbers1);
        MultipleCatch.arrayOperations(numbers2);
    }
}
