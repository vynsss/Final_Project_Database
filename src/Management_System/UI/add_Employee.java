package Management_System.UI;

import Management_System.Controller.Employees;
import Management_System.Controller.Histories;

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
    private JLabel l_salary         = new JLabel("Salary                            :");
    //Field
    private JTextField text_fname = new JTextField(30);
    private JTextField text_lname = new JTextField(30);
    private JTextField text_email = new JTextField(30);
    private JTextField text_phone_number = new JTextField(30);
    private JTextField text_job_id = new JTextField(30);
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
        this.add(text_salary, c);

        c.fill = c.BOTH;
        c.gridx = 3; c.gridy = 9; c.gridwidth = 1;
        b_add.setBorderPainted(false);
        b_add.setFocusPainted(false);
        b_add.setBackground(bc);
        this.add(b_add, c);



        b_add.addActionListener(e -> {
            String fname = text_fname.getText();
            String lname = text_lname.getText();
            String email = text_email.getText();
            String phone_number = text_phone_number.getText();
            int job_id = Integer.parseInt(text_job_id.getText());
            Double salary = Double.parseDouble(text_salary.getText());

            int id = h.addHistory(job_id);
            em.addEmployee(id, fname, lname, email, phone_number, job_id, salary);

            text_fname.setText("");
            text_lname.setText("");
            text_email.setText("");
            text_phone_number.setText("");
            text_job_id.setText("");
            text_salary.setText("");
        });
    }

}
