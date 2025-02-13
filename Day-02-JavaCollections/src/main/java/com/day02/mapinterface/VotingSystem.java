package com.day02.mapinterface;


import java.util.*;

//Create a class Voting to add voter information
class Voting{
    //Create a HashMap to store the vote count
    Map<String, Integer> voteCounts = new HashMap<>();

    //Create a LinkedHashMap to maintain the order of votes
    Map<String, Integer> orderedVotes = new LinkedHashMap<>();

    //Create a TreeMap to store the sorted order votes
    Map<String, Integer> sortedVotes = new TreeMap<>(Comparator.comparingInt(voteCounts::get).reversed());


    //Create a method addVote to add voter
    public void addVote(String candidate) {
        //add element into map
        voteCounts.put(candidate, voteCounts.getOrDefault(candidate, 0) + 1);

        //call the put method
        orderedVotes.put(candidate, voteCounts.get(candidate));
    }

    //Create a method printVotesInOrder to display votes in order
    public void printVotesInOrder() {
        //Print the result
        System.out.printf("%-10s %s\n","Name","Votes");
        for (Map.Entry<String, Integer> entry : orderedVotes.entrySet()) {
            String candidate = entry.getKey();
            int votes = entry.getValue();
            System.out.printf("%-10s %d\n",candidate,votes);
        }
    }

    //Create a method printSortedVotes to display sorted votes
    public void printSortedVotes() {
        //call the putAll method
        sortedVotes.putAll(voteCounts);

        //Print the result
        System.out.printf("%-10s %s\n","Name","Votes");
        for (Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
            //Create a variable to store the candidate name
            String candidate = entry.getKey();
            //Create a variable
            int votes = entry.getValue();
            System.out.printf("%-10s %d\n",candidate,votes);
        }
    }
}

//Create a class VotingSystem ro use Voting class
public class VotingSystem {

    public static void main(String[] args) {

        //Create an object of Voting class
        Voting voter = new Voting();

        //Call the addVote method to add voter name
        voter.addVote("Manish");
        voter.addVote("Alok");
        voter.addVote("Pradeep");
        voter.addVote("Alok");
        voter.addVote("Manish");
        voter.addVote("Alok");

        //call the method printVotesInOrder to display the votes in order
        System.out.println("Votes in the order:");
        voter.printVotesInOrder();

        //call the method printSortedVotes to display sorted array and print the result
        System.out.println("\nResults Sorted by Votes:");
        voter.printSortedVotes();
    }
}
