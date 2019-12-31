package UI;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{

    private Login login = new Login();

    public Window() {
        this.setTitle("");
        this.setPreferredSize(new Dimension(950, 600));
        this.setMinimumSize(new Dimension(893, 564));
        this.setMaximumSize(new Dimension(1140, 720));
//        this.pack();
        this.setLocationRelativeTo(null);

        this.setContentPane(login);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
