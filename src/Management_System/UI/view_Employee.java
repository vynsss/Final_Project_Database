package Management_System.UI;

import Management_System.Controller.Employees;
import Management_System.Controller.Histories;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class view_Employee extends JPanel {
    Employees em = new Employees();
    Histories h = new Histories();
    add_Employee ae = new add_Employee();

    //JPanel
    private JPanel view = new JPanel();
    //JLabel
    private JLabel l_search = new JLabel("Search:");
    //Field
    private JTextField text_search = new JTextField(20);
    //JButton
    private JButton b_search = new JButton("Search");
    private JButton b_add = new JButton("Add");
    private JButton b_quit = new JButton("Quit");
    private JButton b_update = new JButton("Update");
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

        table.setPreferredSize(new Dimension(870, 760));
        table();
        c.gridx = 0; c.gridy = 1; c.gridwidth = 9;
        c.weighty = 1.0;
        JScrollPane pane = new JScrollPane(table);
        view.add(pane, c);

        c.weighty = .0;
        c.gridx = 6; c.gridy = 2; c.gridwidth = 1;
        b_update.setBorderPainted(false);
        b_update.setFocusPainted(false);
        b_update.setBackground(bc);
        view.add(b_quit, c);
        c.gridx = 7; c.gridy = 2; c.gridwidth = 1;
        b_quit.setBorderPainted(false);
        b_quit.setFocusPainted(false);
        b_quit.setBackground(bc);
        view.add(b_quit, c);
        c.gridx = 8; c.gridy = 2; c.gridwidth = 1;
        b_add.setBorderPainted(false);
        b_add.setFocusPainted(false);
        b_add.setBackground(bc);
        view.add(b_add, c);

        view.setVisible(true);

        b_search.addActionListener(e -> {
            String search = text_search.getText();
            new search_Employee(search);
            text_search.setText("");
        });

        b_update.addActionListener(e -> {
            int column = 0;
            int row = table.getSelectedRow();
            int id = Integer.parseInt(table.getModel().getValueAt(row, column).toString());

            this.removeAll();
            this.add(new update_Employee(id));
            this.validate();
        });

        b_quit.addActionListener(e -> {
            int column = 0;
            int row = table.getSelectedRow();
            int id = Integer.parseInt(table.getModel().getValueAt(row, column).toString());

            h.updateHistory(id);
            this.revalidate();
        });

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
        for(int i = 0; i < em.getEmployee().size(); i++){
            data[0] = em.getEmployee().get(i).getId();
            data[1] = em.getEmployee().get(i).getFirst_name();
            data[2] = em.getEmployee().get(i).getLast_name();
            data[3] = em.getEmployee().get(i).getEmail();
            data[4] = em.getEmployee().get(i).getPhone_number();
            data[5] = em.getEmployee().get(i).getSalary();
            data[6] = em.getEmployee().get(i).getJob_name();
            data[7] = em.getEmployee().get(i).getDepartment_name();
            data[8] = em.getEmployee().get(i).getBranch_address();
            data[9] = em.getEmployee().get(i).getBranch_city();

            model.addRow(data);
        }

        table.setModel(model);
    }

}
