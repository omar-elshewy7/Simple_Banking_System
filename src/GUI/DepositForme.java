package GUI;

import javax.swing.*;
import Model.Account;
import Model.Bank;

public class DepositForme extends JFrame {
    private JTextField accountNumberField;
    private JTextField amountField;

    public DepositForme() {
        setTitle("Deposit");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DIPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        accountNumberField = new JTextField(20);
        amountField = new JTextField(20);

        panel.add(new JLabel("Account Number:"));
        panel.add(accountNumberField);

        panel.add(new JLabel("Amount:"));
        panel.add(amountField);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(e -> deposit());

        panel.add(depositButton);
        add(panel);

        setVisible(true);
    }

    private void deposit() {
        String accountNumber = accountNumberField.getText();
        double amount = Double.parseDouble(amountField.getText());

        Bank bank = Bank.getInstance();
        Account account = bank.getAccount(accountNumber);

        if (account != null) {
            account.deposit(amount);
            JOptionPane.showMessageDialog(this, "Deposit successful!");
        } else {
            JOptionPane.showMessageDialog(this, "Account not found!");
        }

        dispose();
    }
}
