package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class OperationsPage extends JPanel {
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private ResourceBundle messages;

    // Constructor to initialize the OperationsPage with locale, card layout, and card panel
    public App(Locale locale, CardLayout cardLayout, JPanel cardPanel) {
        // Load the resource bundle based on the selected locale
        messages = ResourceBundle.getBundle("MessagesBundle", locale);
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;

        // Set the layout of the panel to a grid with 3 rows, 2 columns, and spacing of 10px
        setLayout(new GridLayout(3, 2, 10, 10));

        // Create buttons for each operation
        JButton createAccountButton = new JButton(messages.getString("createAccount"));
        JButton depositButton = new JButton(messages.getString("deposit"));
        JButton withdrawButton = new JButton(messages.getString("withdraw"));
        JButton checkBalanceButton = new JButton(messages.getString("checkBalance"));
        JButton transferButton = new JButton(messages.getString("transferFunds"));
        JButton endButton = new JButton(messages.getString("end"));

        // Set the action listener for the "Create Account" button to show the AccountForm panel
        createAccountButton.addActionListener(e -> cardLayout.show(cardPanel, "AccountForm"));
        createAccountButton.setBackground(Color.ORANGE); // Set the background color of the button
        createAccountButton.setForeground(Color.WHITE); // Set the text color of the button
        createAccountButton.setFont(new Font("Arial", Font.BOLD, 15)); // Set the font style of the button text

        // Set the action listener for the "Deposit" button to show the DepositForm panel
        depositButton.addActionListener(e -> cardLayout.show(cardPanel, "DepositForm"));
        depositButton.setBackground(Color.ORANGE);
        depositButton.setForeground(Color.WHITE);
        depositButton.setFont(new Font("Arial", Font.BOLD, 15));

        // Set the action listener for the "Withdraw" button to show the WithdrawForm panel
        withdrawButton.addActionListener(e -> cardLayout.show(cardPanel, "WithdrawForm"));
        withdrawButton.setBackground(Color.ORANGE);
        withdrawButton.setForeground(Color.WHITE);
        withdrawButton.setFont(new Font("Arial", Font.BOLD, 15));

        // Set the action listener for the "Check Balance" button to show the BalanceForm panel
        checkBalanceButton.addActionListener(e -> cardLayout.show(cardPanel, "BalanceForm"));
        checkBalanceButton.setBackground(Color.ORANGE);
        checkBalanceButton.setForeground(Color.WHITE);
        checkBalanceButton.setFont(new Font("Arial", Font.BOLD, 15));

        // Set the action listener for the "Transfer Funds" button to show the TransForm panel
        transferButton.addActionListener(e -> cardLayout.show(cardPanel, "TransForm"));
        transferButton.setBackground(Color.ORANGE);
        transferButton.setForeground(Color.WHITE);
        transferButton.setFont(new Font("Cardamon", Font.BOLD, 15));

        // Set the action listener for the "End" button to show the WelcomeScreen panel
        endButton.addActionListener(e -> cardLayout.show(cardPanel, "WelcomeScreen"));
        endButton.setBackground(Color.ORANGE);
        endButton.setForeground(Color.WHITE);
        endButton.setFont(new Font("Time New Roman", Font.BOLD, 15));

        // Add the buttons to the panel
        add(createAccountButton);
        add(depositButton);
        add(withdrawButton);
        add(checkBalanceButton);
        add(transferButton);
        add(endButton);
    }
}