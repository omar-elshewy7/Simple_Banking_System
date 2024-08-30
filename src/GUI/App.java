package gui;

import javax.swing.*;

public class App extends JFrame {
    public App() {
        setTitle("- Welcome to O6U Banking System -");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.addActionListener(e -> new AccountForm());

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(e -> new DepositForm());

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(e -> new WithdrawForm());

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.addActionListener(e -> new BalanceForm());

        JButton transferButton = new JButton("Transfer Money");
        transferButton.addActionListener(e -> new TransForm());

        panel.add(createAccountButton);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(checkBalanceButton);
        panel.add(transferButton);

        add(panel);

        setVisible(true);
    }
}
