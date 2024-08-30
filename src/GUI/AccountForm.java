package GUI;

import javax.swing.*;
import Model.Bank;

public class AccountForm extends JFrame {
    private JTextField nameField;
    private JTextField phoneNumberField;
    private JTextField nationalIDField;
    private JTextField addressField;

    public AccountForm() {
        setTitle("Create Account");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        nameField = new JTextField(20);
        phoneNumberField = new JTextField(20);
        nationalIDField = new JTextField(20);
        addressField = new JTextField(20);

        panel.add(new JLabel("Name:"));
        panel.add(nameField);

        panel.add(new JLabel("Phone Number:"));
        panel.add(phoneNumberField);

        panel.add(new JLabel("National ID:"));
        panel.add(nationalIDField);

        panel.add(new JLabel("Address:"));
        panel.add(addressField);

        JButton createButton = new JButton("Create Account");
        createButton.addActionListener(e -> createAccount());

        panel.add(createButton);
        add(panel);

        setVisible(true);
    }

    private void createAccount() {
        String name = nameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String nationalID = nationalIDField.getText();
        String address = addressField.getText();

        Bank bank = Bank.getInstance();
        String accountNumber = bank.createAccount(name, phoneNumber, nationalID, address);

        JOptionPane.showMessageDialog(this, "Account created successfully! Your account number is: " + accountNumber);

        dispose();
    }
}