import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login extends JFrame{
    private JButton button1;
    private JPanel mainPanel;
    private JPasswordField passwordField1;
    private JTextField textField1;

    public login() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        button1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(button1, "Hello");
            }
        });
    }

    public static void main(String[] args) {
        JFrame log = new login();
        log.setVisible(true);
    }
}
