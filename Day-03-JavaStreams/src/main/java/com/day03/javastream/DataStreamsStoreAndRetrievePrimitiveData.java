package com.day03.javastream;

import java.io.*;
//Create a class StoreAndRetrieve data from file
class StoreAndRetrieve{
    //Create a static variable to store the file path
    static String filePath = "C:\\Users\\hp\\IdeaProjects\\JavaStreams\\src\\main\\java\\com\\javastream\\day03\\sample4.txt";

    //Create a method to writeFile to write the file
    public static void writeFile(int rollNumber, String name, double cgpa) {
        //Use try block
        try {
            //Create an object of DataOutputStream class
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filePath));

            //Call method to write data into the file
            dataOutputStream.writeInt(rollNumber);
            dataOutputStream.writeUTF(name);
            dataOutputStream.writeDouble(cgpa);

            //Call the flush method
            dataOutputStream.flush();

            //Close the object
            dataOutputStream.close();
        } catch (IOException e) { //Catch the exception
            System.out.println("Error" + e.getMessage());
        }
    }

    //Create a method readFileData to  read file
    public static void readFileData() {
        try {

            //Create an object of DataInputStream class
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filePath));

            //create variable to store data and call the method
            int rollNumber = dataInputStream.readInt();
            String name = dataInputStream.readUTF();
            double cgpa = dataInputStream.readDouble();

            //Print the result
            System.out.println("Student Data:\nRoll Number: " + rollNumber+"\nName: " + name+"\nCGPA: " + cgpa);
        } catch (IOException e) {//Catch the exception
            System.out.println("Error" + e.getMessage());
        }
    }
}

//Create a class DataStreamsStoreAndRetrievePrimitiveData
public class DataStreamsStoreAndRetrievePrimitiveData {
    public static void main(String[] args) {
        //Create variable rollNumber,name and cgpa
        int rollNumber = 1000654;
        String name = "Anchal Sahu";
        double cgpa = 8.65;

        //Call the method to write the file
        StoreAndRetrieve.writeFile(rollNumber, name, cgpa);

        //Call the method to read student data and print the result
        StoreAndRetrieve.readFileData();
    }
}

