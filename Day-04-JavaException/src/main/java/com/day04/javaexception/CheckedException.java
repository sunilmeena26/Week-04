package com.day04.javaexception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Create a class HandleCheckedException to handle checked exception when the file does not exist, handle the IOException
class HandleCheckedException{
    //Create a static method readFileContent to read the file content and handle the exception
    public static void readFileContent(String filePath){

        //Use try-catch block to handled the exception
        try{
            //Read a file using BufferedReader class
            BufferedReader bufferedReader=new BufferedReader(new FileReader(filePath));
            String line="";
            //use while loop
            while((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
            //close the BufferedReader
            bufferedReader.close();
            //handle the exception using catch block
        }catch (IOException ex){
            System.out.println("File not found! "+ex.getMessage());
        }
    }
}

//Create a class CheckedException to use HandleCheckedException class
public class CheckedException {
    public static void main(String[] args) {
        //Create a String variable to store the the file path
        String filePath="C:\\Week-04\\Day-04-JavaException\\src\\main\\java\\com\\day04\\javaexception\\sourcefile.txt";
        //call the method readFileContent
        HandleCheckedException.readFileContent(filePath);
    }
}
