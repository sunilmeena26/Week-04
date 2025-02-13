package com.day02.mapinterface;

import java.util.HashMap;
import java.util.Map;

//Create a class KeyWithHighestValue to find key with the highest value
class KeyWithHighestValue{
    //Create a static method findKeyWithHighestValue to find key with the highest value
    public static String findKeyWithHighestValue(Map<String,Integer> map){
        //Create a variable maxKey ad highestValue to store maximum value with key
       String maxKey=null;
       int highestValue=Integer.MIN_VALUE;
       //Use for each loop to iterate map element
       for(Map.Entry<String,Integer>entry: map.entrySet()){
           if(entry.getValue()>highestValue){
               highestValue=entry.getValue();
               maxKey=entry.getKey();
           }
       }
       //return the max key
       return maxKey;
    }

}

//Create a class FindTheKeyWithHighestValue to use KeyWithHighestValue class
public class FindTheKeyWithHighestValue {
    public static void main(String[] args) {
        //Create a map interface
        Map<String,Integer> inputMAp=new HashMap<>();
        //put key and value in map
        inputMAp.put("A",10);
        inputMAp.put("B",20);
        inputMAp.put("C",15);
        //call the method invert findKeyWithHighestValue to find the key with highest value
        String maxKey=KeyWithHighestValue.findKeyWithHighestValue(inputMAp);
        //print the max key
        System.out.println("The Key with the maximum value "+maxKey);
    }
}
