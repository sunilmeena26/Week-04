package com.day06.javaannotations;


import java.lang.annotation.*;
import java.lang.reflect.Method;

//Create an Annotation RoleAllowed
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

//Create a class Person
class Person {
    //Create a private variable role
    private String role;

    //Parameterized constructor to initialize variable
    public Person(String role) {
        this.role = role;
    }

    //Create a getter method
    public String getRole() {
        return role;
    }
}

//Create a class Service
class Service {
    //Use the Annotation
    @RoleAllowed("ADMIN")
    //Create a method adminTask
    public void adminTask() {
        //Print the result
        System.out.println("Admin task executed.");
    }

    //Use the Annotation
    @RoleAllowed("USER")
    //Create a method userTask
    public void userTask() {
        //Print the result
        System.out.println("User task executed.");
    }

    //Create a static method accessTheService
    public static void accessTheService(Object obj, String methodName, Person user) throws Exception {
        //Create an object of Method class
        Method method = obj.getClass().getMethod(methodName);
        //Check the condition
        if (method.isAnnotationPresent(RoleAllowed.class)) {
            //Create a reference variable
            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            //Check the condition
            if (roleAllowed.value().equals(user.getRole())) {
                method.invoke(obj);
            } else {
                //Print the statement
                System.out.println("Access Denied! Required role: " + roleAllowed.value());
            }
        } else {
            method.invoke(obj);
        }
    }
}


//Create a class RoleBasedAccessControlWithRoleAllowed
public class RoleBasedAccessControlWithRoleAllowed {
    public static void main(String[] args) {
        //Create an object of service class
        Service service = new Service();
        Person adminUser = new Person("ADMIN");
        Person regularUser = new Person("USER");

        //Use try block
        try {
            //Call the method and print the result
            System.out.println("Admin User Trying to Execute Admin Task:");
            Service.accessTheService(service, "adminTask", adminUser);

            //Call the method and print the result
            System.out.println("\nRegular User Trying to Execute Admin Task:");
            Service.accessTheService(service, "adminTask", regularUser);

            //Call the method and print the result
            System.out.println("\nRegular User Trying to Execute User Task:");
            Service.accessTheService(service, "userTask", regularUser);

        } catch (Exception e) {//Handle the exception
            System.out.println("Error "+e.getMessage());
        }
    }
}
