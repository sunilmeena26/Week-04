package com.day05.javajunit;

//Create a class LongRunning to perform a longRunningTask task
class LongRunning {
    //Create a method that sleeps for 3 seconds before returning a result
    public static String longRunningTask() {
        try {
            // Sleep for 3 seconds
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Task Completed";

    }
}

//Create a class LongRunningTask to use LongRunning class
public class LongRunningTask extends LongRunning {
    public static void main(String[] args) {
        //call the method
        String result=LongRunning.longRunningTask();
        System.out.println(result);
    }
}
