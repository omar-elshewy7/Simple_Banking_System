package Model;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private static Bank instance;
    private Map<String,Account> accounts;

    private Bank() {
        accounts = new HashMap<>();
    }
    
    public static Bank getInstance() {
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }

    public void createAccount(String name, String phoneNumber, String nationalID, String address) {
        accounts.put(name, new Account(name, phoneNumber, nationalID, address))
    }

    public Account getAccount(String name) {
        return accounts.get(name);
    }
}