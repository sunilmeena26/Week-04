package com.day06.javareflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//Create a Interface Greeting
interface Greeting {
    //Create  a method seyHello without body
    void sayHello();
}

// Create a class GreetingImplementation to implement the Greeting interface
class GreetingImplementation implements Greeting {
    //Create a method sayHello to override it
    @Override
    public void sayHello() {
        System.out.println("Hello, World!");
    }
}

//Create a method LoggingHandler to handle method calls and implement InvocationHandler interface
class LoggingHandler implements InvocationHandler {
    //Create a final variable target to store a target
    private final Object target;

    //Create a constructor to initialize the target object
    public LoggingHandler(Object target) {
        this.target = target;
    }

    //Create a method invoke to override it
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Log the method name
        System.out.println("Invoking method: " + method.getName());

        // Execute the actual method on the target object
        return method.invoke(target, args);
    }

    //Create a method createProxy to create a proxy instance
    public static Object createProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new LoggingHandler(target)
        );
    }
}

//Create a class CustomLoggingProxyUsingReflection class to test the logging proxy and use Greeting
public class CustomLoggingProxyUsingReflection {
    public static void main(String[] args) {
        // Create an instance of Greeting and object GreetingImplementation class
        Greeting greeting = new GreetingImplementation();

        // Create a proxy for the greeting object and convert the proxy in Greeting
        Greeting proxy = (Greeting) LoggingHandler.createProxy(greeting);

        // Call the sayHello method
        proxy.sayHello();
    }
}
