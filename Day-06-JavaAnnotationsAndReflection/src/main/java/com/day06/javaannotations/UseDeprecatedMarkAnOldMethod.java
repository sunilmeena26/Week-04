package com.day06.javaannotations;

//Create a class LegacyAPI
class LegacyAPI {
    //Use the @Deprecated Annotation
    @Deprecated
    //Create a method oldFeature()
    void oldFeature() {
        //Print the statement
        System.out.println("Old Features.");
    }

    //Create a method newFeature()
    void newFeature() {
        //Print the statement
        System.out.println("New Features.");
    }
}

//Create a class UseDeprecatedMarkAnOldMethod
public class UseDeprecatedMarkAnOldMethod {
    public static void main(String[] args) {

        //Create an object of LegacyAPI class
        LegacyAPI legacyAPI = new LegacyAPI();

        //Call the method
        legacyAPI.oldFeature();

        //Call the method
        legacyAPI.newFeature();
    }
}
