package com.day01.javagenerics;


// Create a abstract class Product to define product details
abstract class Product<T> {
    //Create a variable nameOfProduct,priceOfProduct, and categoryOfProduct to store name, price, and category of the product
    private String nameOfProduct;
    private double priceOfProduct;
    private T categoryOfProduct;

    //Create a constructor to initialize product details as name,price and category
    public Product(String nameOfProduct, double priceOfProduct, T categoryOfProduct) {
        this.nameOfProduct = nameOfProduct;
        this.priceOfProduct = priceOfProduct;
        this.categoryOfProduct = categoryOfProduct;
    }

    //Create a getter method getNameOfProduct to return name of the product
    public String getNameOfProduct() {
        return nameOfProduct;
    }

    //Create a getter method getPriceOfProduct to return price of the product
    public double getPriceOfProduct() {
        return priceOfProduct;
    }

    //Create a getter method getCategoryOfProduct to return category of the product
    public T getCategoryOfProduct() {
        return categoryOfProduct;
    }

    //Create a getter method setPriceOfProduct to initialize the price of the product
    public void setPriceOfProduct(double priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }

    //Create a method displayProductDetails to display the product details
    public void displayProductDetails() {
        System.out.println("Product Name : \""+nameOfProduct+"\" Price : \"₹"+priceOfProduct+"\" Category: \""+categoryOfProduct+"\"");
    }
}

// Create a class Book to extends the Product class
class Book extends Product<String> {
    //Create a parametrized constructor to initialize book details
    public Book(String nameOfProduct, double priceOfProduct, String categoryOfProduct) {
        super(nameOfProduct, priceOfProduct, categoryOfProduct);
    }
}

// Create a class Clothing to extends the Product class
class Clothing extends Product<String> {
    //Create a parametrized constructor to initialize cloth details
    public Clothing(String nameOfProduct, double priceOfProduct, String categoryOfProduct) {
        super(nameOfProduct, priceOfProduct, categoryOfProduct);
    }
}

// Create a class Gadget to extends the Product class
class Gadget extends Product<String> {
    //Create a parametrized constructor to initialize gadget details
    public Gadget(String nameOfProduct, double priceOfProduct, String categoryOfProduct) {
        super(nameOfProduct, priceOfProduct, categoryOfProduct);
    }
}

// Create a class DiscountManager to apply discount on the product
class DiscountManager {
    //Create a static generic method to apply discounts dynamically
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountedpriceOfProduct = product.getPriceOfProduct() - (product.getPriceOfProduct() * percentage / 100);
        product.setPriceOfProduct(discountedpriceOfProduct);
        product.displayProductDetails();
    }
}

//Create a class DynamicOnlineMarketplace to use Book,Clothing, and Gadget class
public class DynamicOnlineMarketplace {
    public static void main(String[] args) {
        //Create an object of Book class and pass argument as book details
        Book book = new Book("The Complete Reference", 2500, "Java");
        //Create an object of Clothing class and pass argument as cloth details
        Clothing clothing = new Clothing("T-Shirt", 1500, "Men");
        //Create an object of Gadget class and pass argument as gadget details
        Gadget gadget = new Gadget("Smartphone", 16500, "Mobile");

        //Print details with original price
        System.out.println("Original Price:");
        book.displayProductDetails();
        clothing.displayProductDetails();
        gadget.displayProductDetails();

        //print price details with discounted price
        System.out.println("\n10% Discount applied: " );
        DiscountManager.applyDiscount(book, 10);
        DiscountManager.applyDiscount(clothing, 20);
        DiscountManager.applyDiscount(gadget, 15);

    }
}
