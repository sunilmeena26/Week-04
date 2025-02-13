package com.day02.setinterface;

import java.util.*;
//Create a class CheckTwoSets to compare two sets and determine if they contain the same elements
class CheckTwoSets{
    //Create a static method to compare the two given sets
    public static boolean compareTwoSet(Set<Integer> s1,Set<Integer> s2){
        return s1.equals(s2);
    }
}

//Create a class CheckTwoSetsAreEqual to use CheckTwoSet class
public class CheckTwoSetsAreEqual {
    public static void main(String[] args) {
        //Create a HashSet to store the element
        Set<Integer> set1 = new HashSet<>();
        //Call the add predefine method to add element into the set
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        //Create another HashSet to store the element
        Set<Integer> set2 = new HashSet<>();
        //Call the add predefine method to add element into the set
        set2.add(4);
        set2.add(3);
        set2.add(2);
        set2.add(1);

        //Call the method and print the result
        System.out.println("Set1 and Set2 both are equal: "+CheckTwoSets.compareTwoSet(set1,set2));
    }
}
