package com.day06.javareflection;

import java.lang.reflect.Constructor;

// Create a class Student to define student details
class Student {
    //Create a variable name and rollNumber to store name and roll number
    private String name;
    private int rollNumber;

    //Create a constructor to initialize the student details
    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    //Create a method displayDetails to display student details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
    }
}

//Create a class DynamicallyCreateObjects to use Student class
public class DynamicallyCreateObjects {
    public static void main(String[] args) {
        //Use try-catch block to handle the exception
        try {
            // Create a Class reference to point Student class object
            Class<?> studentClass = Class.forName("Student");

            // Get the constructor of the Student class with parameters String and int
            Constructor<?> constructor = studentClass.getConstructor(String.class, int.class);

            // Create a new object of the Student class using the constructor
            Object student = constructor.newInstance("John Doe", 101);

            // type casting in student class
            Student studentInstance = (Student) student;

            // Print the student details
            studentInstance.displayDetails();
        }

        //handle the exception
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
