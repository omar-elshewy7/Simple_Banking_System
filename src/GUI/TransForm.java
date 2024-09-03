package GUI;

import Model.Bank;
import Model.Account;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class TransForm extends JPanel {
    private ResourceBundle messages;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public TransForm(Locale locale, CardLayout cardLayout, JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        messages = ResourceBundle.getBundle("MessagesBundle", locale);

        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel fromAccountLabel = new JLabel(messages.getString("fromAccount"));
        JTextField fromAccountField = new JTextField();
        fromAccountLabel.setFont(new Font("Cardamon", Font.BOLD, 15));

        JLabel toAccountLabel = new JLabel(messages.getString("toAccount"));
        JTextField toAccountField = new JTextField();
        toAccountLabel.setFont(new Font("Cardamon", Font.BOLD, 15));

        JLabel amountLabel = new JLabel(messages.getString("amount"));
        JTextField amountField = new JTextField();
        amountLabel.setFont(new Font("Cardamon", Font.BOLD, 15));

        JButton transferButton = new JButton(messages.getString("transferFunds"));
        JButton anotherOperationButton = new JButton(messages.getString("doAnotherOperation"));

        transferButton.addActionListener(e -> {
            String fromAccountNumber = fromAccountField.getText();
            String toAccountNumber = toAccountField.getText();
            Account fromAccount = Bank.getInstance().getAccount(fromAccountNumber);
            Account toAccount = Bank.getInstance().getAccount(toAccountNumber);

            if (fromAccount != null && toAccount != null) {
                double amount = Double.parseDouble(amountField.getText());
                if (fromAccount.withdraw(amount)) {
                    toAccount.deposit(amount);
                    JOptionPane.showMessageDialog(this, messages.getString("transferSuccess"));
                } else {
                    JOptionPane.showMessageDialog(this, messages.getString("insufficientFunds"));
                }
            } else {
                JOptionPane.showMessageDialog(this, messages.getString("accountNotFound"));
            }
        });
        transferButton.setBackground(Color.ORANGE);
        transferButton.setForeground(Color.WHITE);
        transferButton.setFont(new Font("Cardamon", Font.BOLD, 15));

        anotherOperationButton.addActionListener(e -> cardLayout.show(cardPanel, "App"));
        anotherOperationButton.setBackground(Color.GREEN);
        anotherOperationButton.setForeground(Color.WHITE);
        anotherOperationButton.setFont(new Font("Cardamon", Font.BOLD, 15));

        add(fromAccountLabel);
        add(fromAccountField);
        add(toAccountLabel);
        add(toAccountField);
        add(amountLabel);
        add(amountField);
        add(transferButton);
        add(anotherOperationButton);
    }
}