package com.day05.javajunit;

//Create a class StringUtility to perform operation on string
class StringUtility{
    //Create a static method reverse to reverse a given string
    public static String reverse(String str) {
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }

    // Create a static method isPalindrome to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        String reversed = reverse(str);
        return str.equals(reversed);
    }

    // Create a static method toUpperCase to convert a string to uppercase
    public static String toUpperCase(String str) {
        if (str == null) return null;
        return str.toUpperCase();
    }
}

//create a class StringUtilityMethods to use StringUtility class
public class StringUtilityMethods extends StringUtility {
    public static void main(String[] args) {
        //call the method toUpperCase
        String uppercase=StringUtility.toUpperCase("mohit");
        System.out.println("String in uppercase: "+uppercase);

        //call the method reverse
        String reverseString=StringUtility.reverse("mohit");
        System.out.println("String in reverse: "+reverseString);

        //call the method isPalindrome
        boolean palindromeResult=StringUtility.isPalindrome("kanak");
        System.out.println("String in palindrome: "+palindromeResult);
    }
}
