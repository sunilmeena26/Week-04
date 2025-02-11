package com.day01.javagenerics;

import java.util.*;

//Create an abstract class JobRole to define details about job roles
abstract class JobRole{
    //Create a private variable nameOfCandidate and jobRole to store the candidate name and job role
    private String nameOfCandidate;
    private String jobRole;

    //Create a parameterized constructor to initialize candidate details
    public JobRole(String jobRole, String nameOfCandidate) {
        this.jobRole = jobRole;
        this.nameOfCandidate = nameOfCandidate;
    }

    //Create a getter method getnameOfCandidate to get the candidate name
    public String getnameOfCandidate() {
        return nameOfCandidate;
    }

    //Create a getter method getJobRole to get the job role
    public String getJobRole() {
        return jobRole;
    }

    //Create an abstract method resumeProcess
    abstract void resumeProcess();
}

//Create a class SoftwareEngineer to extends JobRole class
class SoftwareEngineer extends JobRole{
    //Create a parameterized constructor to initialize details about software engineer
    public SoftwareEngineer(String nameOfCandidate) {
        super("Software Engineer", nameOfCandidate);
    }

    //Create a method resumeProcess and override resumeProcess
    void resumeProcess(){
        System.out.println("Resume Processing For Software Engineer Job Role");
    }

}

//Create a class DataScientist which extends JobRole class
class DataScientist extends JobRole{
    //Create a parameterized constructor to initialize details about data scientist
    public DataScientist(String nameOfCandidate) {
        super("Data Scientist", nameOfCandidate);
    }

    //Create a method resumeProcess and override resumeProcess
    void resumeProcess(){
        System.out.println("Resume Processing For Data Scientist Job Role");
    }

}

//Create a class ProductManager which extends JobRole class
class ProductManager extends JobRole{
    //Create a parameterized constructor to initialize details about product manager
    public ProductManager(String nameOfCandidate) {
        super("Product Manager", nameOfCandidate);
    }

    //Create a method resumeProcess and override resumeProcess
    void resumeProcess(){
        System.out.println("Resume Processing For Product Manager Job Role");
    }
}
//Create a generic class Resume to store details
class Resume<T extends JobRole>{
    //Create a variable of T type
    T role;

    //Create  a parameterized constructor to initialize resume
    public Resume(T role) {
        this.role = role;
    }

    //Create a static generic method resumeScreening to screening screen
    public static void resumeScreening(List<? extends JobRole> resumes) {
        //Print the result
        for (JobRole resume : resumes) {
            System.out.println("Screening resume for: " + resume.getnameOfCandidate());
        }
    }
}

//Create a class AIDrivenResumeScreeningSystem to use SoftwareEngineer,DataScientist,ProductManager, and Resume class
public class AIDrivenResumeScreeningSystem {
    public static void main(String[] args) {

        //Create an object of Resume class and pass the SoftwareEngineer class as parameter
        Resume<SoftwareEngineer> softwareEngineerResume = new Resume<>(new SoftwareEngineer("Gopal Raj"));
        //Call the method to print the resume status
        softwareEngineerResume.role.resumeProcess();

        //Create an object of Resume class and pass the DataScientist class as parameter
        Resume<DataScientist>  dataScientistResume = new Resume<>(new DataScientist("Mohit Verma"));
        //Call the method resumeProcess and print the status
        dataScientistResume.role.resumeProcess();

        //Create an object of Resume class and pass the ProductManager class as parameter
        Resume<ProductManager> productManagerResume = new Resume<>(new ProductManager("Rohit Sharma"));
        //Call the method resumeProcess and print the status
        productManagerResume.role.resumeProcess();

        //Create a list of JobRole type
        List<JobRole> list = new ArrayList<>();
        //Add the element in list
        list.add(new SoftwareEngineer("Raj"));
        list.add(new DataScientist("Rajat"));
        list.add(new ProductManager("Karan"));

        //Call the resumeScreening method
        Resume.resumeScreening(list);

    }
}
