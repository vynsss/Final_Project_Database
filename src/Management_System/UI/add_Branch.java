package Management_System.UI;

import Management_System.Controller.Branches;

import javax.swing.*;
import java.awt.*;

public class add_Branch extends JPanel{

    Branches b = new Branches();

    //JLabel
    private JLabel l_address = new JLabel("Address               :");
    private JLabel l_city    = new JLabel("City                        :");
    //Field
    private JTextField text_address = new JTextField(30);
    private JTextField text_city = new JTextField(30);
    //JButton
    private JButton b_add = new JButton("Add");

    public add_Branch(){

        this.setSize(new Dimension(870, 760));
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(241, 240, 232));

        Color bc = new Color(173, 196, 206);

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(3,3,3,10);

        c.weightx = 1.0; c.fill = c.BOTH;
        c.gridx = 0; c.gridy = 0; c.gridwidth = 1;
        this.add(l_address, c);
        c.gridx = 0; c.gridy = 1; c.gridwidth = 1;
        this.add(l_city, c);

        c.fill = c.NONE;
        c.gridx = 1; c.gridy = 0; c.gridwidth = 1;
        this.add(text_address, c);
        c.gridx = 1; c.gridy = 1; c.gridwidth = 1;
        this.add(text_city, c);

        c.fill = c.BOTH;
        c.gridx = 3; c.gridy = 9; c.gridwidth = 1;
        b_add.setBorderPainted(false);
        b_add.setFocusPainted(false);
        b_add.setBackground(bc);
        this.add(b_add, c);

        b_add.addActionListener(e -> {
            String address = text_address.getText();
            String city = text_city.getText();

            b.addBranch(address, city);
        });
    }
}
