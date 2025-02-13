package com.day02.listinterface;

import java.util.*;

//Create a class NthElement find the Nth element from the end without calculating its size.
class NthElement{
    //Create a static method to find the nth element from the end
    public static Character getNthElementFromEnd(List<Character> list,int n){
        return list.get(list.size()-n);
    }
}

//Create a class FindNthElementFromEnd to use NthElement Class
public class FindNthElementFromEnd {
    public static void main(String[] args) {

        //Create a LinkedList to store the element
        LinkedList<Character> list = new LinkedList<>();

        //Call add method to add element
        list.add('A');
        list.add('B');
        list.add('C');
        list.add('D');
        list.add('E');
        list.add('F');

        //print the list
        System.out.println("List: "+list);

        //Create a variable to store the value
        int n = 2;

        //print the result
        System.out.println(n+" Element from end: "+NthElement.getNthElementFromEnd(list,n));
    }
}
