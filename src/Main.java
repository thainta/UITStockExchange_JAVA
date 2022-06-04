import javax.swing.*;
import utils.currentUser;
import views.signIn.signIn;
public class Main {
    public static void main(String[] args) {
        // login page load.
        signIn signInForm = new signIn();
        signInForm.setVisible(true);
    }
}
