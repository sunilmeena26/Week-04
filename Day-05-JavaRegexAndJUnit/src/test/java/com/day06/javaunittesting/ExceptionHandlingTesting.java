package com.day06.javaunittesting;

import com.day05.javajunit.ExceptionHandling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Create a class TestingExceptionHandling to perform junit testing ExceptionHandling class
public class ExceptionHandlingTesting {

    //Create a class testDivide() to test a divide method
    @Test
    public void testDivide() {
        int result=ExceptionHandling.divide(10,2);
        int expectedResult=5;
        assertEquals(expectedResult,result);
    }

    //Create a class testDivideByZero() to handle a exception and test the method
    @Test
    public void testDivideByZero() {
        try {
            int throwable = ExceptionHandling.divide(10, 0);
        }catch (ArithmeticException ex){
            assertEquals("Division by zero is not allowed.",ex.getMessage());
        }
    }
}
