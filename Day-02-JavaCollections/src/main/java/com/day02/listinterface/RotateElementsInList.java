package com.day02.listinterface;

import  java.util.*;
//Create a class RotateElement to rotate the elements of a list by a given number of positions
class RotateElement{
    //Create a static method rotateElementInList to rotate Element of given list
    public static List<Integer> rotateElementInList(List<Integer>list,int position){
        //Create a ArrayList to store the rotated list
        List<Integer> rotatedList = new ArrayList<>();

        //Use for Loop to rotate the element
        for(int i = position;i<list.size();i++){
            rotatedList.add(list.get(i));
        }
        for(int i=0;i<position;i++){
            rotatedList.add(list.get(i));
        }
        return rotatedList;
    }
}

//Create a class RotateElementsInList to use RotateElement class
public class RotateElementsInList {
    public static void main(String[] args) {
        //Create a List to store the element
        List<Integer> list = new ArrayList<>();

        //Call the add method to add element into the list
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);

        //Print the list
        System.out.println("List before rotation: "+list);
        //call the method rotateElementInList and print the result
        System.out.println("List after  rotation: "+RotateElement.rotateElementInList(list,2));
    }
}
