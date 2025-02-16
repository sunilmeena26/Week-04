package com.day06.javaannotations;


import java.util.ArrayList;

//Create  a class Student
class Student{
    //Use the SuppressWarnings Annotation
    @SuppressWarnings("unchecked")
    //Create a method studentRecord
    public void studentRecord(){

        //Create an Arraylist without generics
        ArrayList record = new ArrayList();

        //Call the add method
        record.add("Mohit");
        record.add(118);
        record.add(150);

        //Use for-each loop and print the details
        for(Object val: record){
            System.out.println(val);
        }
    }
}

//Create a class SuppressUncheckedWarnings
public class SuppressUncheckedWarnings {

    public static void main(String[] args) {

        //Create an object of Student class
        Student studentDetails = new Student();

        //Call the method
        studentDetails.studentRecord();
    }
}
