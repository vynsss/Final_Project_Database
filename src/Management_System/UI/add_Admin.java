package Management_System.UI;

import Management_System.Controller.Admins;

import javax.swing.*;
import java.awt.*;

public class add_Admin extends JPanel {

    Admins a = new Admins();

    //JLabel
    private JLabel l_user = new JLabel("User Name               :");
    private JLabel l_password = new JLabel("Password                :");
    //Field
    private JTextField text_user = new JTextField(50);
    private JTextField text_password = new JTextField(50);
    //JButton
    private JButton b_add = new JButton("Add");

    public add_Admin(){
        this.setSize(new Dimension(870, 760));
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(241, 240, 232));

        Color bc = new Color(173, 196, 206);

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(3,3,3,3);

 c.fill = c.BOTH;
        c.gridx = 0; c.gridy = 0; c.gridwidth = 1;
        this.add(l_user, c);
        c.gridx = 0; c.gridy = 1; c.gridwidth = 1;
        this.add(l_password, c);

//        c.fill = c.NONE;
        c.weightx = 1.0;
        c.gridx = 1; c.gridy = 0; c.gridwidth = 2;
        this.add(text_user, c);
        c.gridx = 1; c.gridy = 1; c.gridwidth = 2;
        this.add(text_password, c);

        c.fill = c.BOTH;
        c.gridx = 2; c.gridy = 2; c.gridwidth = 1;
        b_add.setBorderPainted(false);
        b_add.setFocusPainted(false);
        b_add.setBackground(bc);
        this.add(b_add, c);

        b_add.addActionListener(e -> {
            String address = text_user.getText();
            String city = text_password.getText();

            a.addAdmin(address, city);

            text_user.setText("");
            text_password.setText("");
        });

    }
}
