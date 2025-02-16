package com.day06.javaannotations;

import java.lang.annotation.*;
import java.lang.reflect.Field;

//Create an Annotation MaxLength
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value() default 10;
}

//Create a class Registration
class Registration{
    //Use the MaxLength Annotation
    @MaxLength
    //Create a variable to store the value
            String username;

    //Parameterized Constructor to initialize variable
    public Registration(String username) {
        this.username = username;
        //Call the method
        validateMaxLength(this, username);
    }

    //Create a method validateMaxLength to validate the max length
    void validateMaxLength(Registration user, String username) {
        //Create an array of object
        Field[] fields = user.getClass().getDeclaredFields();

        //Use for-each loop
        for (Field field : fields) {
            //Check the condition
            if (field.isAnnotationPresent(MaxLength.class)) {
                //Create a reference variable  and call the method
                MaxLength maxLength = field.getAnnotation(MaxLength.class);

                //check the condition
                if (username.length() > maxLength.value()) {
                    //Throw the exception
                    throw new IllegalArgumentException("Username exceeds maximum length of " + maxLength.value() + " characters.");
                }
            }
        }
    }
}

//Create a class MaxLengthAnnotationForFieldValidation
public class MaxLengthAnnotationForFieldValidation {
    public static void main(String[] args) {
        //Use try block
        try {
            //Create an object of Registration class
            Registration user1 = new Registration("AnchalSahu");

            //Print the result
            System.out.println("User1: " + user1.username);

            //Create an object of Registration class
            Registration user2 = new Registration("AsDemon1234");

            //Print the result
            System.out.println("User2: " + user2.username);
        } catch (IllegalArgumentException e) {//Catch block to handle exception
            //Print the result
            System.out.println(e.getMessage());
        }
    }
}
