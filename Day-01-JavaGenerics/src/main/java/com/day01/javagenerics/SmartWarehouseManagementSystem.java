package com.day01.javagenerics;

import java.util.List;
import java.util.ArrayList;

// Create an abstract class to representing a Warehouse Item
abstract class WarehouseItem {
    //Create a variable itemName to store item name
    private String itemName;

    //Create a constructor to initialize item name
    public WarehouseItem(String itemName) {
        this.itemName = itemName;
    }

    //Create a getter method to return item name
    public String getItemName() {
        return itemName;
    }

    //Create an abstract method getItemPrice and getItem to return item price and about item
    public abstract int getItemPrice();
    public abstract void getItem();
    
}

// Create a class Electronics to representing Electronics
class Electronics extends WarehouseItem {
    // Create a variable itemPrice to store electronic item price
    private int itemPrice;

    //Create a constructor to initialize electronic name and price
    public Electronics(String itemName, int itemPrice) {
        super(itemName);
        this.itemPrice = itemPrice;
    }

    //Create a method getItemPrice to override a method getItemPrice
    public int getItemPrice() {
        return itemPrice;
    }

    //Create a method getItem to override a method getItem
    public void getItem() {
        System.out.println("Electronics Item: ");
    }
}

// Create a class Groceries to representing Groceries
class Groceries extends WarehouseItem {
    // Create a variable itemPrice to store groceries item price
    private int itemPrice;

    //Create a constructor to initialize groceries item name and price
    public Groceries(String itemName, int itemPrice) {
        super(itemName);
        this.itemPrice = itemPrice;
    }

    //Create a method getItemPrice to override a method getItemPrice
    public int getItemPrice() {
        return itemPrice;
    }

    //Create a method getItem to override a method getItem
    public void getItem() {
        System.out.println("Groceries Item: ");
    }
    
}

// Create a class Furniture to representing Furniture
class Furniture extends WarehouseItem {
    // Create a variable itemPrice to store furniture item price
    private int itemPrice;

    //Create a constructor to initialize furniture name and price
    public Furniture(String itemName, int itemPrice) {
        super(itemName);
        this.itemPrice = itemPrice;
    }

    //Create a method getItemPrice to override a method getItemPrice
    public int getItemPrice() {
        return itemPrice;
    }

    //Create a method getItem to override a method getItem
    public void getItem() {
        System.out.println("Furniture Item: ");
    }
    
}

// Create a Generic Storage class to store WarehouseItems
class Storage<T extends WarehouseItem> {
    //Create a reference of the list interface
     List<T> items;

    //Create a constructor to initialize list
    public Storage() {
        //Create an object of ArrayList class
        items = new ArrayList<>();
    }

    //Create a method addItem to add item in list
    public void addItem(T item) {
        items.add(item);
    }

    //Create a method removeItem to remove item from list
    public void removeItem(T item) {
        items.remove(item);
    }

    //Create a method to displayItemDetails to display all items details as price and name
    public static void displayItemDetails(List<? extends WarehouseItem>items) {
        items.getFirst().getItem();
        System.out.printf("%-10s %s\n","Item Name","Item Price");
        for (WarehouseItem item : items) {
            System.out.printf("%-10s %d\n",item.getItemName(),item.getItemPrice());
        }
        System.out.println();
    }

}

//Create a class SmartWarehouseManagementSystem to use Storage,Electronics,Groceries,and Furniture class
public class SmartWarehouseManagementSystem {
    public static void main(String[] args) {

        //Create an object of Storage class for storing Electronics type item
        Storage<Electronics> electronicsStorage = new Storage<>();
        //Call the method addItem to adding items to Storage
        electronicsStorage.addItem(new Electronics("Laptop", 5000));
        electronicsStorage.addItem(new Electronics("TV", 500));
        // display item details
        Storage.displayItemDetails(electronicsStorage.items);

        //Create an object of Storage class for storing Groceries type item
        Storage<Groceries> groceriesStorage = new Storage<>();
        //Call the method addItem to adding items to Storage
        groceriesStorage.addItem(new Groceries("Apple", 500));
        groceriesStorage.addItem(new Groceries("Rice", 5000));
        // display item details
        Storage.displayItemDetails(groceriesStorage.items);

        //Create an object of Storage class for storing Furniture type item
        Storage<Furniture> furnitureStorage = new Storage<>();
        //Call the method addItem to adding items to Storage
        furnitureStorage.addItem(new Furniture("Chair", 500));
        furnitureStorage.addItem(new Furniture("Table", 1000));
        // display item details
         Storage.displayItemDetails(furnitureStorage.items);
    }
}


