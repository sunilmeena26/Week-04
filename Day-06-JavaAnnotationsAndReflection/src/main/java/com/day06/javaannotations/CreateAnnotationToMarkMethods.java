package com.day06.javaannotations;


import java.lang.annotation.*;
import java.lang.reflect.Method;

//Create an Annotation ImportantMethod
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}


//Create a class Vehicle
class Vehicle{

    //Use the ImportantMethod Annotation
    @ImportantMethod(level = "HIGH")
    //Create a method getHighSpeed
    void getHighSpeed(){
        System.out.println("High Speed = 3`00");
    }

    //Use the ImportantMethod Annotation
    @ImportantMethod(level = "Low")
    //Create a method getModelName
    void getModelName(){
        System.out.println("Fortuner GR S 4X4");
    }
}

//Create a class CreateAnnotationToMarkMethods
public class CreateAnnotationToMarkMethods {
    public static void main(String[] args) {

        //Create a reference variable
        Class<?> vehicleInfo = Vehicle.class;

        //Use for-each loop
        for (Method method : vehicleInfo.getDeclaredMethods()) {
            // Check the condition if the method is annotated with @ImportantMethod
            if (method.isAnnotationPresent(ImportantMethod.class)) {

                //Create a reference of ImportantMethod
                ImportantMethod result = method.getAnnotation(ImportantMethod.class);

                //Print the result
                System.out.println("Method: " + method.getName() + ", Importance Level: " + result.level());
            }
        }
    }
}
