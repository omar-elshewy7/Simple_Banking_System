package GUI;

import javax.swing.*;
import Model.Bank;
import Model.Account;

public class WithdrawForm extends JFrame {
    private JTextField accountNumberField;
    private JTextField amountField;

    public WithdrawForm() {
        setTitle("Withdraw");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        accountNumberField = new JTextField(20);
        amountField = new JTextField(20);

        panel.add(new JLabel("Account Number:"));
        panel.add(accountNumberField);

        panel.add(new JLabel("Amount:"));
        panel.add(amountField);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(e -> withdraw());

        panel.add(withdrawButton);
        add(panel);

        setVisible(true);
    }

    private void withdraw() {
        String accountNumber = accountNumberField.getText();
        double amount = Double.parseDouble(amountField.getText());

        Bank bank = Bank.getInstance();
        Account account = bank.getAccount(accountNumber);

        if (account != null) {
            if (account.withdraw(amount)) {
                JOptionPane.showMessageDialog(this, "Withdrawal successful! New balance: " + account.getBalance());
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient funds!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Account not found!");
        }

        dispose();
    }
}
