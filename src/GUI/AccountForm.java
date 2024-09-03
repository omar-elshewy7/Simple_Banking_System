package GUI;

import Model.Bank;
import Model.Account;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class AccountForm extends JPanel {
    private ResourceBundle messages;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public AccountForm(Locale locale, CardLayout cardLayout, JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        messages = ResourceBundle.getBundle("MessagesBundle", locale);

        setLayout(new GridLayout(0, 2, 10, 10));

        JLabel nameLabel = new JLabel(messages.getString("name"));
        JTextField nameField = new JTextField();
        nameLabel.setFont(new Font("Cardamon", Font.BOLD, 15));

        JLabel phoneLabel = new JLabel(messages.getString("phoneNumber"));
        JTextField phoneField = new JTextField();
        phoneLabel.setFont(new Font("Cardamon", Font.BOLD, 15));

        JLabel nationalIDLabel = new JLabel(messages.getString("nationalID"));
        JTextField nationalIDField = new JTextField();
        nationalIDLabel.setFont(new Font("Cardamon", Font.BOLD, 15));

        JLabel addressLabel = new JLabel(messages.getString("address"));
        JTextField addressField = new JTextField();
        addressLabel.setFont(new Font("Cardamon", Font.BOLD, 15));

        JButton createButton = new JButton(messages.getString("createAccount"));
        createButton.setFont(new Font("Cardamon", Font.BOLD, 15));

        JButton anotherOperationButton = new JButton(messages.getString("doAnotherOperation"));
        anotherOperationButton.setFont(new Font("Cardamon", Font.BOLD, 15));

        createButton.addActionListener(e -> {
            String accountNumber = Bank.getInstance().createAccount(
                    nameField.getText(),
                    phoneField.getText(),
                    nationalIDField.getText(),
                    addressField.getText()
            );
            JOptionPane.showMessageDialog(this, messages.getString("accountCreated") + ": " + accountNumber);
        });

        anotherOperationButton.addActionListener(e -> cardLayout.show(cardPanel, "App"));

        add(nameLabel);
        add(nameField);
        add(phoneLabel);
        add(phoneField);
        add(nationalIDLabel);
        add(nationalIDField);
        add(addressLabel);
        add(addressField);
        add(createButton);
        add(anotherOperationButton);
    }
}
