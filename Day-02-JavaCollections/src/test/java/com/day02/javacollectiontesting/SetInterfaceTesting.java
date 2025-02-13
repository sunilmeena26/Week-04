package com.day02.javacollectiontesting;

import com.day02.setinterface.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

//Create a class SetInterfaceTesting to test a SetInterface package methods
public class SetInterfaceTesting {


    //Create a method testConvertSetToSortedList to test convertSetToSortedList method
    @Test
    public void testConvertSetToSortedList() {
        //Create a Set interface to point HashSet class and store element
        Set<Integer> hashSet=new HashSet<>(Arrays.asList(5, 3, 9, 1, 2));
        //Create a List interface store sorted list as a result
        List<Integer> actualList = ConvertSetToSortedList.ConvertSetToSortedList(hashSet);
        //Use Collection method to ensure list is sorted
        Collections.sort(actualList);
        //Create a List interface to store expected sorted elements
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 5, 9);
        //Compare both result actual and expected result
        assertEquals(expectedList, actualList);
    }


    //Create a method testCheckSubset to test checkSubset method
    @Test
    public void testCheckSubset() {
        //Create a Set interface to point HashSet class and store element
        Set<Integer> set1=new HashSet<>(Arrays.asList(2, 3));
        //Create a Set interface to point HashSet class and store element
        Set<Integer> set2= new HashSet<>(Arrays.asList(1, 2, 3, 4));
        //Create a Set interface to point HashSet class and store element
        Set<Integer> set3= new HashSet<>(Arrays.asList(5, 6));
        //Compare sets are subsets or not
        assertTrue(FindSubsets.checkSubset(set1, set2));
        assertFalse(FindSubsets.checkSubset(set1, set3));
    }
}
