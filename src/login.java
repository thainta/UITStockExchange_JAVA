import javax.swing.*;
import java.awt.*;

public class login extends JDialog{
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JButton registerButton;
    private JPanel loginPanel;
    public login(JFrame parent) {
        super(parent);
        setTitle("Login...");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(480, 400));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        login myForm = new login(null);
    }
}