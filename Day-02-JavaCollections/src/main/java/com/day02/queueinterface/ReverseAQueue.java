package com.day02.queueinterface;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


//Create a class Reverse to reverse the queue element
class Reverse{
    //Create a static class reverseQueue to reverse the queue
     public static void reverseQueue(Queue<Integer> inputQueue){
         //Use stack for reverse queue element
         Stack<Integer> stack=new Stack<>();
         while(!(inputQueue.isEmpty())){
             stack.push(inputQueue.remove());
         }
         while(!(stack.isEmpty())){
             inputQueue.add(stack.pop());
         }
     }
}

//Create a class ReverseAQueue to use Reverse class
public class ReverseAQueue {
    public static void main(String[] args) {
        //Create an Queue with name queue to store integer element
        Queue<Integer> inputQueue=new LinkedList<>();
        inputQueue.add(10);
        inputQueue.add(20);
        inputQueue.add(30);

        //call the method reverseQueue to reverse the queue
        Reverse.reverseQueue(inputQueue);

        //use while loop to print reverse element of the queue
        System.out.print("Reverse element is : ");
       while(!(inputQueue.isEmpty())){
           System.out.print(inputQueue.remove()+" ");
       }
    }
}
