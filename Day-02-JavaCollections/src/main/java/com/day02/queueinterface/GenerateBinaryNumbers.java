package com.day02.queueinterface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Create a class BinaryNumber to generate the first N number of binary number
class BinaryNumber{
    //Create a static method generateBinaryNumbers to generate the first N number of binary number
    public static void generateBinaryNumbers(int N){
        //Create a queue interface to store binary numbers
        Queue<String>queue=new LinkedList<>();
        queue.add("1");
        //Use for loop
        for(int i=0;i<N;i++){
            String current=queue.poll();
            System.out.println(current+" ");
            queue.add(current+"0");
            queue.add(current+"1");
        }
    }

}

//Create a class GenerateBinaryNumbers to use BinaryNumber class
public class GenerateBinaryNumbers {
    public static void main(String[] args) {
        //Create an object of scanner class to take user input
        Scanner input=new Scanner(System.in);
        //take user input
        int N=input.nextInt();
        //call the method generateBinaryNumbers
        BinaryNumber.generateBinaryNumbers(N);
    }
}
