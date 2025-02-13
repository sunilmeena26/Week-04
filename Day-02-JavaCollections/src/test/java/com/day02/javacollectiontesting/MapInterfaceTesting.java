package com.day02.javacollectiontesting;

import com.day02.mapinterface.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

//Create a class MapInterfaceTesting to perform junit testing on map interface package method
public class MapInterfaceTesting {

    @Test
    //Create a method findKeyWithHighestValueTest to perform junit testing on KeyWithHighestValueTest method
    public void findKeyWithHighestValueTest() {
        //Create a HashMap to store element
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        //call the method and store the actual result
        String result = FindTheKeyWithHighestValue.findKeyWithHighestValue(map);

        //call the assert method
        assertEquals("B", result);
    }

    @Test
    //Create a method invertMapTest to perform testing on invertMap method
    public void invertMapTest() {
        // Create a map
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 1);

        //create a map expectedOutput
        Map<Integer, List<String>> expectedOutput = new HashMap<>();
        expectedOutput.put(1, Arrays.asList("A", "C"));
        expectedOutput.put(2, Arrays.asList("B"));

        //Create a map actualOutput
        Map<Integer, List<String>> actualOutput =  InvertAMap.invertAMap(inputMap);

        // call the assert method
        assertEquals(expectedOutput, actualOutput);
    }

}
