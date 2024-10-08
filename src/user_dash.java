import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.IOException;

public class user_dash extends JFrame implements ActionListener {
    private JTextField userIDField, jobDurationField, jobDeadlineField;
    private JButton submitButton, clearButton, signOutButton, helpButton;

    public user_dash() {
        setTitle("Vehicular Cloud Console");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // Client fields
        add(new JLabel("Client ID:"));
        userIDField = new JTextField();
        add(userIDField);

        add(new JLabel("Job Duration:"));
        jobDurationField = new JTextField();
        add(jobDurationField);

        add(new JLabel("Job Deadline:"));
        jobDeadlineField = new JTextField();
        add(jobDeadlineField);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userIDField.setText("");
                jobDurationField.setText("");
                jobDeadlineField.setText("");
            }
        });
        add(clearButton);

        signOutButton = new JButton("Sign Out");
        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userIDField.setText("");
                jobDurationField.setText("");
                jobDeadlineField.setText("");
                main.getMainFrame();
                dispose();
            }
        });
        add(signOutButton);

        helpButton = new JButton("Help");
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "I thought this was simple enough.");
            }
        });
        add(helpButton);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String userData = "User ID: " + userIDField.getText() +
                    ", Job Duration: " + jobDurationField.getText() +
                    ", Job Deadline: " + jobDeadlineField.getText();
            String timestamp = LocalDateTime.now().toString();
            saveToFile(userData + "\nTimestamp: " + timestamp);
            JOptionPane.showMessageDialog(this, "Entries saved!");
        }
    }

    private void saveToFile(String data) {
        try (FileWriter writer = new FileWriter("user_transaction.txt", true)) {
            writer.write(data + "\n\n");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving data.");
        }
    }

}
