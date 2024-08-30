package GUI;

import javax.swing.*;
import Model.Bank;
import Model.Account;

public class BalanceForm extends JFrame {
    private JTextField accountNumberField;
    public BalanceForm() {
        setTitle("Check Balance");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        accountNumberField = new JTextField(20);

        panel.add(new JLabel("Account Number:"));
        panel.add(accountNumberField);

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.addActionListener(e -> checkBalance());

        panel.add(checkBalanceButton);
        add(panel);

        setVisible(true);
    }

    private void checkBalance() {
        String accountNumber = accountNumberField.getText();

        Bank bank = Bank.getInstance();
        Account account = bank.getAccount(accountNumber);

        if (account != null) {
            JOptionPane.showMessageDialog(this, "Balance: " + account.getBalance());
        } else {
            JOptionPane.showMessageDialog(this, "Account not found!");
        }

        dispose();
    }
}