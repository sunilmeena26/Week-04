package com.day05.javajunit;

import java.io.*;

//Create class to File to read and write the file content
class File {

    //Create a method writeToFile to write content to a file
    public static void writeToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }

    //Create a method readFromFile to read content from a file
    public static String readFromFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }
        return content.toString().trim();
    }
}

//Create a class FileProcessor to use File class
public class FileProcessor extends File {
    public static void main(String[] args) {
        //use try-catch block to handle the exception
        try {
            //Create a String variable to store file path
            String filePath = "C:\\Week-04\\Day-05-JavaRegexAndJUnit\\src\\main\\java\\com\\day05\\javajunit\\sourcefile.txt";
            //call the method
            String string = File.readFromFile(filePath);
            System.out.println(string);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
