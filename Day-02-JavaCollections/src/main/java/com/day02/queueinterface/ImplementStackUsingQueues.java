package com.day02.queueinterface;

import java.util.LinkedList;
import java.util.Queue;

//Create a class StackUsingQueues to implement a stack data structure using two queues and support push, pop, and top operations
class StackUsingQueues{
    //Create a two queue for performing stack operation
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    //Create a constructor to initialize queue
    public StackUsingQueues() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    //Create a method push to push element in the queue
    public void push(int data){
        queue2.add(data);
        while(!queue1.isEmpty()){
            queue2.add(queue1.poll());
        }
        Queue<Integer> temp=queue1;
        queue1=queue2;
        queue2=temp;
    }

    //Create a method pop to pop element in queue
    public int pop(){
        if(queue1.isEmpty())
            throw new IllegalArgumentException("Stack is empty!");
        return queue1.poll();
    }

    //Create a method top to give peek element in the queue
    public int top(){
        if(queue1.isEmpty())
            throw new IllegalArgumentException("Stack is Empty!");
        return queue1.peek();
    }

    //Create a method displayStack to display the queue
    public void displayStack(){
        System.out.println(queue1);
    }
}
public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        //create an object of StackUsingQueues
        StackUsingQueues stack=new StackUsingQueues();
        //add element in stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        //display the stack
        stack.displayStack();
        System.out.println("Top element is: "+stack.top());
        System.out.println("Popped Element is: "+stack.pop());
        //display the stack after pop element
        stack.displayStack();
    }
}
