package com.day02.mapinterface;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Create a class Invert to Invert a Map<K, V> to produce a Map<V, K>.
class Invert{
    //Create a static method invertAMap to invert the map data
    public static <K,V> void invertAMap(Map<K,V> inputMap){
        //Use map for store invert data
        Map<V,List<K>> invertMap=new HashMap<>();

        for(Map.Entry<K,V>entry:inputMap.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();
            if (invertMap.containsKey(value)) {
                invertMap.get(value).add(key);
            } else {
                List<K> list = new ArrayList<>();
                list.add(key);
                invertMap.put(value, list);
            }
        }
        //Use for loop to print the invert map data
       for(Map.Entry<V,List<K>> entry : invertMap.entrySet()){
         System.out.println(entry.getKey()+" = "+entry.getValue());
       }
    }
}

//Create a class InvertAMap to use Invert class
public class InvertAMap {
    public static void main(String[] args) {
        //Create a map interface
        Map<String,Integer> inputMAp=new HashMap<>();
        //put key and value in map
        inputMAp.put("A",1);
        inputMAp.put("B",2);
        inputMAp.put("C",1);
        //call the method invert map to invert the map and print the result
        Invert.invertAMap(inputMAp);
    }
}
