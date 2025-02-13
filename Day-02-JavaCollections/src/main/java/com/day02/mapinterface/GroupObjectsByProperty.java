package com.day02.mapinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//Create a employee class to define employee details
class Employee {
    //Create a variable name and department to store name and department of the employee
    private String name;
    private String department;

    //Create a constructor to initialize employee details
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    //Create a method getName to return name of the employee
    public String getName() {
        return name;
    }

    //Create a method getDepartment to return name of the department
    public String getDepartment() {
        return department;
    }

    public String toString(){
        return name;
    }

    //Create a static method groupObjectByDepartment to make group of employee by department
    public static Map<String, List<Employee>> groupObjectByDepartment(List<Employee>employees){
        Map<String,List<Employee>> employeesDepartment=new HashMap<>();
        for(Employee employee: employees){
            String department=employee.getDepartment();
           if(employeesDepartment.containsKey(department))
               employeesDepartment.get(department).add(employee);
           else{
               List<Employee> employeeList=new ArrayList<>();
               employeeList.add(employee);
               employeesDepartment.put(department,employeeList);
           }
    }
        //return group of object department
      return employeesDepartment;

}
}

//Create a class GroupObjectsByProperty to use Employee class
public class GroupObjectsByProperty {
    public static void main(String[] args) {
        // Create an ArrayList object to store employee details
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));
        //Create a map interface
        Map<String,List<Employee>> employeesDepartment=Employee.groupObjectByDepartment(employees);

        //Use for each loop to print the details of the department
        for(Map.Entry<String,List<Employee>> entry:employeesDepartment.entrySet()){
            System.out.println(entry.getKey()+" = "+entry.getValue());
        }
    }
}
