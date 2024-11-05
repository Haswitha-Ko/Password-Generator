import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

public class PasswordGenerator extends JFrame {
    private JTextField passwordField;
    private JButton generateButton;

    // Character sets to include in password
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+";

    // Random password generator
    private static final SecureRandom random = new SecureRandom();

    public PasswordGenerator() {
        // Set up frame
        setTitle("Password Generator");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        passwordField = new JTextField(20);
        passwordField.setEditable(false);
        generateButton = new JButton("Generate Password");

        // Add action listener to button
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordField.setText(generatePassword(12));
            }
        });

        // Add components to frame
        JPanel panel = new JPanel();
        panel.add(new JLabel("Generated Password:"));
        panel.add(passwordField);
        panel.add(generateButton);

        add(panel);
    }

    // Password generation logic
    private String generatePassword(int length) {
        StringBuilder password = new StringBuilder(length);
        String allCharacters = LOWERCASE + UPPERCASE + DIGITS + SPECIAL_CHARACTERS;

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allCharacters.length());
            password.append(allCharacters.charAt(index));
        }

        return password.toString();
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PasswordGenerator generator = new PasswordGenerator();
            generator.setVisible(true);
        });
    }
}
