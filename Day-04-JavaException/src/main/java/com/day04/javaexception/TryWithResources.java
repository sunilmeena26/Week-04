package com.day04.javaexception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Create a class ReadFirstLineFromFile to use try with resource
class ReadFirstLineFromFile{
    //Create a static method readFirstLineFromFile to reads the first line of a file using BufferedReader and handle the exception
    public static void readFirstLineFromFile(String filePath){

        //Create a BufferReader class Object for reading a file
        BufferedReader bufferedReader=null;
        //Use try-catch block to handled the exception
        try{
            //Read a file using BufferedReader class
            bufferedReader=new BufferedReader(new FileReader(filePath));

            //Create a String variable to store first line of the file
            String line=bufferedReader.readLine();

            //print the first line of file
            System.out.println("File first line is: ");
            System.out.println(line);
        }
        //handle the exception using catch block
        catch (IOException ex){
            System.out.println("Error reading file! "+ex.getMessage());
        }

        //use finally block for closing BufferedReader class object
        finally {
            try {
                //close the BufferedReader
                bufferedReader.close();
            }catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}

//Create a class TryWithResources to use ReadFirstLineFromFile class
public class TryWithResources {
    public static void main(String[] args) {
        //Create a String variable to store the file path
        String filePath="C:\\Week-04\\Day-04-JavaException\\src\\main\\java\\com\\day04\\javaexception\\sourcefile.txt";

        //call the method readFirstLineFromFile
        ReadFirstLineFromFile.readFirstLineFromFile(filePath);
    }
}
