package com.day02.mapinterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

// Create a class WordFrequency to read a text file and count the frequency of each word using a HashMap
class WordFrequency{
    //Create a static method wordFrequencyCounter to count the frequency of the word in the file
    public static void wordFrequencyCounter(String filePath){
        //Use hashmap for storing every word frequency
        HashMap<String,Integer> wordFrequencyCount=new HashMap<>();
        BufferedReader reader=null;
        //Use try-catch block for handle exception
        try{
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            //Use while to read file text line-by-line
            while((line=reader.readLine())!=null){
                //Convert string line into lowercase than after word of array
                String[]words=line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");
                for(String word:words){
                    if(wordFrequencyCount.containsKey(word))
                        wordFrequencyCount.put(word,wordFrequencyCount.get(word)+1);
                    else
                        wordFrequencyCount.put(word,1);
                }
            }
            //Print the frequency of each word
            System.out.printf("%-17s %s","Words","Frequency");
            for(Map.Entry<String ,Integer> entry :wordFrequencyCount.entrySet()){
                System.out.printf("\n%-17s %d",entry.getKey(),entry.getValue());
            }
        //Handle the exception
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

//Create a class WordFrequencyCounter to use WordFrequency class
public class WordFrequencyCounter {
    public static void main(String[] args) {
        //Create a string variable to store path of the file
        String filePath="C:\\Week-04\\Day-02-JavaCollections\\src\\main\\java\\com\\day02\\mapinterface\\examplefile.txt";
        //call the method wordFrequencyCounter and print word frequency
        WordFrequency.wordFrequencyCounter(filePath);
    }
}
