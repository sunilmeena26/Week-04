package com.day06.javaunittesting;

import com.day05.javajunit.DateFormatter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Create a class DateFormatterTesting to test the date format
public class DateFormatterTesting {

    @Test
        //Create a method to perform test
    void formatDateTest(){
        //Create a variable to store value
        String date = "2025-02-15";

        //Compare the actual and expected result
        assertEquals("15-02-2025", DateFormatter.formatDate(date));

        //Compare the actual and expected result
        assertEquals("25-02-2025", DateFormatter.formatDate("2025-02-25"));
    }
}

