package Management_System.UI;

import Management_System.Controller.Jobs;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class search_Job extends JFrame {

    Jobs j = new Jobs();

    //JPanel
    private JPanel panel = new JPanel();
    //JTable
    private JTable table = new JTable();

    public search_Job(String search){
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
        Object[] c_name = new Object[5];

        c_name[0] = "ID";
        c_name[1] = "Name";
        c_name[2] = "Min. Salary";
        c_name[4] = "Branch City";

        model.setColumnIdentifiers(c_name);

        Object[] data = new Object[5];
        for(int i = 0; i < j.job(search).size(); i++){
            data[0] = j.job(search).get(i).getId();
            data[1] = j.job(search).get(i).getName();
            data[2] = j.job(search).get(i).getMin_salary();
            data[3] = j.job(search).get(i).getBranch_address();
            data[4] = j.job(search).get(i).getBranch_city();

            model.addRow(data);
        }

        table.setModel(model);
    }
}
