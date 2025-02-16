package com.day06.javaannotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;

//Create an Annotation LogExecutionTime
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
    String message() default "Method executed in: ";
}

//Create a class Task
class Task {
    //Use LogExecutionTime Annotation
    @LogExecutionTime
    //Create a method processData()
    public void processData() {
        int process =0;
        for (int i = 0; i < 100; i++){
            process++;
        }
    }

    //Use LogExecutionTime Annotation
    @LogExecutionTime
    //Create a method computeResults()
    public void computeResults() {
        int result=0;
        for (int i = 0; i < 1000; i++){
            result++;
        }
    }

    //Use LogExecutionTime Annotation
    @LogExecutionTime
    //Create a method generateReport()
    public void generateReport() {
        int count=0;
        for (int i = 0; i < 100000; i++){
            count++;
        }
    }
}


//Create a class AnnotationForLoggingMethodExecutionTime
public class AnnotationForLoggingMethodExecutionTime {
    public static void main(String[] args) throws Exception {
        //Create an object of Task class
        Task obj = new Task();

        //Create an object of Method class
        Method[] methods = obj.getClass().getDeclaredMethods();

        //Use for-each loop
        for (Method method : methods) {
            //Check the condition
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                //Create a reference variable
                LogExecutionTime result = method.getAnnotation(LogExecutionTime.class);
                //Create a variable startTime to store the time
                long startTime = System.nanoTime();
                method.invoke(obj);
                //Create a variable endTime to store the end time
                long endTime = System.nanoTime();
                //Calculate the executionTime
                long executionTime = endTime - startTime;
                //Print the result
                System.out.println(result.message() + executionTime + " ns");
            }
        }
    }
}

