package gui;

import javax.swing.*;

public class App extends JFrame {
    public App() {
        setTitle("Banking System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        JMenu accountMenu = new JMenu("Account");
        JMenuItem createAccount = new JMenuItem("Create Account");
        JMenuItem deposit = new JMenuItem("Deposit");
        JMenuItem withdraw = new JMenuItem("Withdraw");
        JMenuItem checkBalance = new JMenuItem("Check Balance");

        createAccount.addActionListener(e -> new AccountForm());
        deposit.addActionListener(e -> new DepositForm());
        withdraw.addActionListener(e -> new WithdrawForm());
        checkBalance.addActionListener(e -> new BalanceForm());

        accountMenu.add(createAccount);
        accountMenu.add(deposit);
        accountMenu.add(withdraw);
        accountMenu.add(checkBalance);

        menuBar.add(accountMenu);
        setJMenuBar(menuBar);

        setVisible(true);
    }
}
