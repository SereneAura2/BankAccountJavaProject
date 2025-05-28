/*
 * @author: Rhamseys Garcia Ashton Pleickhardt
 * @date: 2025-05-23
 * @description: This class contains the BankAccount class with various operations
 */
/**
 * BankAccount class representing a bank account with various operations
 */
public class BankAccount {
    private double balance;
    private String accName;
    private int accNum;
    private char accountType;
    private double interestRate;
    private static int lastAccNum = 0;

    /**
     * Default constructor initializing a new bank account
     */
    public BankAccount() {
        this.balance = 0.0;
        this.accName = "Unknown";
        this.accountType = 'C';
        this.interestRate = 3.0;
        lastAccNum++;
        this.accNum = lastAccNum;
    }

    /**
     * Overloaded constructor initializing a new bank account with specific values
     * @param balance Initial balance
     * @param accName Account holder name
     * @param accountType Account type (C for Checking, S for Savings)
     */
    public BankAccount(double balance, String accName, char accountType) {
        this.balance = balance;
        this.accName = accName;
        this.accountType = accountType;
        this.interestRate = 3.0;
        lastAccNum++;
        this.accNum = lastAccNum;
    }

    /**
     * Sets the account balance
     * @param balance New balance amount
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Sets the account holder name
     * @param accName New account holder name
     */
    public void setName(String accName) {
        this.accName = accName;
    }

    /**
     * Sets the account type
     * @param accountType New account type (C for Checking, S for Savings)
     */
    public void setAccountType(char accountType) {
        this.accountType = accountType;
    }

    /**
     * Sets the interest rate
     * @param interestRate New interest rate
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * Gets the current balance
     * @return Current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Gets the account holder name
     * @return Account holder name
     */
    public String getName() {
        return accName;
    }

    /**
     * Gets the account type
     * @return Account type
     */
    public char getAccountType() {
        return accountType;
    }

    /**
     * Gets the interest rate
     * @return Interest rate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Gets the account number
     * @return Account number
     */
    public int getAccNum() {
        return accNum;
    }

    /**
     * Withdraws money from the account
     * @param amount Amount to withdraw
     * @throws IllegalArgumentException if amount exceeds balance
     */
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("insufficient funds");
        }
        balance -= amount;
    }

    /**
     * Deposits money into the account
     * @param amount Amount to deposit
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Transfers money from this account to another account
     * @param otherAccount Target account for transfer
     * @param amount Amount to transfer
     * @throws IllegalArgumentException if amount exceeds balance
     */
    public void transfer(BankAccount otherAccount, double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("insufficient funds");
        }
        this.withdraw(amount);
        otherAccount.deposit(amount);
    }

    /**
     * Displays account information
     */
    public void displayAccountInfo() {
        System.out.println("Account Information:");
        System.out.println("Name: " + accName);
        System.out.println("Account Number: " + accNum);
        System.out.println("Account Type: " + (accountType == 'C' ? "Checking" : "Savings"));
        System.out.println("Balance: $" + String.format("%.2f", balance));
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("------------------------");
    }

    /**
     * Adds interest to the account balance (only for savings accounts)
     */
    public void addInterest() {
        if (accountType == 'S') {
            double interest = Financial.percentOf(interestRate, balance);
            balance += interest;
        }
    }
} 