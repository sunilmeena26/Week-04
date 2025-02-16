package com.day06.javareflection;

import java.lang.reflect.Method;

// Create a class Calculator to perform multiplication
class Calculator {
    //Create a private method multiply to perfrom multiplication operation
    private int multiply(int a, int b) {
        return a * b;
    }
}


//Create a class InvokePrivateMethod to use Calculator class
public class InvokePrivateMethod {
    public static void main(String[] args) {
        //Use try-catch block to handle the exception
        try {
            // Create a Calculator class object
            Calculator calculator = new Calculator();

            // Create a Class reference to point calculator class object
            Class<?> calculatorClass = calculator.getClass();

            //Create a Method class reference multiplyMethod to get the private method 'multiply'
            Method multiplyMethod = calculatorClass.getDeclaredMethod("multiply",int.class,int.class);

            //Now, Set the method accessible
            multiplyMethod.setAccessible(true);

            // Invoke the private method with arguments
            int result = (int) multiplyMethod.invoke(calculator,5,3);

            // Display the result
            System.out.println("Result of multiplication: " + result);
        }
        //handle the exception using catch block
        catch (Exception e) {
            e.getMessage();
        }
    }
}
