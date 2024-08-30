package Utils;

import Model.Bank;
import java.io.*;
import java.util.Map;

public class BankUtils {

    private static final String FILE_NAME = "accounts.txt";

    public static void saveAccounts() {
        Bank bank = Bank.getInstance();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Map.Entry<String, Account> entry : bank.getAccounts().entrySet()) {
                Account account = entry.getValue();
                writer.write(account.getAccountNumber() + "," +
                            account.getName() + "," +
                            account.getPhoneNumber() + "," +
                            account.getNationalID() + "," +
                            account.getAddress() + "," +
                            account.getBalance());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadAccounts() {
        Bank bank = Bank.getInstance();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
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
                    account.setBalance(balance);
                    bank.getAccounts().put(accountNumber, account);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
