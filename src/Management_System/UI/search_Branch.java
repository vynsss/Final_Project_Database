package Management_System.UI;

import Management_System.Controller.Branches;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class search_Branch extends JFrame {

    Branches b = new Branches();

    //JPanel
    private JPanel panel = new JPanel();
    //JTable
    private JTable table = new JTable();

    public search_Branch(String search){
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
        Object[] c_name = new Object[3];

        c_name[0] = "ID";
        c_name[1] = "Address";
        c_name[2] = "City";

        model.setColumnIdentifiers(c_name);

        Object[] data = new Object[3];
        for(int i = 0; i < b.branch(search).size(); i++){
            data[0] = b.branch(search).get(i).getId();
            data[1] = b.branch(search).get(i).getAddress();
            data[2] = b.branch(search).get(i).getCity();

            model.addRow(data);
        }

        table.setModel(model);
    }
}
