package Management_System.UI;

import Management_System.Controller.Jobs;

import javax.swing.*;
import java.awt.*;

public class add_Job extends JPanel{

    Jobs j = new Jobs();

    //JLabel
    private JLabel l_name = new JLabel("Job Name               :");
    private JLabel l_min_salary = new JLabel("Minimum Salary                :");
    //Field
    private JTextField text_name = new JTextField(30);
    private JTextField text_min_salary = new JTextField(30);
    //JButton
    private JButton b_add = new JButton("Add");

    public add_Job(){
        this.setSize(new Dimension(870, 760));
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(241, 240, 232));

        Color bc = new Color(173, 196, 206);

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(3,3,3,10);

        c.weightx = 1.0; c.fill = c.BOTH;
        c.gridx = 0; c.gridy = 0; c.gridwidth = 1;
        this.add(l_name, c);
        c.gridx = 0; c.gridy = 1; c.gridwidth = 1;
        this.add(l_min_salary, c);

        c.fill = c.NONE;
        c.gridx = 1; c.gridy = 0; c.gridwidth = 1;
        this.add(text_name, c);
        c.gridx = 1; c.gridy = 1; c.gridwidth = 1;
        this.add(text_min_salary, c);

        c.fill = c.BOTH;
        c.gridx = 3; c.gridy = 9; c.gridwidth = 1;
        b_add.setBorderPainted(false);
        b_add.setFocusPainted(false);
        b_add.setBackground(bc);
        this.add(b_add, c);

        b_add.addActionListener(e -> {
            String address = text_name.getText();
            double city = Double.parseDouble(text_min_salary.getText());

            j.addJob(address, city);
        });}
}
