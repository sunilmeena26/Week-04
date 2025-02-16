package com.day06.javaannotations;


import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.*;

//Create an Annotation JsonField
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

//Create a class user
class User {

    //Use JsonField Annotation
    @JsonField(name = "user_name")
    //Create a variable to store variable
            String username;

    //Use JsonField Annotation
    @JsonField(name = "user_age")
    //Create a variable to store variable
            int age;

    //Parameterize constructor to initialize variable
    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    //Create a method to convert object to json
    public static String ObjectToJson(Object obj) throws IllegalAccessException {
        //Create an object
        Class<?> objClass = obj.getClass();

        //Create a HashMap to store value
        Map<String, Object> jsonElements = new HashMap<>();

        //Use for loop
        for (Field field : objClass.getDeclaredFields()) {
            //Check the condition
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField jsonField = field.getAnnotation(JsonField.class);
                jsonElements.put(jsonField.name(), field.get(obj));
            }
        }

        //Create an object of stringBuilder class
        StringBuilder jsonString = new StringBuilder("{");

        //Use for loop
        for (Map.Entry<String, Object> entry : jsonElements.entrySet()) {
            //Call the append method
            jsonString.append("\"").append(entry.getKey()).append("\": ");
            //check the condition
            if (entry.getValue() instanceof String) {
                jsonString.append("\"").append(entry.getValue()).append("\"");
            } else {
                jsonString.append(entry.getValue());
            }
            jsonString.append(", ");
        }
        if (jsonString.length() > 1) {
            jsonString.setLength(jsonString.length() - 2);
        }
        jsonString.append("}");
        return jsonString.toString();
    }

}

//Create a class CustomSerializationAnnotationJsonField
public class CustomSerializationAnnotationJsonField {
    public static void main(String[] args) {
        //Create an object of User class
        User user = new User("Anjali", 30);
        try {
            //Create a variable to store the variable
            String jsonString = User.ObjectToJson(user);
            System.out.println(jsonString);
        } catch (IllegalAccessException e) {//catch block to handle exception
            System.out.println("Error "+e.getMessage());
        }
    }
}
