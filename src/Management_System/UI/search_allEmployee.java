package Management_System.UI;

import Management_System.Controller.Histories;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class search_allEmployee extends JFrame {

    Histories h = new Histories();

    //JPanel
    private JPanel panel = new JPanel();
    //JTable
    private JTable table = new JTable();

    public search_allEmployee(String search){
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(870, 700));

        panel.setSize(new Dimension(870, 700));
        panel.setBackground(new Color(241, 240, 232));
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        this.add(panel, BorderLayout.CENTER);

        table.setPreferredSize(new Dimension(800, 650));
        search_table(search);
        JScrollPane pane = new JScrollPane(table);
        panel.add(pane, BorderLayout.CENTER);

        this.setContentPane(panel);
        panel.setVisible(true);
        this.setVisible(true);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void search_table(String search){

        DefaultTableModel model = new DefaultTableModel();
        Object[] c_name = new Object[10];

        c_name[0] = "ID";
        c_name[1] = "First Name";
        c_name[2] = "Last Name";
        c_name[3] = "Hire Date";
        c_name[4] = "End date";
        c_name[5] = "Job Title";
        c_name[6] = "Department Name";
        c_name[7] = "Branch Address";
        c_name[8] = "Branch City";

        model.setColumnIdentifiers(c_name);

        Object[] data = new Object[9];
        for(int i = 0; i < h.getHistory().size(); i++){
            data[0] = h.history(search).get(i).getId();
            data[1] = h.history(search).get(i).getFirst_name();
            data[2] = h.history(search).get(i).getLast_name();
            data[3] = h.history(search).get(i).getHire_date();
            data[4] = h.history(search).get(i).getEnd_date();
            data[5] = h.history(search).get(i).getJob_name();
            data[6] = h.history(search).get(i).getDepartment_name();
            data[7] = h.history(search).get(i).getBranch_address();
            data[8] = h.history(search).get(i).getBranch_city();

            model.addRow(data);
        }

        table.setModel(model);
    }
}
