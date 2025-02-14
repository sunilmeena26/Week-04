package com.day04.javaexception;

//Create a class Comparison to compare throw and throws keyword
class Comparison{
    //Create a static method calculateInterest to calculate the interest rate
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        //check amount and rate are positive
        if (amount<0||rate<0) {
             //If amount and rate are negative so generate the exception IllegalArgumentException
            throw new IllegalArgumentException ("Invalid input: Amount and rate must be positive");
        }
        //calculate the interest rate by using formula
        double interest=amount*rate*years/100;

        //return the calculate interest
        return interest;
    }
}

//Create a class ThrowVsThrows to use Comparison class
public class ThrowVsThrows {
    public static void main(String[] args) {
        //use try-catch block to handle the exception
        try{
            //Create a variable to store the calculated interest
            double interest;

            //call the method calculateInterest
            interest=Comparison.calculateInterest(5000,10,3);
            System.out.println("Calculated Interest is: "+interest);

            //call the method calculateInterest
            interest=Comparison.calculateInterest(-5000,10,3);
            System.out.println("Calculated Interest is: "+interest);
        }

        //handle the IllegalArgumentException exception
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
