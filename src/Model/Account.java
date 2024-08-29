package Model;

public class Accoount {
    private String name;
    private String phoneNumber;
    private String nationalID;
    private String address;
    private double balance;

    publicAccount(String name, String phoneNumber, String nationalID, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nationalID = nationalID;
        this.address = address;
        this.balance = 0.0;
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
    
    public getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if(balance .>= amount){
            balance -= amount;
            return true;
        }
        return false;
    }
}