package com.day06.javaannotations;


//Create class Animal
class Animal{

    //Create a method makeSound()
    void makeSound(){
        //Print the statement
        System.out.println("Animal Sounds....");
    }
}

//Create a class Dog which extends Animalsclass
class Dog extends Animal{

    @Override
        //Create a method and override it
    void makeSound(){
        //Print the statement
        System.out.println("Dog Sounds....");
    }
}

//Create a class UseOverrideCorrectly
public class UseOverrideCorrectly{
    public static void main(String[] args) {

        //Create an object of Dog Class
        Dog tommy = new Dog();

        //Call the method
        tommy.makeSound();
    }
}
