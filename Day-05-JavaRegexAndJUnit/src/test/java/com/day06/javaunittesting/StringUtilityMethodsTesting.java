package com.day06.javaunittesting;
import com.day05.javajunit.StringUtilityMethods;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Create a class StringUtilityMethodsTesting to perform junit testing on StringUtilityMethods class
public class StringUtilityMethodsTesting {

        //Create a method testReverse to test reverse method
        @Test
        public void testReverse() {
            String reverseResult=StringUtilityMethods.reverse("mohit");
            String expectedResult="tihom";
            assertEquals(expectedResult,reverseResult);
        }


    //Create a method testIsPalindrome to test isPalindrome method
        @Test
        public void testIsPalindrome() {
            boolean palindromeResult=StringUtilityMethods.isPalindrome("kanak");
            boolean expectedResult=true;
            assertEquals(expectedResult,palindromeResult);
        }

    //Create a method testToUpperCase to test toUpperCase method
        @Test
        public void testToUpperCase() {
            String reverseResult=StringUtilityMethods.toUpperCase("mohit");
            String expectedResult="MOHIT";
            assertEquals(expectedResult,reverseResult);
        }
}
