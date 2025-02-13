package com.day02.setinterface;

import java.util.HashSet;
import java.util.Set;

//Create a class Subset to check if one set is a subset of another
class Subset{

    //Create a method checkSubset to check that one set is subset or not
    public static boolean checkSubset(Set<Integer> s1,Set<Integer> s2){
        //return boolean result
        return (s1.containsAll(s2) || s2.containsAll(s1));
    }
}

//Create a class FindSubsets to use Subsets class
public class FindSubsets {
    public static void main(String[] args) {
        //Create a HashSet to store the element
        Set<Integer> set1 = new HashSet<>();

        //Call the predefine method add to add element into the set
        set1.add(2);
        set1.add(3);

        //Create another HashSet to store the element
        Set<Integer> set2 = new HashSet<>();
        //Call the predefine method add to add element into the set
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        //Print the set
        System.out.println("Set1 is: "+set1+"\nSet2 is: "+set2);

        //call the method and Print the result
        System.out.println("Set1 is Subset of Set2: "+Subset.checkSubset(set1,set2));
    }
}
