package com.day02.setinterface;

import java.util.*;
//Create a class SortedList to convert a HashSet of integers into a sorted list in ascending order
class SortedList{

    //Create a static method ConvertSetToSortedList to convert set to sorted list
    public static List<Integer> ConvertSetToSortedList(Set<Integer> s1){
        //Create an ArrayList to store value
        ArrayList<Integer> list = new ArrayList<>();
        //Use for loop
        for(int val: s1){
            list.add(val);
        }
        return list;
    }
}

//Create a class ConvertSetToSortedList to use SortedList class
public class ConvertSetToSortedList {
    public static void main(String[] args) {
        //Create a HashSet to store the element
        Set<Integer> hashSet = new HashSet<>();

        //Call the predefine method add to add element into the set
        hashSet.add(5);
        hashSet.add(3);
        hashSet.add(9);
        hashSet.add(1);
        hashSet.add(2);

        //print the hashSet
        System.out.println("HashSet: "+hashSet);

        //call the method and print the result
        System.out.println("Convert Sorted List: "+SortedList.ConvertSetToSortedList(hashSet));

    }
}
