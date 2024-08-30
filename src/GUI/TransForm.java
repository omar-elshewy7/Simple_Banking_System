package GUI;

import javax.swing.*;
import Model.Bank;
import Model.Account;

public class TransForm extends JFrame {
    private JTextField fromAccountNumberField;
    private JTextField toAccountNumberField;
    private JTextField amountField;

    public TransForm() {
        setTitle("Transfer Funds");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        fromAccountNumberField = new JTextField(20);
        toAccountNumberField = new JTextField(20);
        amountField = new JTextField(20);

        panel.add(new JLabel("From Account Number:"));
        panel.add(fromAccountNumberField);

        panel.add(new JLabel("To Account Number:"));
        panel.add(toAccountNumberField);

        panel.add(new JLabel("Amount:"));
        panel.add(amountField);

        JButton transferButton = new JButton("Transfer");
        transferButton.addActionListener(e -> transferFunds());

        panel.add(transferButton);
        add(panel);

        setVisible(true);
    }

    private void transferFunds() {
        String fromAccountNumber = fromAccountNumberField.getText();
        String toAccountNumber = toAccountNumberField.getText();
        double amount = Double.parseDouble(amountField.getText());

        Bank bank = Bank.getInstance();
        Account fromAccount = bank.getAccount(fromAccountNumber);
        Account toAccount = bank.getAccount(toAccountNumber);

        if (fromAccount != null && toAccount != null) {
            if (fromAccount.withdraw(amount)) {
                toAccount.deposit(amount);
                JOptionPane.showMessageDialog(this, "Transfer successful! New balance for " + fromAccountNumber + ": " + fromAccount.getBalance());
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient funds!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "One or both accounts not found!");
        }

        dispose();
    }
}
