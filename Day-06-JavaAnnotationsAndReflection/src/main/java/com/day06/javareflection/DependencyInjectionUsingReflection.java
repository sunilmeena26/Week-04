package com.day06.javareflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Create an interface of Inject and make the annotation available at runtime
@Retention(RetentionPolicy.RUNTIME) 
@interface Inject {
}

//Create a class DependencyInjectionContainer class 
class DependencyInjectionContainer {
    //Create a private Map
    private Map<Class<?>, Object> instances = new HashMap<>();

    //Create a registerInstance method to register an instance in the container
    public void registerInstance(Object instance) {
        instances.put(instance.getClass(), instance);
    }

    //Create a injectDependencies method to inject dependencies into the target object
    public void injectDependencies(Object target) throws IllegalAccessException {
        Field[] fields = target.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();
                Object dependency = instances.get(fieldType);
                if (dependency != null) {
                    // Allow access to private fields
                    field.setAccessible(true); 
                    field.set(target, dependency);
                }
            }
        }
    }
}

// Create a class Service to be injected
class Service {
    
    //Create a method serve
    public void serve() {
        System.out.println("Service is serving...");
    }
}

//Create a class Client with a dependency on Service
class Client {
    
    // Dependency to be injected
    @Inject
    private Service service; 

    //Create a method doSomething
    public void doSomething() {
        service.serve();
    }
}

//Create a method DependencyInjectionUsingReflection class to use DependencyInjectionContainer class
public class DependencyInjectionUsingReflection {
    public static void main(String[] args) {
        //Use try-catch block to handle the exception
        try {
            // Create an object of Service and Client class
            Service service = new Service();
            Client client = new Client();

            // Create an object of DependencyInjectionContainer class
            DependencyInjectionContainer DependencyInjectionContainer = new DependencyInjectionContainer();

            //call the method registerInstance to register the Service instance in the DI container
            DependencyInjectionContainer.registerInstance(service);

            //call the method injectDependencies to inject dependencies into the Client instance
            DependencyInjectionContainer.injectDependencies(client);

            // Call the method on the Client instance
            client.doSomething();

        }
        //Use catch block to handle the exception
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
