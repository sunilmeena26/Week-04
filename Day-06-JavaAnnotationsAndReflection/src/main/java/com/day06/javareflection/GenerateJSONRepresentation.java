package com.day06.javareflection;

// Import the necessary classes
import java.lang.reflect.Field;

//Create a class JsonBody to override toJson methods
class JsonBody {

    //Create a method toJson to override it and convert an object to a JSON-like string
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder();
        json.append("{");

        // Create a Class reference to point Object class object
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            try {
                String fieldnameOfPersons = field.getName();
                Object fieldValue = field.get(obj);

                json.append("\"").append(fieldnameOfPersons).append("\": ");

                if (fieldValue instanceof String) {
                    json.append("\"").append(fieldValue).append("\"");
                } else {
                    json.append(fieldValue);
                }

                if (i < fields.length - 1) {
                    json.append(", ");
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        json.append("}");
        return json.toString();
    }
}

// Create a Persons class to define person details
class Persons {
    //Create a variable nameOfPersons and ageOfPersons to store person name and age
    private String nameOfPersons;
    private int ageOfPersons;

    //Create a constructor to initialize the person details
    public Persons(String nameOfPersons, int ageOfPersons) {
        this.nameOfPersons = nameOfPersons;
        this.ageOfPersons = ageOfPersons;
    }
}

//Create a class GenerateJSONRepresentation to use Person and JsonBody class
public class GenerateJSONRepresentation {
    public static void main(String[] args) {
        // Create an object of Persons class and pass argument as person details
        Persons Persons = new Persons("Rakesh", 30);

        //Create a variable jsonString to convert the Persons object to a JSON-like string
        String jsonString = JsonBody.toJson(Persons);

        // print the JSON result like string
        System.out.println(jsonString);
    }
}
