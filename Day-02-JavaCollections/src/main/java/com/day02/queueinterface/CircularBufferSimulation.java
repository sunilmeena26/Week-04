package com.day02.queueinterface;

import java.util.*;

//Create a generic class CircularBuffer
class CircularBuffer<T>{
    //Create a variable bufferSize to store the buffer size of buffer
    private int bufferSize;

    //Create a parameterized constructor to initialize buffer size
    public CircularBuffer(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    //Create a ArrayDeque to store the element
    ArrayDeque<T> circularBuffer= new ArrayDeque<>(bufferSize);

    //Create a method to addElement to add element into ArrayDeque
    public void addElement(T data){
        //Check the condition
        if(circularBuffer.size()==bufferSize){
            //remove an element from queue
            circularBuffer.remove();
        }
        //call the add method
        circularBuffer.add(data);
    }
}

//Create a class CircularBufferSimulation to use CircularBuffer
public class CircularBufferSimulation {

    public static void main(String[] args) {
        //Create a variable bufferSize to store the bufferSize
        int bufferSize = 3;

        //Create an object of CircularBuffer class
        CircularBuffer<Integer> circularBufferQueue = new CircularBuffer<>(bufferSize);

        //Call the add Element method to add the value
        circularBufferQueue.addElement(1);
        circularBufferQueue.addElement(2);
        circularBufferQueue.addElement(3);

        //Print the CircularBuffer queue
        System.out.println("Circular Buffer: "+circularBufferQueue.circularBuffer);

        //Call the addElement method to add element in dequeue
        circularBufferQueue.addElement(4);

        //print the result
        System.out.println("Circular Buffer: "+circularBufferQueue.circularBuffer);
    }
}

