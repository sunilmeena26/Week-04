package com.day06.javareflection;

import java.lang.reflect.Field;

// Create a class Person to define person details
class Person {
    //Create a variable to store ageOfPerson of person Private field
    private int ageOfPerson;

    //Create a constructor to initialize the age
    public Person(int ageOfPerson) {
        this.ageOfPerson = ageOfPerson;
    }

    //Create a method displayAge to display age
    public void displayAge() {
        System.out.println("Age: " + ageOfPerson);
    }
}

//Create a class AccessPrivateField to use Person class
public class AccessPrivateField {
    public static void main(String[] args) {
        //Create try-catch block to handle exception
        try {
            // Create a Person class object and pass ageOfPerson
            Person person = new Person(25);

            //Print the initial age
            System.out.println("Initial Age:");
            person.displayAge();

            // Create a Class reference to point Person class object
            Class<?> personClass = person.getClass();

            // Get the private field 'age'
            Field ageField = personClass.getDeclaredField("age");

            // Set the field accessible to allow modification
            ageField.setAccessible(true);

            // Modify the value of the private field 'age'
            ageField.setInt(person, 30);

            // Retrieve the modified value of the private field 'age'
            int modifiedAge = ageField.getInt(person);

            // Print the modified age
            System.out.println("Modified Age: " + modifiedAge);

            // Print the modified age using the method
            person.displayAge();

        //Handle the exception using catch block
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
