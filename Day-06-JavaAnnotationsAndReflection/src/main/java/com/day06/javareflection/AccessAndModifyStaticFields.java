package com.day06.javareflection;

import java.lang.reflect.Field;

// Create a class Configuration with a private static field API_KEY
class Configuration {
    //Create a private static variable(field) to store API_KEY
    private static String API_KEY = "AIzaSyDaGmWKa4JsXZ-HjGw7ISLn_3namBGewQe ";

    //Create a method to display the API_KEY
    public static void displayApiKey() {
        System.out.println("API_KEY: " + API_KEY);
    }
}

//Create a class AccessAndModifyStaticFields to use Configuration class
public class AccessAndModifyStaticFields {
    public static void main(String[] args) {
        //Use try-catch block to handle the exception
        try {
            // Print the initial API_KEY
            System.out.println("Current API_KEY:");
            //call the method
            Configuration.displayApiKey();

            // Create a Class reference to point Configuration class object
            Class<?> configClass = Configuration.class;

            // Create a Field class reference to get the private static field 'API_KEY'
            Field apiKeyField = configClass.getDeclaredField("API_KEY");

            // Set the field accessible to allow modification
            apiKeyField.setAccessible(true);

            //update the API_KEY of private static field
            apiKeyField.set(null, "AIzaSyBhKx_b0yj4erq8sZchmTw8BRXWyivLzW0");

            // Access the modified value of the private static field 'API_KEY'
            String modifiedApiKey = (String) apiKeyField.get(null);

            // print the modified API_KEY
            System.out.println("Modified API_KEY: " + modifiedApiKey);

            // print the modified API_KEY using the method
            Configuration.displayApiKey();

        }
        //handle the exception using catch block
        catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
