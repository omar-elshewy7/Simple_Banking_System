package GUI;

import Model.Bank;
import Model.Account;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class WithdrawForm extends JPanel {
    private ResourceBundle messages;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    // Constructor to initialize the WithdrawForm with locale, card layout, and card panel
    public WithdrawForm(Locale locale, CardLayout cardLayout, JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;

        // Load the resource bundle based on the selected locale
        messages = ResourceBundle.getBundle("MessagesBundle", locale);

        // Set the layout of the panel with a grid of 3 rows, 2 columns, and spacing of 10px
        setLayout(new GridLayout(3, 2, 10, 10));

        // Create and configure labels and text fields for account number and withdrawal amount
        JLabel accountNumberLabel = new JLabel(messages.getString("accountNumber"));
        JTextField accountNumberField = new JTextField();
        accountNumberLabel.setFont(new Font("Cardamon", Font.BOLD, 15)); // Set font style for the label

        JLabel amountLabel = new JLabel(messages.getString("amount"));
        JTextField amountField = new JTextField();
        amountLabel.setFont(new Font("Cardamon", Font.BOLD, 15));

        // Create and configure buttons for withdrawing funds and performing another operation
        JButton withdrawButton = new JButton(messages.getString("withdraw"));
        JButton anotherOperationButton = new JButton(messages.getString("doAnotherOperation"));


        // Action listener for the withdraw button
        withdrawButton.addActionListener(e -> {
            String accountNumber = accountNumberField.getText(); // Get the account number from the input field
            Account account = Bank.getInstance().getAccount(accountNumber); // Retrieve the account using the account number 
            if (account != null) {
                double amount = Double.parseDouble(amountField.getText()); // Parse the withdrawal amount from the input field
                if (account.withdraw(amount)) {
                    // Show a success message if the withdrawal is successful
                    JOptionPane.showMessageDialog(this, messages.getString("withdrawSuccess"));
                } else {
                    // Show an error message if there are insufficient funds
                    JOptionPane.showMessageDialog(this, messages.getString("insufficientFunds"));
                }
            } else {
                // Show an error message if the account is not found
                JOptionPane.showMessageDialog(this, messages.getString("accountNotFound"));
            }
        });
        withdrawButton.setBackground(Color.ORANGE); // Set the background color of the button
        withdrawButton.setForeground(Color.WHITE); // Set the text color of the button
        withdrawButton.setFont(new Font("Cardamon", Font.BOLD, 15)); // Set the font style of the button text

        // Action listener for the "Do Another Operation" button
        anotherOperationButton.addActionListener(e -> cardLayout.show(cardPanel, "App"));
        anotherOperationButton.setBackground(Color.GREEN);
        anotherOperationButton.setForeground(Color.WHITE);
        anotherOperationButton.setFont(new Font("Cardamon", Font.BOLD, 15));

        // Add components to the panel
        add(accountNumberLabel);
        add(accountNumberField);
        add(amountLabel);
        add(amountField);
        add(withdrawButton);
        add(anotherOperationButton);
    }
}