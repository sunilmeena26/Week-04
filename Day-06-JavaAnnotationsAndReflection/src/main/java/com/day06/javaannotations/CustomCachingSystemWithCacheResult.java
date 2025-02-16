package com.day06.javaannotations;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

//Create an Annotation CacheResult
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

//create a class CacheManager
class CacheManager {
    //Create a HashMap to store value
    static final Map<String, Object> cache = new HashMap<>();

    //Create a method to invoke method
    public static Object invokeMethod(Object obj, String methodName, Object... args) throws Exception {
        //Create an object of method class
        Method method = obj.getClass().getDeclaredMethod(methodName, toClasses(args));
        //Create a variable to store value
        String key = generateKey(methodName, args);
        //Check the condition
        if (cache.containsKey(key)) {
            //Print the statement
            System.out.println("Returning cached result for: " + key);
            return cache.get(key);
        } else {
            Object result = method.invoke(obj, args);
            cache.put(key, result);
            //Print the statement
            System.out.println("Caching result for: " + key);
            return result;
        }
    }

    //Create a static method to gnerate kay
    public static String generateKey(String methodName, Object... args) {
        //Create an object of StringBuilder
        StringBuilder key = new StringBuilder(methodName);
        for (Object arg : args) {
            key.append("-").append(arg.toString());
        }
        return key.toString();
    }

    //Crete a method
    public static Class<?>[] toClasses(Object... args) {
        Class<?>[] classes = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Integer) {
                classes[i] = int.class;
            } else if (args[i] instanceof Long) {
                classes[i] = long.class;
            } else if (args[i] instanceof Double) {
                classes[i] = double.class;
            } else if (args[i] instanceof Float) {
                classes[i] = float.class;
            } else if (args[i] instanceof Boolean) {
                classes[i] = boolean.class;
            } else if (args[i] instanceof Character) {
                classes[i] = char.class;
            } else if (args[i] instanceof Byte) {
                classes[i] = byte.class;
            } else if (args[i] instanceof Short) {
                classes[i] = short.class;
            } else {
                classes[i] = args[i].getClass();
            }
        }
        return classes;
    }
}

//Create a class ExpensiveService
class ExpensiveService {
    //Use the Annotation
    @CacheResult
    //Create a method  computeFactorial
    public int computeFactorial(int n) {
        System.out.println("Computing factorial of " + n);
        return factorial(n);
    }

    //Create a method factorial
    int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}

//Create a class CustomCachingSystemWithCacheResult
public class CustomCachingSystemWithCacheResult {
    public static void main(String[] args) {
        //Create an object of ExpensiveService
        ExpensiveService service = new ExpensiveService();

        //Use try block
        try {
            //Call the method and print the result
            System.out.println("Result: " + CacheManager.invokeMethod(service, "computeFactorial", 5));

            //Call the method and print the result
            System.out.println("Result: " + CacheManager.invokeMethod(service, "computeFactorial", 5));

        } catch (Exception e) {//Catch block to handle exception
            System.out.println("Error "+e.getMessage());
        }
    }
}
