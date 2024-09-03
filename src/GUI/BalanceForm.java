package GUI;

import Model.Bank;
import Model.Account;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class BalanceForm extends JPanel {
    private ResourceBundle messages;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public BalanceForm(Locale locale, CardLayout cardLayout, JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        messages = ResourceBundle.getBundle("MessagesBundle", locale);

        setLayout(new GridLayout(3, 2, 10, 10));

        JLabel accountNumberLabel = new JLabel(messages.getString("accountNumber"));
        JTextField accountNumberField = new JTextField();
        accountNumberLabel.setFont(new Font("Cardamon", Font.BOLD, 15));

        JButton checkBalanceButton = new JButton(messages.getString("checkBalance"));
        JButton anotherOperationButton = new JButton(messages.getString("doAnotherOperation"));
        
        checkBalanceButton.addActionListener(e -> {
            String accountNumber = accountNumberField.getText();
            Account account = Bank.getInstance().getAccount(accountNumber);
            if (account != null) {
                JOptionPane.showMessageDialog(this, messages.getString("balance") + ": " + account.getBalance());
            } else {
                JOptionPane.showMessageDialog(this, messages.getString("accountNotFound"));
            }
        });
        checkBalanceButton.setBackground(Color.ORANGE);
        checkBalanceButton.setForeground(Color.WHITE);
        checkBalanceButton.setFont(new Font("Cardamon", Font.BOLD, 15));

        anotherOperationButton.addActionListener(e -> cardLayout.show(cardPanel, "App"));
        anotherOperationButton.setBackground(Color.GREEN);
        anotherOperationButton.setForeground(Color.WHITE);
        anotherOperationButton.setFont(new Font("Cardamon", Font.BOLD, 15));

        add(accountNumberLabel);
        add(accountNumberField);
        add(checkBalanceButton);
        add(anotherOperationButton);
    }
}
