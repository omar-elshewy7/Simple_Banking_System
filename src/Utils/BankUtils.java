package Utils;

import Model.Account;
import Model.Bank;

import java.io.*;
import java.util.Map;

public class BankUtils {
    private static final String FILE_NAME = "accounts.txt";

    public static void saveAccounts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            Bank bank = Bank.getInstance();
            for (Map.Entry<String, Account> entry : bank.getAccounts().entrySet()) {
                Account account = entry.getValue();
                writer.write(String.join(",",
                        account.getAccountNumber(),
                        account.getName(),
                        account.getPhoneNumber(),
                        account.getNationalID(),
                        account.getAddress(),
                        Double.toString(account.getBalance())));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadAccounts() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            Bank bank = Bank.getInstance();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String accountNumber = parts[0];
                    String name = parts[1];
                    String phoneNumber = parts[2];
                    String nationalID = parts[3];
                    String address = parts[4];
                    double balance = Double.parseDouble(parts[5]);

                    Account account = new Account(accountNumber, name, phoneNumber, nationalID, address);
                    account.deposit(balance); // Set the initial balance
                    bank.getAccounts().put(accountNumber, account);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}