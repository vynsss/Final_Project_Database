package UI;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{

    private Login login = new Login();
    private Main_Panel main = new Main_Panel();

    public Window() {
        this.setTitle("Employee Management System");
        this.setPreferredSize(new Dimension(1140, 720));
        this.setMinimumSize(new Dimension(950, 600));
        this.setMaximumSize(new Dimension(1330, 840));

        this.setLocationRelativeTo(null);

        this.setContentPane(main);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
