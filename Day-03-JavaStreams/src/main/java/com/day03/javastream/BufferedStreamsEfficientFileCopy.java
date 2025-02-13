package com.day03.javastream;

import java.io.*;

//Create a class BufferedStream to compare the performance of buffered stream and unbuffered stream
class BufferedStreams{
    //Create a static method copyFileWithBufferedStream to copy file in another file using buffered stream
    public static void copyFileWithBufferedStream(String sourceFilePath, String destinationFilePath){
        //use try-catch block to handle the exception
        try {
            //Create an object of BufferedInputStream and BufferedOutputStream class
            BufferedInputStream bis=new BufferedInputStream(new FileInputStream(sourceFilePath));
            BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(destinationFilePath));

            byte[] buffer=new byte[4096];
            int bytesRead;
            //copy file test in another file
            while((bytesRead=bis.read(buffer))!=-1){
                bos.write(buffer,0,bytesRead);
            }
            //handle the exception by catch block
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    //Create a static method copyFileWithBufferedStream to copy file in another file using unbuffered stream
    public static void copyFileWithUnBufferedStream(String sourceFilePath, String destinationFilePath){
        //use try-catch block to handle the exception
        try {
            //Create an object of FileInputStream and FileOutputStream class
            FileInputStream fis=new FileInputStream(sourceFilePath);
            FileOutputStream fos=new FileOutputStream(destinationFilePath);

            byte[] buffer=new byte[4096];
            int bytesRead;
            //copy file test in another file
            while((bytesRead=fis.read(buffer))!=-1){
                fos.write(buffer,0,bytesRead);
            }
            //handle the exception by catch block
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}

//Create a class BufferedStreamsEfficientFileCopy to use BufferedStreams class
public class BufferedStreamsEfficientFileCopy {
    public static void main(String[] args) {
        //Create a variable long startTime,endTime, unbufferReaderTime,and bufferReaderTime to store start and end time of execution
        long startTime,endTime,bufferReaderTime,unbufferReaderTime;
        //Create a variable String sourceFilePath and destinationFilePath to store source file path and destination file path
        String sourceFilePath="C:\\Week-04\\Day-03-JavaStreams\\src\\main\\java\\com\\day03\\javastream\\sourcefile.txt";
        String destinationFilePath="C:\\Week-04\\Day-03-JavaStreams\\src\\main\\java\\com\\day03\\javastream\\destinationfile.txt";

        //store a starting time in nanosecond
        startTime=System.nanoTime();
        //call the method copyFileWithBufferedStream
        BufferedStreams.copyFileWithBufferedStream(sourceFilePath,destinationFilePath);
        //store a ending time in nanosecond
        endTime=System.nanoTime();
        bufferReaderTime=startTime-endTime;

        //store a starting time in nanosecond
        startTime=System.nanoTime();
        //call the method copyFileWithUnBufferedStream
        BufferedStreams.copyFileWithUnBufferedStream(sourceFilePath,destinationFilePath);
        //store a ending time in nanosecond
        endTime=System.nanoTime();
        unbufferReaderTime=endTime-startTime;

        //print the performance result based on time duration
        System.out.println("Time Execution by Buffered Stream"+bufferReaderTime);
        System.out.println("Time Execution by Buffered Stream"+unbufferReaderTime);
    }
}
