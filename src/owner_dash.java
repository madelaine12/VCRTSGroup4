import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.IOException;

public class owner_dash extends JFrame implements ActionListener {
    private JTextField ownerIDField, vehicleInfoField, residencyTimeField;
    private JButton submitButton, clearButton, signOutButton, helpButton;

    public owner_dash() {
        setTitle("Vehicular Cloud Console");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // Owner fields
        add(new JLabel("Owner ID:"));
        ownerIDField = new JTextField();
        add(ownerIDField);

        add(new JLabel("Vehicle Info:"));
        vehicleInfoField = new JTextField();
        add(vehicleInfoField);

        add(new JLabel("Residency Time:"));
        residencyTimeField = new JTextField();
        add(residencyTimeField);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ownerIDField.setText("");
                residencyTimeField.setText("");
                vehicleInfoField.setText("");
            }
        });
        add(clearButton);

        signOutButton = new JButton("Sign Out");
        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ownerIDField.setText("");
                residencyTimeField.setText("");
                vehicleInfoField.setText("");
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
            String ownerData = "Owner ID: " + ownerIDField.getText() +
                    ", Vehicle Info: " + vehicleInfoField.getText() +
                    ", Residency Time: " + residencyTimeField.getText();
            String timestamp = LocalDateTime.now().toString();
            saveToFile(ownerData + "\nTimestamp: " + timestamp);
            JOptionPane.showMessageDialog(this, "Entries saved!");
        }
    }

    private void saveToFile(String data) {
        try (FileWriter writer = new FileWriter("owner_transaction.txt", true)) {
            writer.write(data + "\n\n");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving data.");
        }
    }

}

