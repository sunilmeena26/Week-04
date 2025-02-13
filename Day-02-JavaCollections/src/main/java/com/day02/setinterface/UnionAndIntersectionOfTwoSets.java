package com.day02.setinterface;

import  java.util.*;
//Create a class UnionAndIntersection to find the union and intersection of sets
class UnionAndIntersection{
    //Create a static method getUnion to find the union of given set
    public static void getUnion(Set<Integer> s1,Set<Integer> s2){
        //Create a HashSet unionSet to store the union element
        Set<Integer> unionSet = new HashSet<>();

        //Use for loop to find union
        for(int val:s1){
            //Call the predefine method add to add element into set
            unionSet.add(val);
        }
        for(int val:s2){
            //Call the predefine method add to add element into set
            unionSet.add(val);
        }

        //print the result
        System.out.println("Union Element: "+unionSet);
    }

    //Create a static method getIntersection to find the Intersection of given set
    public static void getIntersection(Set<Integer> s1,Set<Integer> s2){

        //Create a HashSet unionSet to store the union element
        Set<Integer> intersectionSet = new HashSet<>();

        //Use for loop to find intersection
        for(int val: s1){
            if(s2.contains(val)){
                //Call the predefine method add to add element into set
                intersectionSet.add(val);
            }
        }

        for(int val: s2){
            if(s1.contains(val)){
                //Call the predefine method add to add element into set
                intersectionSet.add(val);
            }
        }

        //Print the result
        System.out.println("InterSection Element: "+intersectionSet);
    }

}
//Create a class UnionAndIntersectionOfTwoSets to use UnionAndIntersection class
public class UnionAndIntersectionOfTwoSets {
    public static void main(String[] args) {

        //Create a HashSet to store the element
        Set<Integer> set1 = new HashSet<>();

        //Call the predefine method add to add element into the set
        set1.add(1);
        set1.add(2);
        set1.add(3);

        //Create another HashSet to store the element
        Set<Integer> set2 = new HashSet<>();
        //Call the predefine method add to add element into the set
        set2.add(3);
        set2.add(4);
        set2.add(5);

        //Print the set
        System.out.println("Set1 is: "+set1+"\nSet2 is: "+set2);

        //Call the method and print the result
        UnionAndIntersection.getUnion(set1,set2);
        UnionAndIntersection.getIntersection(set1,set2);
    }

}

