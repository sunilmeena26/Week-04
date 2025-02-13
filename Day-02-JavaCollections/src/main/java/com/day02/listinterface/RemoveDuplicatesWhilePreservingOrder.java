package com.day02.listinterface;

import java.util.*;
//Create a class RemoveDuplicate to remove duplicate elements from a list while maintaining the original order of elements.
class RemoveDuplicate{
    //Create a method removeDuplicateElement to remove the duplicate element in the list
    public static Set<Integer> removeDuplicateElement(List<Integer>list){
        //Create a LinkedHashSet to store the unique Element in preserving order
        Set<Integer> uniqueElement  = new LinkedHashSet<>();

        //Use for each loop to iterate the list
        for (Integer integer : list) {
            //Call the add method to add the element into the set
            uniqueElement.add(integer);
        }
        //return unique element sets
        return uniqueElement;
    }
}

//Create a class RemoveDuplicatesWhilePreservingOrder to use RemoveDuplicate class
public class RemoveDuplicatesWhilePreservingOrder {
    public static void main(String[] args) {

        //Create a list to store the element
        List<Integer> list = new ArrayList<>();

        //Call the add method to add element into the list
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);

        //Print the original List
        System.out.println("Original List: "+list);

        //Call the method and print the list after removing duplicate element
        System.out.println("After removing duplicate "+RemoveDuplicate.removeDuplicateElement(list));
    }
}
