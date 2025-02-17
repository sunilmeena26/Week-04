package com.day06.javaannotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Use the Annotation
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
//Create a TaskInfo Annotation
@interface TaskInfo {
    String priority() default "High";
    String assignedTo() default "Alok";
}
