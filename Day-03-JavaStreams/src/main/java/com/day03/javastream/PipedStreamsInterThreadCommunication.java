package com.day03.javastream;

import java.io.*;


//Create a class WriterTask to write data into PipedOutputStream
class WriterTask implements Runnable {
    //Create a final PipedOutputStream
        private final PipedOutputStream pipedOutputStream;

        //Create a constructor to initialize pipedOutputStream
        public WriterTask(PipedOutputStream pipedOutputStream) {
            this.pipedOutputStream = pipedOutputStream;
        }

        //Create a method run() to override the method
        public void run() {
            //handle the exception by try-catch block
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(pipedOutputStream))) {
                String[] messages = {"Hello", "This", "Is", "A", "Test", "Message"};
                for (String message : messages) {
                    writer.write(message);
                    writer.newLine();
                    writer.flush();
                    System.out.println("Written: " + message);
                    // Simulate time taken for writing
                    Thread.sleep(100);
                }
                //handle the exception
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
// Reader task to read data from PipedInputStream
class ReaderTask implements Runnable {
    //Create a final PipedOutputStream
        private final PipedInputStream pipedInputStream;

       //Create a constructor to initialize pipedOutputStream
        public ReaderTask(PipedInputStream pipedInputStream) {
            this.pipedInputStream = pipedInputStream;
        }

       //Create a method run() to override the method
        public void run() {
            //handle the exception by try-catch block
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(pipedInputStream))) {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Read: " + message);
                }
                //handle the exception by catch clock
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}

//Create a class PipedStreamsInterThreadCommunication to use WriterTask and ReaderTask class
public class PipedStreamsInterThreadCommunication {
    public static void main(String[] args) {
        // Create piped input and output streams
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream();

        //handle the exception by try-catch block
        try {
            // Connect the piped input stream to the piped output stream
            pipedInputStream.connect(pipedOutputStream);

            // Create and start the writer thread
            Thread writerThread = new Thread(new WriterTask(pipedOutputStream));
            writerThread.start();

            // Create and start the reader thread
            Thread readerThread = new Thread(new ReaderTask(pipedInputStream));
            readerThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
