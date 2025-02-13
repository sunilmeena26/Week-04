package com.day02.mapinterface;

import java.util.*;

//Create a class BankSystem to manage ka bank system
class BankSystem {
    //Create a map to storing the account balances.
    private Map<Integer, Double> accounts = new HashMap<>();

    // Create a TreeMap to sorting the accounts by balance.
    private TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();

    //Create a Queue for withdrawal requests
    private Queue<Integer> withdrawalQueue = new LinkedList<>();

    // Create a method createAccount for creating an account.
    public void createAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    //Create a method requestWithdrawal for request the withdrawal.
    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    //Create a method processWithdrawals for process withdrawals.
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for account: " + accountNumber);
        }
    }

    //Create a method displayAccountsSorted for displaying accounts sorted by balance.
    public void displayAccountsSorted() {
        System.out.println("Accounts sorted by balance:");

        // Displaying the accounts sorted by balance.
        for (var entry : sortedAccounts.entrySet()) {
            System.out.println("Account: " + entry.getValue() + " = " + entry.getKey());
        }
    }
}

// Create a class ImplementABankingSystem to use BookSystem class
public class ImplementABankingSystem {
    public static void main(String[] args) {
        // Create an object of BookSystem class
        BankSystem BankSystem = new BankSystem();
        // Call the method creatingAccount to create an account with 5000 balance
        BankSystem.createAccount(101, 5000);
        // Call the method creatingAccount to create an account with 2000 balance
        BankSystem.createAccount(102, 2000);
        // Call the method creatingAccount to create an account with 7000 balance
        BankSystem.createAccount(103, 7000);
        // Call the method requestWithdrawal to requesting withdrawal for account 102
        BankSystem.requestWithdrawal(102);
        // Call the method processWithdrawals to processing all withdrawal requests
        BankSystem.processWithdrawals();
        //call the method displayAccountsSorted to display accounts sorted by balance
        BankSystem.displayAccountsSorted();
    }
}
