import GUI.App;
import Utils.BankUtils;

public class Main {
    public static void main(String[] args) {
        BankUtils.loadAccounts();  // Load accounts when starting the application

        SwingUtilities.invokeLater(() -> new App());  // Show the main application window

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            BankUtils.saveAccounts();  // Save accounts when closing the application
        }));
    }
}
