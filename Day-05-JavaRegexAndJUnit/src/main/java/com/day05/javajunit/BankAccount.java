package com.day05.javajunit;

//Create a class Bank to store bank details
class Bank{
    //Create a variable to store balance
    private double balance;

    //Create a constructor to initialize balance
    public Bank(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.balance = initialBalance;
    }

    //Create  a method deposit to deposit amount
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative.");
        }
        balance += amount;
    }

    //Create a method withdraw to withdraw amount
    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdrawal amount cannot be negative.");
        }
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient funds for withdrawal.");
        }
        balance -= amount;
    }

    //Create a method getBalance to return the balance
    public double getBalance() {
        return balance;
    }
}

//Create a class to use Bank
public class BankAccount extends Bank{
    public BankAccount(double initialBalance) {
        super(initialBalance);
    }

    public static void main(String[] args) {
        //Create an object of Bank class
        Bank bank=new Bank(2000);
        //print the balance
        System.out.println("Balance is: "+bank.getBalance());
        //withdraw and deposit the balance
        bank.deposit(200);
        bank.withdraw(400);

        //print the balance
        System.out.println("After Withdraw balance is: "+bank.getBalance());
    }
}
