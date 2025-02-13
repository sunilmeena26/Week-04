package com.day03.javastream;

import java.io.*;
//Create a class to ReadWriteTextFile to read and write the file
class ReadWriteTextFile{

    //Create a static method readAndWriteFile to read and write file
    public static void readAndWriteFile(String sourceFile,String destinationFile){
        //Use try block to handle the exception
        try {
            //Create and object of FileInputStream
            FileInputStream readFile = new FileInputStream(sourceFile);

            //Create and object of FileOutputStream
            FileOutputStream writeFile = new FileOutputStream(destinationFile);

            //Create a variable to store the data
            int data;

            //Use while loop to read and write the file
            while((data = readFile.read()) !=-1){
                writeFile.write(data);
            }

            //Use flush method to forcedata to be written
            writeFile.flush();

            //Print the statement
            System.out.println("File Read And Write Operation Completed.");

            //Close the file object
            readFile.close();
            writeFile.close();

        } catch (IOException e) { //Catch block to handle exception

            //Print the statement
            System.out.println("Error"+e.getMessage());
        }
    }
}

//Create a class FileHandlingReadAndWriteTextFile
public class FileHandlingReadAndWriteTextFile {
    public static void main(String[] args) {

        //Create variable to store the file path
        String filePath1 = "C:\\Week-04\\Day-03-JavaStreams\\src\\main\\java\\com\\day03\\javastream\\sourcefile.txt";

        //Create variable to store the file path
        String filePath2 = "C:\\Week-04\\Day-03-JavaStreams\\src\\main\\java\\com\\day03\\javastream\\destinationfile2.txt";

        //Call the method to perform read and write operation
        ReadWriteTextFile.readAndWriteFile(filePath1,filePath2);
    }
}

