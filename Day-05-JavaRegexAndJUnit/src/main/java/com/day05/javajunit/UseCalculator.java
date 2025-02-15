package com.day05.javajunit;

//Create a Calculator to calculator method
class Calculator{

    //Create a method add to add two number
        public int add(int a, int b) {
            return a + b;
        }

    //Create a method subtract to subtract two number
        public int subtract(int a, int b) {
            return a - b;
        }

    //Create a method multiply to multiply two number
        public int multiply(int a, int b) {
            return a * b;
        }

    //Create a method divide to divide two number
        public int divide(int a, int b) {
            if (b == 0) {
                throw new IllegalArgumentException("Division by zero is not allowed.");
            }
            return a / b;
        }
    }

//Create a class UseCalculator to use  Calculator
public class UseCalculator extends Calculator {
    public static void main(String[] args) {
        //Create an object of Calculator
        Calculator calculator=new Calculator();

        //call the method
        int sumOfTwoNumber=calculator.add(5,58);
        System.out.println("Sum Of Two Number: "+sumOfTwoNumber);

        //call the method
        int subtractionOfTwoNumber=calculator.subtract(9,9);
        System.out.println("Sum Of Two Number: "+subtractionOfTwoNumber);

        //call the method
        int multiplyOfTwoNumber=calculator.multiply(5,5);
        System.out.println("Sum Of Two Number: "+multiplyOfTwoNumber);

        //call the method
        int divideOfTwoNumber=calculator.divide(10,2);
        System.out.println("Sum Of Two Number: "+divideOfTwoNumber);
    }
}
