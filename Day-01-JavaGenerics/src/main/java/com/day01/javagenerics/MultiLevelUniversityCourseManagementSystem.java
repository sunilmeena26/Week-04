package com.day01.javagenerics;

import java.util.List;
import java.util.ArrayList;

//Create an abstract class CourseType to representing a course type
abstract class CourseType {
    //Create a variable courseName to store course name
    private String courseName;

    //Create a constructor to initialize course name
    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    //Create a getter method to return course name
    public String getCourseName() {
        return courseName;
    }

    //Create an abstract method getCourseType to return type of course
    public abstract void getCourseType();

}

// Create a class ExamCourse to representing exam Course
class ExamCourse extends CourseType {

    //Create a constructor to initialize exam course name
    public ExamCourse(String courseName) {
        super(courseName);
    }

    //Create a method getCourseType to override a method getCourseType
    public void getCourseType() {
        System.out.println("Exam Courses are : ");
    }
}

// Create a class AssignmentCourse to representing  assignment course type
class AssignmentCourse extends CourseType {

    //Create a constructor to initialize assignment course name
    public AssignmentCourse(String courseName) {
        super(courseName);
    }

    //Create a method getCourseType to override a method getCourseType
    public void getCourseType() {
        System.out.println("Assignment Courses are : ");
    }

}

// Create a class ResearchCourse to representing ResearchCourse
class ResearchCourse extends CourseType {

    //Create a constructor to initialize research course name
    public ResearchCourse(String courseName) {
        super(courseName);
    }

    //Create a method getCourseType to override a method getCourseType
    public void getCourseType() {
        System.out.println("Research Courses Are: ");
    }

}

// Create a Generic Course class to store CourseTypes
class Course<T extends CourseType> {
    //Create a reference of the list interface
    List<T> courses;

    //Create a constructor to initialize list
    public Course() {
        //Create an object of ArrayList class
        courses = new ArrayList<>();
    }

    //Create a method addCourse to add course in list
    public void addCourse(T course) {
        courses.add(course);
    }

    //Create a method removeCourse to remove course from list
    public void removeCourse(T course) {
        courses.remove(course);
    }

    //Create a method to displayCourseDetails to display all courses details as name
    public static void displayCourseDetails(List<? extends CourseType>courses) {
        courses.getFirst().getCourseType();
        for (CourseType course : courses) {
            System.out.printf("%-10s\n",course.getCourseName());
        }
        System.out.println();
    }

}

//Create a class MultiLevelUniversityCourseManagementSystem to use Course,ExamCourse,AssignmentCourse,and ResearchCourse class
public class MultiLevelUniversityCourseManagementSystem {
    public static void main(String[] args) {

        //Create an object of Course class for storing ExamCourse type course
        Course<ExamCourse> examCourse = new Course<>();
        //Call the method addCourse to adding courses to Course
        examCourse.addCourse(new ExamCourse("JEE Mains"));
        examCourse.addCourse(new ExamCourse("NEET UG"));
        // display course details
        Course.displayCourseDetails(examCourse.courses);

        //Create an object of Course class for storing AssignmentCourse type course
        Course<AssignmentCourse> assignmentCourse = new Course<>();
        //Call the method addCourse to adding courses to Course
        assignmentCourse.addCourse(new AssignmentCourse("Development Communication"));
        assignmentCourse.addCourse(new AssignmentCourse("Community Media"));
        // display course details
        Course.displayCourseDetails(assignmentCourse.courses);

        //Create an object of Course class for storing ResearchCourse type course
        Course<ResearchCourse> researchCourse = new Course<>();
        //Call the method addCourse to adding courses to Course
        researchCourse.addCourse(new ResearchCourse("Qualitative Research"));
        researchCourse.addCourse(new ResearchCourse("Data Analysis"));
        // display course details
        Course.displayCourseDetails(researchCourse.courses);
    }
}

