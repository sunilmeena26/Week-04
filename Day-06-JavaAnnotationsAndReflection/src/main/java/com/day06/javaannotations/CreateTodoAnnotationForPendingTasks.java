package com.day06.javaannotations;


import java.lang.annotation.*;
import java.lang.reflect.Method;

//Create an Annotation Todo
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

//Create a class Project
class Project {
    //Use Todo Annotation
    @Todo(task = "Build FrontEnd", assignedTo = "Radhe", priority = "HIGH")
    //Create a method frontEnd()
    public void frontEnd() {
        //Print the statement
        System.out.println("Make FrontEnd");
    }

    //Use Todo Annotation
    @Todo(task = "Prepare Presentation", assignedTo = "Aradhana")
    //Create a method presentation()
    public void presentation() {
        //Print the statement
        System.out.println("Make Presentation");
    }

    ///Use Todo Annotation
    @Todo(task = "DataBase Connectivity", assignedTo = "Ram", priority = "LOW")
    //Create a method connectDataBase()
    public void connectDataBase() {
        //Print the statement
        System.out.println("Connect to DataBase");
    }
}


//Create a class CreateTodoAnnotationForPendingTasks
public class CreateTodoAnnotationForPendingTasks {
    public static void main(String[] args) {

        //Create an object of Class
        Class<Project> projectDetails = Project.class;

        //Create an object of method class
        Method[] methods = projectDetails.getDeclaredMethods();

        //Use for loop
        for (Method method : methods) {
            //Check the condition
            if (method.isAnnotationPresent(Todo.class)) {
                //Create a reference variable of Todo
                Todo todo = method.getAnnotation(Todo.class);

                //Print the result
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println();
            }
        }
    }
}

