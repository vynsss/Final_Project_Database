package Management_System.UI;

import Management_System.Controller.Histories;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class view_allEmployee extends JPanel {
    Histories h = new Histories();

    //JPanel
    private JPanel view = new JPanel();
    //JLabel
    private JLabel l_search = new JLabel("Search:");
    //Field
    private JTextField text_search = new JTextField(20);
    //JButton
    private JButton b_search = new JButton("Search");
    //JTable
    private JTable table = new JTable();

    public view_allEmployee(){
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
        b_search.setBorderPainted(false);
        b_search.setFocusPainted(false);
        b_search.setBackground(bc);
        view.add(b_search, c);
        table.setPreferredSize(new Dimension(870, 760));
        table();
        c.gridx = 0; c.gridy = 1; c.gridwidth = 7;
        c.weighty = 1.0;
        JScrollPane pane = new JScrollPane(table);
        view.add(pane, c);

        view.setVisible(true);

        b_search.addActionListener(e -> {
            String search = text_search.getText();
            new search_Employee(search);
        });

    }

    private void table(){
        DefaultTableModel model = new DefaultTableModel();
        Object[] c_name = new Object[9];

        c_name[0] = "ID";
        c_name[1] = "First Name";
        c_name[2] = "Last Name";
        c_name[3] = "Hire Date";
        c_name[4] = "End Date";
        c_name[5] = "Job Title";
        c_name[6] = "Department Name";
        c_name[7] = "Branch Address";
        c_name[8] = "Branch City";

        model.setColumnIdentifiers(c_name);

        Object[] data = new Object[9];
        for(int i = 0; i < h.getHistory().size(); i++){
            data[0] = h.getHistory().get(i).getId();
            data[1] = h.getHistory().get(i).getFirst_name();
            data[2] = h.getHistory().get(i).getLast_name();
            data[3] = h.getHistory().get(i).getHire_date();
            data[4] = h.getHistory().get(i).getEnd_date();
            data[5] = h.getHistory().get(i).getJob_name();
            data[6] = h.getHistory().get(i).getDepartment_name();
            data[7] = h.getHistory().get(i).getBranch_address();
            data[8] = h.getHistory().get(i).getBranch_city();

            model.addRow(data);
        }

        table.setModel(model);
    }

}
