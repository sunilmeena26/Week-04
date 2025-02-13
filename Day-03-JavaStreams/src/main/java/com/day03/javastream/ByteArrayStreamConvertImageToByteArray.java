package com.day03.javastream;

import java.io.*;
import java.util.*;
//Create a class ConvertImage to indicate the converting image
class ConvertImage{

    //Create a static method to convertImageToByte
    public static void convertImageToByte(String originalImagePath,String newImagePath){
        //Use try block
        try {
            //Create an array of byte to store the imageBytes
            byte[] imageBytes = imageToByteArray(originalImagePath);

            //Call the method to convert byte array to image
            writeImageFromBytes(imageBytes, newImagePath);

            //Call the method to verifyImage
            verifyImage(originalImagePath, newImagePath);

        } catch (IOException e) {//Catch block to handle exception
            System.out.println("Error: " + e.getMessage());
        }
    }

    //Create a method imageToByteArray to convert image to array
    private static byte[] imageToByteArray(String filePath) {
        //Use try block
        try {
            //Create an object of FileInputStream
            FileInputStream fileInputStream = new FileInputStream(filePath);

            //Create an array of byteArrayOutputStream class
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            //Create an array temp
            byte[] temp = new byte[1024];

            //Create a vriable to store data
            int data;

            //USe while loop
            while ((data = fileInputStream.read(temp)) != -1) {
                byteArrayOutputStream.write(temp, 0, data);
            }

            return byteArrayOutputStream.toByteArray();
        }catch (IOException e) {//Catch block to handle exception
            System.out.println("Error: " + e.getMessage());
            return new byte[0];
        }
    }

    //Create a method to writeImageFromBytes
    private static void writeImageFromBytes(byte[] imageBytes, String filePath) {
        try  {
            //Create an object of ByteArrayInputStream
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageBytes);

            //Create an object of FileInputStream
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);

            //Create an array temp
            byte[] temp = new byte[1024];

            //Create a variable to store data
            int data;

            //use while loop
            while ((data = byteArrayInputStream.read(temp)) != -1) {
                fileOutputStream.write(temp, 0, data);
            }

            //Call the flush method
            fileOutputStream.flush();
        }catch (IOException e) {//Catch block to handle exception
            System.out.println("Error: " + e.getMessage());
        }
    }

    //Create a static method to verify Image
    private static void verifyImage(String originalPath, String newPath) throws IOException {
        //Call the method to convert image into byte
        byte[] originalBytes = imageToByteArray(originalPath);
        byte[] newBytes = imageToByteArray(newPath);

        //Compare the array and print the result
        if(Arrays.equals(originalBytes, newBytes)){
            System.out.println("The new image file is identical to the original image.");
        }else{
            System.out.println("The new image file is not identical to the original image.");
        }
    }
}

//Create a class ByteArrayStreamConvertImageToByteArray
public class ByteArrayStreamConvertImageToByteArray {
    public static void main(String[] args) {

        //Create a variable to store the value
        String originalImagePath = "C:\\Users\\hp\\IdeaProjects\\JavaStreams\\src\\main\\java\\com\\javastream\\day03\\OriginalImage.jpg";
        String newImagePath ="C:\\Users\\hp\\IdeaProjects\\JavaStreams\\src\\main\\java\\com\\javastream\\day03\\newImage.jpg";

        //Call the convert image
        ConvertImage.convertImageToByte(originalImagePath,newImagePath);
    }
}
