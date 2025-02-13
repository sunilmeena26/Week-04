package com.day02.javacollectiontesting;

import com.day02.listinterface.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ListInterfaceTesting {

    @Test
    public void removeDuplicateElementTest(){

        //Create a list and set to store the actual and expected result
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 2, 2, 4));
        Set<Integer> expected = new LinkedHashSet<>(Arrays.asList(3, 1, 2, 4));

        // Call the method to remove duplicates
        Set<Integer> result = RemoveDuplicatesWhilePreservingOrder.removeDuplicateElement(list);

        //call the assertEquals
        assertEquals(expected, result);

    }



    @Test
    //Create a Test method to check if the list is reversed correctly for LinkedList
    public void reverseListTest() {
        //Create actualList
        List<Integer> actualList = new LinkedList<>();
        actualList.add(1);
        actualList.add(2);
        actualList.add(3);
        actualList.add(4);
        actualList.add(5);

        // Reverse the list
        ReverseAList.reverseAList(actualList);

        //Create expectedList
        List<Integer> expectedList = new LinkedList<>();
        expectedList.add(5);
        expectedList.add(4);
        expectedList.add(3);
        expectedList.add(2);
        expectedList.add(1);

        // Verify the reversed list
        assertEquals(expectedList,actualList );
    }
}
