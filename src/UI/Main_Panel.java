package UI;

import javax.swing.*;
import java.awt.*;

public class Main_Panel extends JPanel {

    //JPanel
    private JPanel menu = new JPanel();
    private JPanel temp = new JPanel();
    //JButton
    private JButton b_employee = new JButton("Employees");
    private JButton b_department = new JButton("Departments");
    private JButton b_job = new JButton("Jobs");
    private JButton b_branch = new JButton("Branches");
    private JButton b_admin = new JButton("Admin");
    //JLabel
    private JLabel l_space = new JLabel("");
    private JLabel l_space2 = new JLabel("");

    public Main_Panel() {
        this.setSize(1140, 720);
        menu.setPreferredSize(new Dimension(270, 760));
        temp.setPreferredSize(new Dimension(870, 760));

        this.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        menu.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));

        this.setLayout(new BorderLayout(10, 0));
        menu.setLayout(new GridLayout(7, 0, 0, 5));
        temp.setLayout(new BorderLayout());

        this.setBackground(new Color(238, 224, 201));
        menu.setBackground(new Color(223, 216, 220));

        this.add(menu, BorderLayout.WEST);
        this.add(temp, BorderLayout.CENTER);
        temp.add(new view_Employee(), BorderLayout.CENTER);

        Color click_bg = new Color(180, 186, 212);
        Color button_bg = new Color(210, 193, 206);
        b_employee.setFont(new Font("Courier", Font.BOLD, 20));
        b_employee.setBorderPainted(false);
        b_employee.setFocusPainted(false);
        b_employee.setBackground(click_bg);

        b_department.setFont(new Font("Courier", Font.BOLD, 20));
        b_department.setBorderPainted(false);
        b_department.setFocusPainted(false);
        b_department.setBackground(button_bg);

        b_job.setFont(new Font("Courier", Font.BOLD, 20));
        b_job.setBorderPainted(false);
        b_job.setFocusPainted(false);
        b_job.setBackground(button_bg);

        b_branch.setFont(new Font("Courier", Font.BOLD, 20));
        b_branch.setBorderPainted(false);
        b_branch.setFocusPainted(false);
        b_branch.setBackground(button_bg);

        b_admin.setFont(new Font("Courier", Font.BOLD, 20));
        b_admin.setBorderPainted(false);
        b_admin.setFocusPainted(false);
        b_admin.setBackground(button_bg);

        menu.add(l_space);
        menu.add(b_employee);
        menu.add(b_department);
        menu.add(b_job);
        menu.add(b_branch);
        menu.add(b_admin);
        menu.add(l_space2);

        menu.setVisible(true);
        temp.setVisible(true);
        this.setVisible(true);

        b_employee.addActionListener(e -> {
            b_employee.setBackground(click_bg);
            b_department.setBackground(button_bg);
            b_job.setBackground(button_bg);
            b_branch.setBackground(button_bg);
            b_admin.setBackground(button_bg);

            temp.removeAll();
            temp.add(new view_Employee());
            this.revalidate();
        });
        b_department.addActionListener(e -> {
            b_employee.setBackground(button_bg);
            b_department.setBackground(click_bg);
            b_job.setBackground(button_bg);
            b_branch.setBackground(button_bg);
            b_admin.setBackground(button_bg);

            temp.removeAll();
            temp.add(new view_Department());
            this.revalidate();
        });
        b_job.addActionListener(e -> {
            b_employee.setBackground(button_bg);
            b_department.setBackground(button_bg);
            b_job.setBackground(click_bg);
            b_branch.setBackground(button_bg);
            b_admin.setBackground(button_bg);

            temp.removeAll();
            temp.add(new view_Job());
            this.revalidate();
        });
        b_branch.addActionListener(e -> {
            b_employee.setBackground(button_bg);
            b_department.setBackground(button_bg);
            b_job.setBackground(button_bg);
            b_branch.setBackground(click_bg);
            b_admin.setBackground(button_bg);

            temp.removeAll();
            temp.add(new view_Branch());
            this.revalidate();
        });
        b_admin.addActionListener(e -> {
            b_employee.setBackground(button_bg);
            b_department.setBackground(button_bg);
            b_job.setBackground(button_bg);
            b_branch.setBackground(button_bg);
            b_admin.setBackground(click_bg);

            temp.removeAll();
            temp.add(new add_Employee());
            this.revalidate();
        });
    }
}
