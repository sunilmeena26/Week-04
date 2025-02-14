package com.day04.javaexception;

//Create a class InsufficientBalanceException to extends Exception class
class InsufficientBalanceException extends Exception{
    //Create a constructor to pass exception massage in super class
    public InsufficientBalanceException(String massage){
        super(massage);
    }
}

//Create a class BankSystem to perform some task like withdraw
class BankSystem{
    //Create a variable to balance
    private double balance;

    //Create a constructor to initialize balance
    public BankSystem(double balance) {
        this.balance = balance;
    }

    //Create a method withdraw to withdraw amount
    public void withdraw(double amount) throws InsufficientBalanceException{
        //Use if statement check balance is sufficient or not if balance is Insufficient throw the InsufficientBalanceException
        if(amount>balance){
           throw new InsufficientBalanceException("Insufficient balance!");
        }
        //Use if else statement check balance is negative or not if balance is negative throw the IllegalArgumentException
        else if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }else {
            //deduct amount in the balance
            balance =balance-amount;
            System.out.println("Withdrawal successful, new balance: "+balance);
        }
    }
    
    //Create method getBalance to return the balance
    public double getBalance() {
        return balance;
    }
}

//Create a class BankTransactionSystem to use BankSystem class and handle the exception
public class BankTransactionSystem {
    public static void main(String[] args) {
        //Create an object of BankSystem class and pass balance
        BankSystem bankSystem=new BankSystem(5000);

        //Use try-catch block to handle the exception
        try{
            //call the method withdraw to withdraw amount
            bankSystem.withdraw(200);
            bankSystem.withdraw(4900);
        }
        //handle the InsufficientBalanceException using catch block
        catch (InsufficientBalanceException ex){
            System.out.println(ex.getMessage());
        }
        //handle the IllegalArgumentException using catch block
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }


        //Use try-catch block to handle the exception
        try{
            //call the method withdraw to withdraw amount
            bankSystem.withdraw(-3000);
        }
        //handle the InsufficientBalanceException using catch block
        catch (InsufficientBalanceException ex){
            System.out.println(ex.getMessage());
        }
        //handle the IllegalArgumentException using catch block
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
