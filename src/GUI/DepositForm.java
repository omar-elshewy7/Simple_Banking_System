package GUI;

import Model.Bank;
import Model.Account;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class DepositForm extends JPanel {
    private ResourceBundle messages;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    // Constructor to initialize the DepositForm with locale, card layout, and card panel
    public DepositForm(Locale locale, CardLayout cardLayout, JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;

        // Load the resource bundle based on the selected locale
        messages = ResourceBundle.getBundle("MessagesBundle", locale);

        // Set the layout of the panel to a grid with 0 rows and 2 columns, with spacing of 10px
        setLayout(new GridLayout(0, 2, 10, 10));

        // Create and configure labels and text fields for account number and deposit amount
        JLabel accountNumberLabel = new JLabel(messages.getString("accountNumber"));
        JTextField accountNumberField = new JTextField();
        accountNumberLabel.setFont(new Font("Cardamon", Font.BOLD, 15)); // Set font style for the label

        JLabel amountLabel = new JLabel(messages.getString("amount"));
        JTextField amountField = new JTextField();
        amountLabel.setFont(new Font("Cardamon", Font.BOLD, 15));

        // Create and configure buttons for depositing funds and performing another operation
        JButton depositButton = new JButton(messages.getString("deposit"));
        JButton anotherOperationButton = new JButton(messages.getString("doAnotherOperation"));

        // Action listener for the deposit button
        depositButton.addActionListener(e -> {
            String accountNumber = accountNumberField.getText(); // Get the account number from the input field
            Account account = Bank.getInstance().getAccount(accountNumber); // Retrieve the account using the account number
            if (account != null) {
                double amount = Double.parseDouble(amountField.getText()); // Parse the deposit amount from the input field
                account.deposit(amount); // Deposit the amount into the account
                // Show a success message if the deposit is successful
                JOptionPane.showMessageDialog(this, messages.getString("depositSuccess"));
            } else {
                // Show an error message if the account is not found
                JOptionPane.showMessageDialog(this, messages.getString("accountNotFound"));
            }
        });
        depositButton.setBackground(Color.ORANGE); // Set the background color of the button
        depositButton.setForeground(Color.WHITE); // Set the text color of the button
        depositButton.setFont(new Font("Cardamon", Font.BOLD, 15)); // Set the font style of the button text

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
        add(depositButton);
        add(anotherOperationButton);
    }
}
