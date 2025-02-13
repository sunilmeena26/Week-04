package com.day03.javastream;

import java.io.*;
//Create a class ReadLargeFile to read a file
class ReadLargeFile{
    public static void readLargeFile(String filePath){

        //Use try block to handle the exception
        try{
            //Create an object of BufferedReader class
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            //Create a variable to store the values
            String data="" ;

            //Use while loop to read the file
            while((data= br.readLine())!=null){
                //Check the condition and print the result
                if (data.toLowerCase().contains("error".toLowerCase())) {
                    System.out.println(data);
                }
            }

            //close the object
            br.close();

        } catch (IOException e) {
            //Print the statement if exception is occur
            System.out.println("error "+e.getMessage());
        }
    }
}
//Create a class ReadALargeFileLineByLine
public class ReadALargeFileLineByLine {
    public static void main(String[] args) {
        //Create a variable to store the value
        String filePath = "C:\\Week-04\\Day-03-JavaStreams\\src\\main\\java\\com\\day03\\javastream\\sourcefile.txt";

        //Call the method to read file and print the result
        ReadLargeFile.readLargeFile(filePath);

    }
}
