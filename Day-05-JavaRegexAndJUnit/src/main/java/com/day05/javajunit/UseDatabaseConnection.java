package com.day05.javajunit;

//Create a class DatabaseConnection to display database connectivity status
class DatabaseConnection {
    private boolean isConnected;

    //Create a method connect If database is connect then print connected
    public void connect() {
        isConnected = true;
        System.out.println("Database connected.");
    }

    //Create a method disconnect If database is disconnect then print disconnected
    public void disconnect() {
        isConnected = false;
        System.out.println("Database disconnected.");
    }

    //Create a method to print database status
    public boolean isConnected() {
        return isConnected;
    }
}

//Create a class UseDatabaseConnection to use DatabaseConnection class
public class UseDatabaseConnection extends DatabaseConnection{
    public static void main(String[] args) {
        //Create an object of DatabaseConnection class
        DatabaseConnection databaseConnection=new DatabaseConnection();

        //print database status
        databaseConnection.connect();
        System.out.println("Database is connected: "+databaseConnection.isConnected());
        databaseConnection.disconnect();
        System.out.println("Database is connected: "+databaseConnection.isConnected());
    }
}
