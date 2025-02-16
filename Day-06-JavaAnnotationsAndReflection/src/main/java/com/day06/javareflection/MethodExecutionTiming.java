package com.day06.javareflection;


import java.lang.reflect.Method;

//Create a class SampleClass with methods to be timed
class SampleClass {

    //Create a methodOne to take 100 millis time
    public void methodOne() {
        // Simulate some work with sleep
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.getMessage();
        }
        System.out.println("Method One executed");
    }

    //Create a methodTwo to take 200 millis time
    public void methodTwo() {
        // Simulate some work with sleep
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method Two executed");
    }
}

//Create a class MethodTimer for timing method execution
class MethodTimer {

    //Create a static method timeMethodExecution to measure the execution time of a method
    public static void timeMethodExecution(Object obj, String methodName) {
        //Use try-catch block to handle the exception
        try {
            //Create Method class instance and call getMethod method of a class
            Method method = obj.getClass().getMethod(methodName);

            // Create a variable startTime to store time
            long startTime = System.nanoTime();

            // Invoke the method
            method.invoke(obj);

            // Create a variable endTime to end time
            long endTime = System.nanoTime();

            // Calculate the execution time in milliseconds
            long executionTime = (endTime - startTime) / 1_000_000;

            // Print the execution time
            System.out.println(methodName + " executed in " + executionTime + " ms");

        }
        //Use catch block to handle the exception
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//Create a class MethodExecutionTiming class to test the method timer execution
public class MethodExecutionTiming {
    public static void main(String[] args) {
        // Create an object of Sample class
        SampleClass sample = new SampleClass();

        // Calculate the execution time of methodOne
        MethodTimer.timeMethodExecution(sample, "methodOne");

        // Calculate the execution time of methodTwo
        MethodTimer.timeMethodExecution(sample, "methodTwo");
    }
}
