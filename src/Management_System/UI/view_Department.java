package Management_System.UI;

import Management_System.Controller.Departments;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class view_Department extends JPanel {

    Departments d = new Departments();

    //JPanel
    private JPanel view = new JPanel();
    //JLabel
    private JLabel l_search = new JLabel("Search:");
    //Field
    private JTextField text_search = new JTextField(20);
    //JButton
    private JButton b_search = new JButton("Search");
    private JButton b_delete = new JButton("Delete");
    private JButton b_add = new JButton("Add");
    //JTable
    private JTable table = new JTable();


    public view_Department(){
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

        c.gridx = 7; c.gridy = 0; c.gridwidth = 1; c.weighty = .0;
        b_delete.setBorderPainted(false);
        b_delete.setFocusPainted(false);
        b_delete.setBackground(bc);
        view.add(b_delete, c);
        c.gridx = 8; c.gridy = 2; c.gridwidth = 1;
        b_add.setBorderPainted(false);
        b_add.setFocusPainted(false);
        b_add.setBackground(bc);
        view.add(b_add, c);

        view.setVisible(true);

        b_search.addActionListener(e -> {
            String search = text_search.getText();
            new search_Department(search);
        });

        b_delete.addActionListener(e -> {
            int column = 0;
            int row = table.getSelectedRow();
            int id = Integer.parseInt(table.getModel().getValueAt(row, column).toString());

            d.deleteDepartment(id);
            this.revalidate();
        });

        b_add.addActionListener(e -> {
            this.removeAll();
            this.add(new add_Department());
            this.validate();
        });
    }

    private void table(){
        DefaultTableModel model = new DefaultTableModel();
        Object[] c_name = new Object[4];

        c_name[0] = "ID";
        c_name[1] = "Name";
        c_name[2] = "Address";
        c_name[3] = "City";

        model.setColumnIdentifiers(c_name);

        Object[] data = new Object[4];
        for(int i = 0; i < d.getDepartments().size(); i++){
            data[0] = d.getDepartments().get(i).getId();
            data[1] = d.getDepartments().get(i).getName();
            data[2] = d.getDepartments().get(i).getBranch_address();
            data[3] = d.getDepartments().get(i).getBranch_city();

            model.addRow(data);
        }

        table.setModel(model);
    }

}
