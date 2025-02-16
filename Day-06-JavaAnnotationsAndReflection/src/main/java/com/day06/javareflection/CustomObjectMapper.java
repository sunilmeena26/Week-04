package com.day06.javareflection;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.HashMap;

//Create a class ObjectMapper to implement toObject method
class ObjectMapper {

    //Create a static method toObject to implement it
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        //Use try-catch block to handle the exception
        try {
            // Create a reference of T class
            T instance = clazz.getDeclaredConstructor().newInstance();

            // Use for-each loop to iterate the map
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                // Create a Field class reference to get the field of the class by the field name
                Field field = clazz.getDeclaredField(fieldName);

                //call the method setAccessible set the field accessible to allow modification
                field.setAccessible(true);

                //call the method set to set the value of the field in the instance
                field.set(instance, fieldValue);
            }

            //return the object
            return instance;
        }
        //handle the exception using catch block
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

// Create a Person1 class to define person details
class Person1 {
    //Create a variable name and age to store person name and age
    private String name;
    private int age;

    // Create a getter method to getName
    public String getName() {
        return name;
    }

    // Create a getter method to getName
    public int getAge() {
        return age;
    }
}


//Create a class CustomObjectMapper to use Person1 class
public class CustomObjectMapper {
    public static void main(String[] args) {
        //Create a HashMap class for storing key-value
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "Radhe");
        properties.put("age", 30);

        //Create a Person1 reference to convert the properties map to a Person1 object
        Person1 Person1 = ObjectMapper.toObject(Person1.class, properties);

        // Print the Person1's details
        if (Person1 != null) {
            System.out.println("Name: " + Person1.getName());
            System.out.println("Age: " + Person1.getAge());
        }
    }
}
