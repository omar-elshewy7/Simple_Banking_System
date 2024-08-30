package GUI;

import javax.swing.*;
import Model.Bank;
import Model.Account;

public class TransferForm extends JFrame {
    private JTextField fromAccountField;
    private JTextField toAccountField;
    private JTextField amountField;
    
    public TransferForm() {
        setTitle("Transfer Funds");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        fromAccountField = new JTextField(20);
        toAccountField = new JTextField(20);
        amountField = new JTextField(20);

        panel.add(new JLabel("Source Account Number: "));
        panel.add(fromAccountField);

        panel.add(new JLabel("Target Account Number:"));
        panel.add(toAccountField);

        panel.add(new JLabel("Amount:"));
        panel.add(amountField);

        JButton transferButton = new JButton("Transfer");
        transferButton.addActionListener(e -> transfer());

        panel.add(transferButton);
        add(panel);

        setVisible(true);
    }

    private void transfer() {
        String fromAccountNumber = fromAccountField.getText();
        String toAccountNumber = toAccountField.getText();
        double amount = Double.parseDouble(amountField.getText());

        Bank bank = Bank.getInstance();
        Account fromAccount = bank.getAccount(fromAccountNumber);
        Account toAccount = bank.getAccount(toAccountNumber);

        if (fromAccount != null && toAccount != null) {
            if (fromAccount.withdraw(amount)) {
                toAccount.deposit(amount);
                JOptionPane.showMessageDialog(this, "Transfer successful!");
            } else
                JOptionPane.showMessageDialog(this, "Insufficient funds!");
            
        } else
            JOptionPane.showMessageDialog(this, "Account not found!");
        

        dispose();
    }
}