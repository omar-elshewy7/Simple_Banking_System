package GUI;

import javax.swing.*;
import Model.Bank;

public class AccountForm extends JFrame {
    public AccountForm() {
        setTitle("Create Account");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JPanel nameLabel = new JLabel("Nmae: ");
        JTextField nameField = new JTextField(20);

        JLabel phoneLabel = new JLabel("Phone Number: ");
        JTextField phoneField = new JTextField(20);

        JLabel nationalIDLabel = new JLabel("National ID:");
        JTextField nationalIDField = new JTextField(20);

        JLabel addressLabel = new JLabel("Address: ");
        JTextField addressField = new JTextField(20);

        JButton createButton = new JButton("Create");
        createButton.addActionListenter(e -> {
            String name = nameField.getText();
            String phoneNumber = phoneField.getText();
            String nationalID = nationalIDField.getText();

            Bank.getInstance().createAccount(name, phoneNumber, nationalID, address);
            JOptionPane.showMessageDialog(this, "Account created!");
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(nationalIDLabel);
        panel.add(nationalIDField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(createButton);

        add(panel);
        setVisible(true);

    }
}