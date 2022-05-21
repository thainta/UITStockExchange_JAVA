import javax.swing.*;
import java.awt.*;

public class registration extends JDialog{
    private JTextField firstNameInput;
    private JTextField lastNameInput;
    private JTextField dobInput;
    private JTextField addressInput;
    private JTextField identityCardInput;
    private JTextField phoneInput;
    private JTextField emailInput;
    private JPasswordField passwordInput;
    private JPasswordField confirmPasswordInput;
    private JButton registerBtn;
    private JButton cancelBtn;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JPanel registerPanel;

    public registration(JFrame parent) {
        super(parent);
        setTitle("Create a new account");
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(540, 580));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        registration myForm = new registration(null);
    }
}