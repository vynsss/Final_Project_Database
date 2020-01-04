package Management_System.UI;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{

    private Login login;
    private Main_Panel main;

    public Window() {
        this.setTitle("Employee Management System");
        this.setPreferredSize(new Dimension(1140, 720));
        this.setMinimumSize(new Dimension(1140, 720));
        this.setMaximumSize(new Dimension(1330, 840));

        this.setLocationRelativeTo(null);

        this.setContentPane(new Login());

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Main_Panel getMain() {
        return main;
    }

    public void setMain(Main_Panel main) {
        this.main = main;
    }


}
