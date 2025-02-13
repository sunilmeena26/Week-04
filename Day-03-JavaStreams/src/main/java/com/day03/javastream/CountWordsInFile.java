package com.day03.javastream;

import java.io.*;
import java.util.*;

//Create a class WordCount to count the word
class WordCounter {

    //Create a static method CountWordsInFile to  count the word
    public static Map<String, Integer> CountWordsInFile(String filePath) {
        //Create a HashMap wordCounts to store the value
        Map<String, Integer> wordCounts = new HashMap<>();

        try{
            //Create an object of BufferedReader class
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            //Create a variable to store the data
            String data;

            //Use while loop
            while ((data = bufferedReader.readLine()) != null) {
                //Create an array
                String[] words = data.split("\\s+");
                //USe for loop
                for (String word : words) {
                    word = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
                    if (!word.isEmpty()) {
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {//Catch block to handle exception
            System.out.println("Error: " + e.getMessage());
        }
        return wordCounts;
    }

    //Create a method  findTopWords
    public static List<String> findTopWords(Map<String, Integer> wordCounts, int topN) {
        //Create a priorityQueue
        PriorityQueue<String> queue = new PriorityQueue<>(
                (a, b) -> wordCounts.get(b).compareTo(wordCounts.get(a))
        );

        //Add all the element into queue
        queue.addAll(wordCounts.keySet());

        //Create a list to store the value
        List<String> topWords = new ArrayList<>();
        for (int i = 0; i < topN && !queue.isEmpty(); i++) {
            topWords.add(queue.poll());
        }
        return topWords;
    }
}

//Create class CountWordsInFile
public class CountWordsInFile {
    public static void main(String[] args) {
        //Create a variable to store file path
        String filePath = "C:\\Week-04\\Day-03-JavaStreams\\src\\main\\java\\com\\day03\\javastream\\sourcefile.txt";

        //Create a map to store the result
        Map<String, Integer> wordCounts = WordCounter.CountWordsInFile(filePath);

        //Create a list to store the result
        List<String> topWords = WordCounter.findTopWords(wordCounts, 5);

        //Print the result
        System.out.println("Top 5 Most Frequently Occurring Words:");
        for (String word : topWords) {
            System.out.println(word + ": " + wordCounts.get(word));
        }
    }
}
