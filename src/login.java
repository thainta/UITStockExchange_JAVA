import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login extends JFrame{
    private JButton button1;
    private JPanel mainPanel;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton btn2;

    public login() {
        this.setMaximumSize(new Dimension(320, 192));
        this.setPreferredSize(new Dimension(320, 192));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);
        button1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(button1, "Hello");
            }
        });
    }
}
