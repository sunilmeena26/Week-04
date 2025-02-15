package com.day05.javajunit;

import java.util.ArrayList;
import java.util.List;

//Create a class OperationsOnList to perform operation on list
class OperationsOnList {

    //Create a static method to add an element to a list
    public static void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    // Create a static method to remove an element from a list
    public static void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
    }

    // Create a static method to get the size of the list
    public static int getSize(List<Integer> list) {
        return list.size();
    }
}
public class ListOperations extends OperationsOnList {
    public static void main(String[] args) {
        //Create a list to store element
        List<Integer> list=new ArrayList<>();

        //perform operation on list
        OperationsOnList.addElement(list,10);
        OperationsOnList.addElement(list,20);
        OperationsOnList.addElement(list,40);
        int size=OperationsOnList.getSize(list);
        System.out.println("Size of list: "+size);

        //print the list
        System.out.println("List is: "+list);
        OperationsOnList.removeElement(list,20);

        //print the list
        System.out.println("After Delete Element Lsit is: "+list);
    }
}
