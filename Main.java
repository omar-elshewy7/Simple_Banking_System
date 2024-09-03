package GUI;

// import GUI.WelcomeScreen;
// import GUI.AccountForm;
// import GUI.DepositForm;
// import GUI.App;
// import GUI.WithdrawForm;
// import GUI.BalanceForm;
// import GUI.TransForm;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        // Load saved account data from storage
        BankUtils.loadAccounts();

        // Ensure GUI updates are handled on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            // Create a CardLayout for managing different panels
            CardLayout cardLayout = new CardLayout();
            JPanel cardPanel = new JPanel(cardLayout);

            // Create the main application window
            JFrame frame = new JFrame("Banking System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
            frame.setSize(800, 600); // Set the size of the window

            // Set the default locale for the application
            Locale defaultLocale = Locale.getDefault();

            // Initialize and add different panels to the CardLayout
            WelcomeScreen welcomeScreen = new WelcomeScreen(defaultLocale,cardLayout, cardPanel);
            App app = new App(defaultLocale,cardLayout, cardPanel);
            AccountForm accountForm = new AccountForm(defaultLocale, cardLayout, cardPanel);
            DepositForm depositForm = new DepositForm(defaultLocale,cardLayout, cardPanel);
            WithdrawForm withdrawForm = new WithdrawForm(defaultLocale,cardLayout, cardPanel);
            BalanceForm balanceForm = new BalanceForm(defaultLocale,cardLayout, cardPanel);
            TransForm transForm = new TransForm(defaultLocale,cardLayout, cardPanel);

            // Add panels to the cardPanel with unique identifiers
            cardPanel.add(welcomeScreen, "WelcomeScreen");
            cardPanel.add(app, "App");
            cardPanel.add(accountForm, "AccountForm");
            cardPanel.add(depositForm, "DepositForm");
            cardPanel.add(withdrawForm, "WithdrawForm");
            cardPanel.add(balanceForm, "BalanceForm");
            cardPanel.add(transForm, "TransForm");
        
            // Add the cardPanel to the frame
            frame.add(cardPanel);
            frame.setVisible(true); // Make the window visible
        });

         // Add a shutdown hook to save account data when the application exits
        Runtime.getRuntime().addShutdownHook(new Thread(BankUtils::saveAccounts));
    }
}