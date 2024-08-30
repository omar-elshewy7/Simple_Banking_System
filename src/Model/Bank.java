package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Bank {
    private Map<String, Account> accounts = new HashMap<>();
    private static Bank instance = new Bank();

    private Bank() {
        // accounts = new HashMap<>();
    }
    
    public static Bank getInstance() {
        // if (instance == null) {
        //     instance = new Bank();
        // }
        return instance;
    }

    public String createAccount(String name, String phoneNumber, String nationalID, String address) {
        String accountNumber = generateAccountNumber();
        Account newAccount = new Account(accountNumber, name, phoneNumber, nationalID, address);
        accounts.put(accountNumber, newAccount);
        return accountNumber;
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    private String generateAccountNumber() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}