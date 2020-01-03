package UI;

import Controller.Departments;

import javax.swing.*;
import java.awt.*;

public class add_Department extends JPanel {

    Departments d = new Departments();

    //JLabel
    private JLabel l_department_name    = new JLabel("Deparment Name               :");
    private JLabel l_branch_id          = new JLabel("Branch ID                        :");
    //Field
    private JTextField text_department_name = new JTextField(30);
    private JTextField text_branch_id = new JTextField(30);
    //JButton
    private JButton b_add = new JButton("Add");

    public add_Department(){
        this.setSize(new Dimension(870, 760));
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(241, 240, 232));

        Color bc = new Color(173, 196, 206);

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(3,3,3,10);

        c.weightx = 1.0; c.fill = c.BOTH;
        c.gridx = 0; c.gridy = 0; c.gridwidth = 1;
        this.add(l_department_name, c);
        c.gridx = 0; c.gridy = 1; c.gridwidth = 1;
        this.add(l_branch_id, c);

        c.fill = c.NONE;
        c.gridx = 1; c.gridy = 0; c.gridwidth = 1;
        this.add(text_department_name, c);
        c.gridx = 1; c.gridy = 1; c.gridwidth = 1;
        this.add(text_branch_id, c);

        c.fill = c.BOTH;
        c.gridx = 3; c.gridy = 9; c.gridwidth = 1;
        b_add.setBorderPainted(false);
        b_add.setFocusPainted(false);
        b_add.setBackground(bc);
        this.add(b_add, c);

        b_add.addActionListener(e -> {
            String name = text_department_name.getText();
            int branch_id = Integer.parseInt(text_branch_id.getText());

            d.addDepartment(name, branch_id);
        });
    }
}
