package com.day06.javareflection;

import java.util.Scanner;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//Create a class ClassInfo to print class Details
class ClassInfo{

    //Create a static method classInformation to print the class information
    public static void classInformation(String className){
        //use try-catch block to handle ClassNotFoundException
        try {
            //Use Class object
            // Load the class
            Class<?> clazz = Class.forName(className);

            // Display class details
            System.out.println("Class Name: " + clazz.getName());
            System.out.println("Package: " + clazz.getPackage());

            // Display constructors details
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            // Display fields details
            System.out.println("\nFields:");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }

            // Display methods details
            System.out.println("\nMethods:");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        }
    }
}


//Create a class ClassInformation to use ClassInfo class
public class ClassInformation {
        public static void main(String[] args) {
            //Create a Scanner class Object for take user input
            Scanner scanner = new Scanner(System.in);

            //Create variable to store the class name
            System.out.print("Enter class name: ");
            String className = scanner.nextLine();

            //call the method
            ClassInfo.classInformation(className);
            scanner.close();
        }

}
