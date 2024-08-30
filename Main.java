import GUI.App;
import Utils.BankUtils;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        BankUtils.loadAccounts();  // Load accounts from file at startup
        SwingUtilities.invokeLater(() -> new App());  // Show the main application window
        Runtime.getRuntime().addShutdownHook(new Thread(BankUtils::saveAccounts));  // Save accounts to file at shutdown
    }
}

