package com.day06.javaunittesting;

import com.day05.javajunit.ListOperations;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Create a class ListOperationsTesting to perform junit testing on ListOperations class
public class ListOperationsTesting {

    //Create a method testAddElement to perform testing addElement method
        @Test
        public void testAddElement() {
        List<Integer> list = new ArrayList<>();
        ListOperations.addElement(list,5);
        boolean result=list.contains(5);
        boolean expectedResult=true;
        assertEquals(expectedResult,result);
        }

    //Create a method testRemoveElement to perform testing removeElement method
        @Test
        public void testRemoveElement() {
            List<Integer> list = new ArrayList<>();
            ListOperations.addElement(list,5);
            ListOperations.removeElement(list,5);
            boolean result=list.contains(5);
            boolean expectedResult=false;
            assertEquals(expectedResult,result);
        }

    //Create a method testGetSize to perform testing getSize method
        @Test
        public void testGetSize() {
            List<Integer> list = new ArrayList<>();
            int result=ListOperations.getSize(list);
            int expectedResult=0;
            assertEquals(expectedResult,result);
       }
}
