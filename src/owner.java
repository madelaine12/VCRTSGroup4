import javax.swing.*;
public class owner {
    private JFrame ownerFrame = new JFrame("Owner Dashboard");

    public void getOwnerFrame() {
        ownerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ownerFrame.setSize(400,  600);
        ownerFrame.setVisible(true);
    }
}
