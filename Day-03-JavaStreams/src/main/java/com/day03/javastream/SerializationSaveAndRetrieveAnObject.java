package com.day03.javastream;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


//Create a class Employee to store particular employee details
class Employee implements Serializable {
    //Create a static final long variable serialVersionUID to store serial version UID
    private static final long serialVersionUID=1;
    //Create a variable id,nameOfEmployee,department and salary to store employee details
    private int id;
    private String nameOfEmployee,department;
    private double salary;


    //Create a constructor to initialize employee details
    public Employee(int id, String nameOfEmployee, String department, double salary) {
        this.id = id;
        this.nameOfEmployee = nameOfEmployee;
        this.department = department;
        this.salary = salary;
    }

    //Create a getter method getId to return id
    public int getId() {
        return id;
    }

    //Create a getter method getNameOfEmployee to return name of employee
    public String getNameOfEmployee() {
        return nameOfEmployee;
    }

    //Create a getter method getDepartment to return department
    public String getDepartment() {
        return department;
    }

    //Create a getter method getSalary to return salary
    public double getSalary() {
        return salary;
    }

    //Create a method to return employee details
    public void displayEmployeeDetails(){
        System.out.println("Employee Name: "+nameOfEmployee+" Employee Id: "+id+" Department: "+department+" Salary: "+salary);
    }

    //Create a static method serializeEmployee to perform serialize
    public static void serializeEmployee(List<Employee> employeeList,String filePath){
        try {
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeObject(employeeList);
            System.out.println("Employee are serialized to the file: "+filePath);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    //Create a static method deserializeEmployee to perform serialize
    public static List<Employee> deserializeEmployee(String filePath){
        try {
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(filePath));
            List<Employee> employeeList=(List<Employee>)ois.readObject();
            System.out.println("Employee are deserialized from the file: "+filePath);
            return employeeList;
        }catch (IOException |ClassNotFoundException ex){
            ex.printStackTrace();
            return null;
        }
    }
}

//Create a method SerializationSaveAndRetrieveAnObject to use Employee class
public class SerializationSaveAndRetrieveAnObject {
    public static void main(String[] args) {
        //Create a variable string to store file path
        String filePath="C:\\Week-04\\Day-03-JavaStreams\\src\\main\\java\\com\\day03\\javastream\\employee.txt";
        //Create a List to store particular employee object
        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(new Employee(1,"Rohan","Data Science",50000));
        employeeList.add(new Employee(2,"Muskan","Web Developer",70000));
        employeeList.add(new Employee(3,"Sonam","Software Engineer",90000));

        //print employee details
        System.out.println("Employee Data is: ");
        for(Employee employee:employeeList){
            employee.displayEmployeeDetails();
        }
        System.out.println(); //next line
        //call the method serializeEmployee
        Employee.serializeEmployee(employeeList,filePath);

        //call the method deserializeEmployee
        List<Employee> deserializeEmployeeList=Employee.deserializeEmployee(filePath);
        System.out.println(); //next line

        //print employee data after serializeEmployee
        if(deserializeEmployeeList!=null){
            for(Employee employee:deserializeEmployeeList){
                employee.displayEmployeeDetails();
            }
        }

    }
}
