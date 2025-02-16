package com.day06.javareflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Annotation;

// Create an interface of Author and make the annotation available at runtime
@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    //Create a method name to without body
    String name();
}

//Create a class Book and apply the Author annotation to the Book class
@Author(name = "Herbert Schildt")
class Book {

    //Create a variable title to store book title
    private String title;

    //Create a  constructor to initialize the title
    public Book(String title) {
        this.title = title;
    }

    //Create a method to display the book title
    public void displayTitle() {
        System.out.println("Title: " + title);
    }
}

//Create a class RetrieveAnnotationsAtRuntime to use Book class and Author interface
public class RetrieveAnnotationsAtRuntime {
    public static void main(String[] args) {
        //Use try-catch block to handle the exception
        try {
            // Create a Class reference to point Book class object
            Class<?> bookClass = Class.forName("Book");

            // Check if the Author annotation is present on the class
            if (bookClass.isAnnotationPresent(Author.class)) {
                //Create an Annotation class reference to get the Author annotation
                Annotation annotation = bookClass.getAnnotation(Author.class);
                Author author = (Author) annotation;

                // Display the annotation value
                System.out.println("Author: " + author.name());
            } else {
                System.out.println("Author annotation is not present on the Book class.");
            }

        }
        //handle the exception using catch block
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
