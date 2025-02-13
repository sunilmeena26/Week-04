package com.day02.mapinterface;

import java.time.LocalDate;
import java.util.*;

// Create a class InsurancePolicy to build a system for managing insurance policies
class InsurancePolicy {
    //Create a variable policyNumber, policyHolderName, and expiryDate to store policy details
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;

    //Create a constructor to initializing policy details.
    public InsurancePolicy(String policyNumber, String policyHolderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
    }

    // Create a getter method getPolicyNumber to return policy number.
    public String getPolicyNumber() {
        return policyNumber;
    }

    // Create a getter method policyHolderName to return policy holder name.
    public String getPolicyHolderName() {
        return policyHolderName;
    }

    // Create a getter method getExpiryDate to return expiry data of policy
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    //Create a methods toString to override it
    public String toString() {
        return "Policy[" + policyNumber + ", Holder: " + policyHolderName + ", Expiry: " + expiryDate + "]";
    }
}

// Create a class InsurancePolicyManager to manage policy
class InsurancePolicyManager {
    //Create an object of HAhsMap to stores policies by policy number
    private Map<String, InsurancePolicy> policyMap = new HashMap<>();
    //Create an object of LinkedHashMap method  to maintains insertion order
    private Map<String, InsurancePolicy> orderedPolicyMap = new LinkedHashMap<>();

    //Create a method sortedPolicy to sorts policies by expiry date
    private Map<LocalDate, InsurancePolicy> sortedPolicyMap = new TreeMap<>();

    // Method to add a new policy
    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        orderedPolicyMap.put(policy.getPolicyNumber(), policy);
        sortedPolicyMap.put(policy.getExpiryDate(), policy);
    }

    // Create a method getPolicyByNumber to retrieving a policy by its number.
    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // Create a method getPoliciesExpiringSoon to get for getting policies expiring within the next 'days' days.
    public List<InsurancePolicy> getPoliciesExpiringSoon(int days) {
        LocalDate threshold = LocalDate.now().plusDays(days);
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();

        for (Map.Entry<LocalDate, InsurancePolicy> entry : sortedPolicyMap.entrySet()) {
            if (!entry.getKey().isAfter(threshold)) {
                expiringPolicies.add(entry.getValue());
            } else {
                break;
            }
        }
        return expiringPolicies;
    }

    // Create a method getPoliciesByHolder to retrieving policies by policyholder's name.
    public List<InsurancePolicy> getPoliciesByHolder(String policyHolder) {
        List<InsurancePolicy> policies = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.getPolicyHolderName().equalsIgnoreCase(policyHolder)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    //Create a method removeExpiredPolicies for removing expired policies.
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, InsurancePolicy>> iterator = sortedPolicyMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<LocalDate, InsurancePolicy> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                policyMap.remove(entry.getValue().getPolicyNumber());
                orderedPolicyMap.remove(entry.getValue().getPolicyNumber());
                iterator.remove();
            } else {
                break;
            }
        }
    }

    //Create a method for displaying all policies in insertion order.
    public void displayAllPolicies() {
        for (InsurancePolicy policy : orderedPolicyMap.values()) {
            System.out.println(policy);
        }
    }
}

//Create a class InsurancePolicyManagementSystem to use InsurancePolicy class
public class InsurancePolicyManagementSystem {
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        // Adding elements policies to the manager.
        manager.addPolicy(new InsurancePolicy("P1001", "Ram", LocalDate.of(2025, 3, 15))); // Policies for Ram.
        manager.addPolicy(new InsurancePolicy("P1002", "Shyam", LocalDate.of(2024, 2, 28))); // Policies for Shyam.
        manager.addPolicy(new InsurancePolicy("P1003", "Radha", LocalDate.of(2024, 3, 5))); // Policies for Radha.

        // Displaying policies expiring within 30 days.
        System.out.println("Policies expiring within 30 days:");
        System.out.println(manager.getPoliciesExpiringSoon(30));

        // Displaying policies for a Ram.
        System.out.println("Policies for Ram:");
        System.out.println(manager.getPoliciesByHolder("Ram"));

        //Now, Remove expired policies
        System.out.println("Removing expired policies...");
        manager.removeExpiredPolicies();

        // Display all remaining policies
        System.out.println("All Policies:");
        manager.displayAllPolicies();
    }
}
