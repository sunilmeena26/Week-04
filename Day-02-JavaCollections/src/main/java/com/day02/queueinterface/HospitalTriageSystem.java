package com.day02.queueinterface;

import java.util.Comparator;
import java.util.PriorityQueue;

//Create a class Patients to define patient details
class Patients{
    //Create a variable patientName and severity to store patient Name and severity
    String patientName;
    int severity;

    //Create a constructor to initialize patient details
    public Patients(String patientName, int severity) {
        this.patientName = patientName;
        this.severity = severity;
    }
}

//Create a class HospitalTriageSystem to use Patient class
public class HospitalTriageSystem {
    public static void main(String[] args) {
        //Create an object of PriorityQueue
        PriorityQueue<Patients> triage=new PriorityQueue<>(new Comparator<Patients>() {
            @Override
            public int compare(Patients p1, Patients p2) {
                return Integer.compare(p2.severity,p1.severity);
            }
        });

        //add patient details in priority queue
        triage.add(new Patients("John",3));
        triage.add(new Patients("Alice",5));
        triage.add(new Patients("Bob",2));

        //print the patients details based on severity
        while(!(triage.isEmpty())){
            Patients patients=triage.poll();
            System.out.println("Treated Patient is: "+patients.patientName+" with severity: "+patients.severity);
        }
    }
}
