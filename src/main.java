import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
    public static void main(String[] args) {

        //This is the main frame
        JFrame mainFrame = new JFrame("VCRTS Dashboard");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(300, 200);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setResizable(true);

        //This is the panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //This is the label (text)
        JLabel welcomeMessage, userSelectMessage; //This declares two labels
        welcomeMessage = new JLabel("Welcome to VCRTS!");
        welcomeMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
        userSelectMessage = new JLabel("I'm a");
        userSelectMessage.setAlignmentX(Component.CENTER_ALIGNMENT);


        //Add the labels to the panel
        mainPanel.add(welcomeMessage);
        mainPanel.add(userSelectMessage);

        //Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        //Declare the buttons
        JButton selectUser = new JButton("User");
        JButton selectOwner = new JButton("Owner");

        //Give buttons the function
        selectUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainFrame.setVisible(false);
                new user().getUserFrame();
            }
        });

        selectOwner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainFrame.setVisible(false);
                new owner().getOwnerFrame();
            }
        });

        //Add the buttons to the panel
        buttonPanel.add(selectOwner);
        buttonPanel.add(selectUser);
        mainPanel.add(buttonPanel); //adds the button panel to main panel

        mainFrame.add(mainPanel, BorderLayout.CENTER);
        mainFrame.setVisible(true);

    }
}
