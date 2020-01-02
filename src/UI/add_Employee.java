package UI;

import Controller.Employees;
import Controller.Histories;

import javax.swing.*;
import java.awt.*;

public class add_Employee extends JPanel{

    Employees em = new Employees();
    Histories h = new Histories();

    //JLabel
    private JLabel l_fname          = new JLabel("First Name                        :");
    private JLabel l_lname          = new JLabel("Last Name                        :");
    private JLabel l_email          = new JLabel("Email Address                   :");
    private JLabel l_phone_number   = new JLabel("Phone Number                       :");
    private JLabel l_job_id         = new JLabel("Job ID                            :");
    private JLabel l_department_id  = new JLabel("Department ID                   :");
    private JLabel l_salary         = new JLabel("Start                            :");
    //Field
    private JTextField text_fname = new JTextField(30);
    private JTextField text_lname = new JTextField(30);
    private JTextField text_email = new JTextField(30);
    private JTextField text_phone_number = new JTextField(30);
    private JTextField text_job_id = new JTextField(30);
    private JTextField text_department_id = new JTextField(30);
    private JTextField text_salary = new JTextField(30);
    //JButton
    private JButton b_add = new JButton("Add");

    public add_Employee(){
        this.setSize(new Dimension(870, 760));
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(241, 240, 232));

        Color bc = new Color(173, 196, 206);

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(3,3,3,10);

        c.weightx = 1.0; c.fill = c.BOTH;
        c.gridx = 0; c.gridy = 0; c.gridwidth = 1;
        this.add(l_fname, c);
        c.gridx = 0; c.gridy = 1; c.gridwidth = 1;
        this.add(l_lname, c);
        c.gridx = 0; c.gridy = 2; c.gridwidth = 1;
        this.add(l_email, c);
        c.gridx = 0; c.gridy = 3; c.gridwidth = 1;
        this.add(l_phone_number, c);
        c.gridx = 0; c.gridy = 4; c.gridwidth = 1;
        this.add(l_job_id, c);
        c.gridx = 0; c.gridy = 5; c.gridwidth = 1;
        this.add(l_department_id, c);
        c.gridx = 0; c.gridy = 6; c.gridwidth = 1;
        this.add(l_salary, c);

        c.fill = c.NONE;
        c.gridx = 1; c.gridy = 0; c.gridwidth = 1;
        this.add(text_fname, c);
        c.gridx = 1; c.gridy = 1; c.gridwidth = 1;
        this.add(text_lname, c);
        c.gridx = 1; c.gridy = 2; c.gridwidth = 1;
        this.add(text_email, c);
        c.gridx = 1; c.gridy = 3; c.gridwidth = 1;
        this.add(text_phone_number, c);
        c.gridx = 1; c.gridy = 4; c.gridwidth = 1;
        this.add(text_job_id, c);
        c.gridx = 1; c.gridy = 5; c.gridwidth = 1;
        this.add(text_department_id, c);
        c.gridx = 1; c.gridy = 6; c.gridwidth = 1;
        this.add(text_salary, c);

        c.fill = c.BOTH;
        c.gridx = 3; c.gridy = 9; c.gridwidth = 1;
        b_add.setBorderPainted(false);
        b_add.setFocusPainted(false);
        b_add.setBackground(bc);
        this.add(b_add, c);



        b_add.addActionListener(e -> {
            String fname = l_fname.getText();
            String lname = l_lname.getText();
            String email = l_email.getText();
            String phone_number = l_phone_number.getText();
            int job_id = Integer.parseInt(l_job_id.getText());
            int department_id = Integer.parseInt(l_department_id.getText());
            Double salary = Double.parseDouble(l_salary.getText());

            h.addHistory(job_id, department_id);
            em.addEmployee(fname, lname, email, phone_number, job_id, department_id, salary);
        });
    }

}
