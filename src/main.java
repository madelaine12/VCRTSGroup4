import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
    private static JFrame mainFrame;
    private static JPanel mainPanel, buttonPanel;
    private static JButton selectUser, selectOwner;
    
    private static void setButtons() {
        selectUser = new JButton("User");
        selectOwner = new JButton("Owner");

        selectUser.setBackground(new Color(100, 150, 250));
        selectUser.setForeground(Color.WHITE);
        selectOwner.setBackground(new Color(100, 150, 250));
        selectOwner.setForeground(Color,WHITE);

        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        selectUser.setFont(buttonFont);
        selectOwner.setFont(buttonFont);

        // Add action listeners
        selectUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainFrame.setVisibile(false);
                new User();
            }
        });

        selectOwner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainFrame.setVisible(false);
                new owner();
            }
        });
    }
    
    private static void setButtonPanel() {
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackgroud(Color.WHITE);
        buttonPanel.add(selectOwner);
        buttonPanel.add(selectUser);
    }
    private static void setMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.setBackground(new Color(240, 240, 240));
        
        JLabel welcomeMessage, userSelectMessage; //This declares two labels
        welcomeMessage = new JLabel("Welcome to VCRTS!");
        userSelectMessage = new JLabel("I'm a");

        Font labelFont = new Font("Arial", Font.BOLD, 18);
        welcomeMessage.setFont(labelFont);
        userSelectMessage.setFont(new Font("Arial", Font.PLAIN, 16));

        welcomeMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
        userSelectMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(welcomeMessage);
        mainPanel.add(userSelectMessage);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createVerticalStrut(20));
    }
    public static void setMainFrame() {
        mainFrame = new JFrame("VCRTS Dashboard");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 300);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setResizable(true);
        mainFrame.add(mainPanel, BorderLayout.CENTER);
    }
    public static void getMainFrame() {
        setButtons();
        setButtonPanel();
        setMainPanel();
        setMainFrame();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
    public static void main(String[] args) {
        getMainFrame();
    }
}
