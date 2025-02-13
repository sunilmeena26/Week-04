package com.day03.javastream;

import java.io.*;

//Create a class ReadUserInput
class ReadUserInput{
    //Create a static variable to store the filePath
    static String filePath ="C:\\Week-04\\Day-03-JavaStreams\\src\\main\\java\\com\\day03\\javastream\\sourcefile.txt";

    //Create a method to take input from user
    public void readUserInput(){

        //Create an object of BufferedReader class
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Use try block
        try {
            //Create a variable name to store value and take input
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            //Create a variable age to store value and take input
            System.out.print("Enter your age: ");
            int age = Integer.parseInt(reader.readLine());

            //Create a variable programmingLanguage to store value and take input
            System.out.print("Enter your favorite programming language: ");
            String programmingLanguage = reader.readLine();

            //Call the method to store data into file
            writeDataIntoFile(name,age,programmingLanguage);


        } catch (IOException e) { //Catch block to handle exception

            //Print the statement
            System.out.println("Error: " + e.getMessage());
        }
    }

    //Create private a method to write data into file
    private static void writeDataIntoFile(String name, int age, String programmingLanguage) {
        //Use try block
        try {
            //Create an object of FileWriter class
            FileWriter writeFile = new FileWriter(filePath,true);
            //Call the write method
            writeFile.write("\nName: " + name + "\n");
            writeFile.write("Age: " + age + "\n");
            writeFile.write("Favorite Programming Language: " + programmingLanguage + "\n");

            //Call the flush method
            writeFile.flush();
        } catch (IOException e) {//Catch block to handle exception
            System.out.println("Error " + e.getMessage());
        }
    }
}

//Create a class ReadUserInputFromConsole
public class ReadUserInputFromConsole {
    public static void main(String[] args) {

        //Create an object of ReadUserInput class
        ReadUserInput  input = new ReadUserInput();

        //Call the method to take input and write in file
        input.readUserInput();

        //Call the method to take input and write in file
        input.readUserInput();

    }
}
