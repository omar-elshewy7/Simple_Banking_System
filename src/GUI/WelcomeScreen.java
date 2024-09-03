package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Locale;
import java.util.ResourceBundle;

public class WelcomeScreen extends JPanel {
    private BufferedImage backgroundImage;
    private ResourceBundle messages;

    public WelcomeScreen(Locale locale, CardLayout cardLayout, JPanel cardPanel) {
        // Load the resource bundle based on the selected locale
        this.messages = ResourceBundle.getBundle("MessagesBundle", locale);

        // Set the layout for the panel
        setLayout(new BorderLayout());

        // Load the background image
        try {
            backgroundImage = ImageIO.read(getClass().getResource("/resources/image/O6U.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set up the content of the interface
        JLabel welcomeLabel = new JLabel(messages.getString("welcome"));
        welcomeLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.BLACK);

        JButton englishButton = new JButton(messages.getString("english"));
        JButton arabicButton = new JButton(messages.getString("arabic"));

        // Set the action when the buttons are pressed
        englishButton.addActionListener(e -> switchLanguage(new Locale("en", "US"), cardLayout, cardPanel));
        arabicButton.addActionListener(e -> switchLanguage(new Locale("ar", "EG"), cardLayout, cardPanel));

        // Setting up GridBagConstraints to position components on the interface
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Center horizontally
        gbc.insets = new Insets(10, 10, 10, 10); // Set padding
        gbc.anchor = GridBagConstraints.CENTER; // Align components in the center

        // Create a content panel with GridBagLayout to arrange components
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setOpaque(false); 
        contentPanel.add(welcomeLabel, gbc);
        gbc.gridy = 1;
        contentPanel.add(englishButton, gbc);
        gbc.gridy = 2;
        contentPanel.add(arabicButton, gbc);

        add(contentPanel, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    
        // Draw the scaled background image on the panel
        if (backgroundImage != null) {
            Image scaledImage = backgroundImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            g.drawImage(scaledImage, 0, 0, this);
        }
    }

    private void switchLanguage(Locale locale, CardLayout cardLayout, JPanel cardPanel) {
        // Update the resource bundle with the selected locale
        messages = ResourceBundle.getBundle("Translation_Files/MessagesBundle", locale);
        // Add a new instance of the App panel to the card layout
        cardPanel.add(new App(locale, cardLayout, cardPanel), "App");
        cardLayout.show(cardPanel, "App");
    }
}
