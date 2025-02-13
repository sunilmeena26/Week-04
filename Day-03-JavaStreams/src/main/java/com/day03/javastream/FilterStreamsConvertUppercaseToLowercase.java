package com.day03.javastream;


import java.io.*;

//Create a class UppercaseToLowercaseConverter to convert file text in upper to lowercase
class UppercaseToLowercaseConverter {
    //Create a static method to convert uppercase letters to lowercase and write to a new file
    public static void convertUppercaseToLowercase(String inputFilePath, String outputFilePath, String encoding) {
        //use try-catch block for handle exception
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilePath), encoding));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFilePath), encoding));

            String line;
            while ((line = reader.readLine()) != null) {
                // Convert line into lowercase
                String lowerCaseLine = line.toLowerCase();
                writer.write(lowerCaseLine);
                // Write a new line
                writer.newLine();
            }

            System.out.println("File has been successfully converted and written to: " + outputFilePath);
        //use catch block for handle the exception
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//Create a class FilterStreamsConvertUppercaseToLowercase to use UppercaseToLowercaseConverter class
public class FilterStreamsConvertUppercaseToLowercase {
    public static void main(String[] args) {
        //Create a variable to store input and output file path
        String inputFilePath = "C:\\Week-04\\Day-03-JavaStreams\\src\\main\\java\\com\\day03\\javastream\\sourcefile.txt";
        String outputFilePath = "C:\\Week-04\\Day-03-JavaStreams\\src\\main\\java\\com\\day03\\javastream\\lowercaseletterfile.txt";
        String ENCODING = "UTF-8";
        //call the method convertUppercaseToLowercase to convert letter in loew case
        UppercaseToLowercaseConverter.convertUppercaseToLowercase(inputFilePath,outputFilePath,ENCODING);
    }
}
