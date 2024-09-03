package Model;

import java.io.Serializable;

public class Account implements Serializable {
    private String accountNumber;
    private String name;
    private String phoneNumber;
    private String nationalID;
    private String address;
    private double balance;

    public Account(String accountNumber, String name, String phoneNumber, String nationalID, String address) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nationalID = nationalID;
        this.address = address;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getNationalID() {
        return nationalID;
    }

    public String getAddress() {
        return address;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
