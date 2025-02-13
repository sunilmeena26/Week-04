package com.day02.listinterface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Create a class Reverse to reverse the elements of a given List without using built-in reverse methods and implement it for both ArrayList and LinkedList 
class Reverse{
    //Create a static method to reverse the given list
    public static void reverseAList(List<Integer> list){
        //Create a variable to store the length
        int length = list.size();

        //Use for loop to reverse the list
        for(int i=0;i<length/2;i++){
            //Create a temp variable to store the value
            int temp = list.get(i);
            list.set(i,list.get(length-i-1));
            list.set(length-1-i,temp);
        }
    }
}

//Create a class ReverseAList to use the reverse list class
public class ReverseAList {
    public static void main(String[] args) {

        //Create a ArrayList to store the elements
        ArrayList<Integer> list = new ArrayList<>();

        //call add method to add element into the list
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        //Print the Arraylist
        System.out.println("Array List before reverse: "+list);
        //Call the method to reverse the given list
        Reverse.reverseAList(list);
        //Print the reverse list
        System.out.println("Array List after reverse:  "+list);

        //Create a LinkedList to store variable
        LinkedList<Integer> list1 = new LinkedList<>();
        //Call the method to add the element
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        //Print the LinkedList
        System.out.println("\nLinked List before reverse: "+list1);
        //Call the reverse method to reverse the given list
        Reverse.reverseAList(list1);
        //Print the reversed list
        System.out.println("Linked List after reverse:  "+list1);
    }
}
