package com.day06.javaunittesting;

import com.day05.javajunit.UserRegistration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Create a class UserRegistrationTesting to test user registration
public class UserRegistrationTesting {
    @Test
        //Create a method to perform test registered user
    void registerUserTest(){
        //Create an object of UserRegistration
        UserRegistration user1 = new UserRegistration();

        //Call the method to check the method which does not throw exception
        assertDoesNotThrow(() -> user1.registerUser("anchal_sahu", "xyz5@gmail.com", "Xyz@1234"));

        //Call the method to check exception
        assertThrows(IllegalArgumentException.class, () -> user1.registerUser("Abc_sdhfi", "emailaddress", "password123"));
    }
}
