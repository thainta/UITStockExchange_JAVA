import javax.swing.*;
import java.awt.*;

public class userProfile extends JDialog{
    private JButton visibleButton;
    private JButton viewButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField a233315679TextField;
    private JTextField textField5;
    private JTextField textField6;
    private JPasswordField passwordField1;
    private JButton updateButton;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JPanel userProfilePanel;

    public userProfile(JFrame parent) {
        super(parent);
        setTitle("User Profile");
        setContentPane(userProfilePanel);
<<<<<<< HEAD
        setMinimumSize(new Dimension(600, 650));
=======
        setMinimumSize(new Dimension(600, 600));
>>>>>>> c1263f4 (User Profile UI)
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        userProfile myForm = new userProfile(null);
    }
}
