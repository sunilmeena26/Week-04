package com.day06.javaunittesting;

import com.day05.javajunit.CheckEverNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Create a class EvenNumberParameterizedTesting to perform junit testing on EvenNumber class and perform Parameterized Tests
public class EvenNumberParameterizedTesting {


    //Create a class testIsEven to call the @ParameterizedTest method and perform junit testing
    @Test
    public void testIsEven() {
         boolean result=CheckEverNumber.isEven(2);
         boolean expectedResult=true;
         assertEquals(expectedResult,result);
    }
}
