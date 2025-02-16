package com.day06.javareflection;

import java.lang.reflect.Method;
import java.util.Scanner;

// Create a class MathOperations to perform math operation on two number
class MathOperations {
    //Create a public method add to add two numbers
    public int add(int a, int b) {
        return a + b;
    }

    //Create a public subtract to subtract two numbers
    public int subtract(int a, int b) {
        return a - b;
    }

    //Create a public multiply to multiply two numbers
    public int multiply(int a, int b) {
        return a * b;
    }
}


//Create a class DynamicMethodInvocation to use MathOperations class
public class DynamicMethodInvocation {
    public static void main(String[] args) {
        //Use try-catch block to handle the exception
        try (Scanner scanner = new Scanner(System.in)) {
            // Create an object MathOperations class
            MathOperations mathOperations = new MathOperations();

            // Create a Class reference to point MathOperations class object
            Class<?> mathOperationsClass = mathOperations.getClass();

            //Create a variable methodName to read method name from user input
            System.out.print("Enter the method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();

            // Read arguments from user input
            System.out.print("Enter the first number: ");
            int firstNumber = scanner.nextInt();
            System.out.print("Enter the second number: ");
            int secondNumber = scanner.nextInt();

            //Create Method class reference to get the method based on the method name
            Method method = mathOperationsClass.getMethod(methodName, int.class, int.class);

            // Create a variable result to invoke the method with arguments and get the result
            int result = (int) method.invoke(mathOperations, firstNumber, secondNumber);

            // Display the result
            System.out.println("Result: " + result);

            //handle the exception using catch block
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
