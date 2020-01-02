package UI;

import Controller.Employees;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class view_Employee extends JPanel {
    Employees e = new Employees();
    add_Employee ae = new add_Employee();

    //JPanel
    private JPanel view = new JPanel();
    //JLabel
    private JLabel l_search = new JLabel("Search:");
    //Field
    private JTextField text_search = new JTextField(20);
    //JButton
    private JButton b_search = new JButton("Search");
    private JButton b_cancel = new JButton("Cancel");
    private JButton b_add = new JButton("Add");
    //JTable
    private JTable table = new JTable();

    public view_Employee(){
        this.setSize(new Dimension(870, 760));
        this.setLayout(new BorderLayout());

        view.setSize(new Dimension(870, 760));
        view.setLayout(new GridBagLayout());
        view.setBackground(new Color(241, 240, 232));
        this.add(view, BorderLayout.CENTER);

        Color bc = new Color(173, 196, 206);

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(3,3,3,10);

        c.weightx = 1.0; c.fill = c.BOTH;
        c.gridx = 0; c.gridy = 0; c.gridwidth = 2;
        view.add(l_search, c);
        c.gridx = 2; c.gridy = 0; c.gridwidth = 3;
        view.add(text_search, c);
        c.gridx = 5; c.gridy = 0; c.gridwidth = 2;
        view.add(b_search, c);
        c.gridx = 7; c.gridy = 0; c.gridwidth = 2;
        b_search.setBorderPainted(false);
        b_search.setFocusPainted(false);
        b_search.setBackground(bc);
        view.add(b_search, c);
        c.gridx = 9; c.gridy = 0; c.gridwidth = 2;
        b_cancel.setBorderPainted(false);
        b_cancel.setFocusPainted(false);
        b_cancel.setBackground(bc);
        view.add(b_cancel, c);

        System.out.println(e.getEmployee().size());

        table.setPreferredSize(new Dimension(870, 760));
        table();
        c.gridx = 0; c.gridy = 1; c.gridwidth = 11;
        c.weighty = 1.0;
        JScrollPane pane = new JScrollPane(table);
//        pane.setBounds(10, 218, 870, 700);
        view.add(pane, c);

        c.gridx = 10; c.gridy = 2; c.gridwidth = 1; c.weighty = .0;
        b_add.setBorderPainted(false);
        b_add.setFocusPainted(false);
        b_add.setBackground(bc);
        view.add(b_add, c);

        view.setVisible(true);

        b_add.addActionListener(e -> {
            this.removeAll();
            this.add(ae);
            this.validate();
        });
    }

    private void table(){
        DefaultTableModel model = new DefaultTableModel();
        Object[] c_name = new Object[10];

        c_name[0] = "ID";
        c_name[1] = "First Name";
        c_name[2] = "Last Name";
        c_name[3] = "Email";
        c_name[4] = "Phone Number";
        c_name[5] = "Salary";
        c_name[6] = "Job Title";
        c_name[7] = "Department Name";
        c_name[8] = "Branch Address";
        c_name[9] = "Branch City";

        model.setColumnIdentifiers(c_name);

        Object[] data = new Object[10];
        for(int i = 0; i < e.getEmployee().size(); i++){
            data[0] = e.getEmployee().get(i).getId();
            data[1] = e.getEmployee().get(i).getFirst_name();
            data[2] = e.getEmployee().get(i).getLast_name();
            data[3] = e.getEmployee().get(i).getEmail();
            data[4] = e.getEmployee().get(i).getPhone_number();
            data[5] = e.getEmployee().get(i).getSalary();
            data[6] = e.getEmployee().get(i).getJob_name();
            data[7] = e.getEmployee().get(i).getDepartment_name();
            data[8] = e.getEmployee().get(i).getBranch_address();
            data[9] = e.getEmployee().get(i).getBranch_city();

            model.addRow(data);
        }

        table.setModel(model);
    }
}
