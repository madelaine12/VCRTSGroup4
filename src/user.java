import javax.swing.*;
public class user {
    private JFrame userFrame = new JFrame("User Dashboard");
    private JPanel userPanel = new JPanel();
    private JLabel welcomeMessage = new JLabel("Welcome Back!");
    private JLabel loginMessage = new JLabel("Please login to use:");

    public void getUserFrame() {
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setSize(400,  600);
        userFrame.add(userPanel);
        userPanel.add(welcomeMessage);
        userPanel.add(loginMessage);
        userFrame.setVisible(true);
    }
}
