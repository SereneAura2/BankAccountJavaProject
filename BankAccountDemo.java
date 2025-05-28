/*
 * @author: Rhamseys Garcia Ashton Pleickhardt
 * @date: 2025-05-23
 * @description: This class contains the main method to test the BankAccount functionality
 */
/**
 * Demo class to test the BankAccount functionality
 */
public class BankAccountDemo {
    public static void main(String[] args) {
        // Create three bank accounts
        BankAccount AdamsAcc = new BankAccount(); // Default constructor
        BankAccount SamsAcc = new BankAccount(1000.0, "Sam", 'S');
        BankAccount LeilasAcc = new BankAccount(2000.0, "Leila", 'S'); 
        
        // Display initial account information
        System.out.println("Initial Account Information:");
        AdamsAcc.displayAccountInfo();
        SamsAcc.displayAccountInfo();
        LeilasAcc.displayAccountInfo();

        // Test deposit method
        System.out.println("\nTesting deposit method:");
        AdamsAcc.deposit(500.0);
        AdamsAcc.displayAccountInfo();

        // Test withdraw method
        System.out.println("\nTesting withdraw method:");
        AdamsAcc.withdraw(200.0);
        AdamsAcc.displayAccountInfo();

        // Test transfer method
        System.out.println("\nTesting transfer method:");
        SamsAcc.transfer(LeilasAcc, 300.0);
        System.out.println("After transfer:");
        SamsAcc.displayAccountInfo();
        LeilasAcc.displayAccountInfo();

        // Test addInterest method
        System.out.println("\nTesting addInterest method:");
        System.out.println("Before adding interest:");
        SamsAcc.displayAccountInfo();
        LeilasAcc.displayAccountInfo();

        SamsAcc.addInterest();
        LeilasAcc.addInterest();

        System.out.println("\nAfter adding interest:");
        SamsAcc.displayAccountInfo();
        LeilasAcc.displayAccountInfo();

        // Test exception handling for insufficient funds
        System.out.println("\nTesting exception handling for insufficient funds:");
        try {
            AdamsAcc.withdraw(1000.0); // This should throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        try {
            SamsAcc.transfer(LeilasAcc, 2000.0); // This should throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Test getter and setter methods
        System.out.println("\nTesting getter and setter methods:");
        AdamsAcc.setName("Adam Smith");
        AdamsAcc.setInterestRate(4.0);
        System.out.println("Updated account information:");
        AdamsAcc.displayAccountInfo();
    }
} 