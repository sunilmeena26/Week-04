package com.day01.javagenerics;

//Create an interface MealPlan
interface MealPlan{
    //Create a abstract method mealType
    void mealType();
}

//Create a class VegetarianMeal to implements MealPlan interface
class VegetarianMeal implements MealPlan{
    //Create a method mealType and override mealType
    public void mealType() {
        System.out.println("Vegetarian Meal");
    }
}

//Create a class VeganMeal to implements MealPlan interface
class VeganMeal implements MealPlan{

    //Create a method mealType and override mealType
    public void mealType() {
        System.out.println("Vegan Meal");
    }
}

//Create a class KetoMeal to implements MealPlan interface
class KetoMeal implements MealPlan{

    //Create a method mealType and override mealType
    public void mealType() {
        System.out.println("Keto Meal");
    }
}

//Create a class HighProteinMeal to implements MealPlan interface
class HighProteinMeal implements MealPlan{
    //Create a method mealType and override mealType
    public void mealType() {
        System.out.println("High Protein Meal");
    }
}

//Create a generic class Meal to store MealPlan interface
class Meal<T extends MealPlan>{
    //Create a variable meal of T type
    T meal;

    //Create a parameterized constructor to initialize what type of meal
    public Meal(T meal) {
        this.meal = meal;
    }

    //Create a static generic method generateMealPlan to generate meal plan
    public static <T extends  MealPlan> Meal<T> generateMealPlan(T data){
        return new Meal<>(data);
    }
}
//Create a class PersonalizedMealPlanGenerator to use VegetarianMeal,VeganMeal,KetoMeal, and HighProteinMeal
public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        //Create an object of Meal class and pass the Vegetarian class as parameter
        Meal<VegetarianMeal> vegetarianMeal = Meal.generateMealPlan(new VegetarianMeal());
        //Call the method mealType to get the type of meal
        vegetarianMeal.meal.mealType();

        //Create an object of Meal class and pass the VeganMeal class as parameter
        Meal<VeganMeal> veganMeal = Meal.generateMealPlan(new VeganMeal());
        //Call the method mealType to get the type of meal
        veganMeal.meal.mealType();

        //Create an object of Meal class and pass the KetoMeal class as parameter
        Meal<KetoMeal> ketoMeal = Meal.generateMealPlan(new KetoMeal());
        //Call the method mealType to get the type of meal
        ketoMeal.meal.mealType();

        //Create an object of Meal class and pass the HighProteinMeal class as parameter
        Meal<HighProteinMeal> highProteinMeal = Meal.generateMealPlan(new HighProteinMeal());
        //Call the method mealType to get the type of meal
        highProteinMeal.meal.mealType();
    }
}
