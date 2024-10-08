import javax.swing.*;
public class user {
    public JFrame userFrame = new JFrame("User Dashboard");

    public void getUserFrame() {
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setSize(400,  600);
        userFrame.setVisible(true);
    }
}
