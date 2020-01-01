package UI;

import Controller.Employees;
import Controller.Histories;

import javax.swing.*;
import java.awt.*;

public class vEmployee extends JPanel {
    Employees e = new Employees();
    Histories h = new Histories();

    //JLabel
    private JLabel l_search = new JLabel("Search:");
    //Field
    private JTextField text_search = new JTextField(20);
    //JButton
    private JButton b_search = new JButton("Search");
    //JTable
    private JTable table = new JTable();

    public vEmployee(){
        this.setSize(new Dimension(870, 760));
        this.setBackground(new Color(241, 240, 232));
        this.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(3,3,3,3);

        c.gridx = 0; c.gridy = 0; c.gridwidth = 1;
        this.add(l_search, c);
        c.gridx = 1; c.gridy = 0;
        this.add(text_search, c);
        c.gridx = 0; c.gridy = 1; c.gridwidth = 2;
        this.add(table, c);
    }
}
