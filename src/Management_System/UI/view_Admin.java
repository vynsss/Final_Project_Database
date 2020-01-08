package Management_System.UI;

import Management_System.Management_System;

import javax.swing.*;
import java.awt.*;

public class view_Admin extends JPanel{

    Management_System ms = new Management_System();
    //JPanel
    private JPanel view = new JPanel();
    //JLabel
    private JLabel l_hello = new JLabel("HELLO", SwingConstants.CENTER);
    private JLabel l_user = new JLabel("", SwingConstants.CENTER);
    //JButton
    private JButton b_add = new JButton("Add");
    private JButton b_remove = new JButton("Remove");
    private JButton b_log_out = new JButton("Log Out");

    public view_Admin(){
        this.setSize(new Dimension(870, 760));
        this.setLayout(new BorderLayout());

        view.setSize(new Dimension(870, 760));
        view.setLayout(new GridBagLayout());
        view.setBackground(new Color(241, 240, 232));
        this.add(view, BorderLayout.CENTER);

        this.setBorder(BorderFactory.createEmptyBorder(10, 235, 10, 235));

        Color bc = new Color(173, 196, 206);

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,3,5,3);

        GridBagConstraints cb = new GridBagConstraints();
        cb.insets = new Insets(15,3,5,3);

        c.weightx = 1.0; c.fill = c.BOTH;
        c.gridx = 0; c.gridy = 0; c.gridwidth = 4;
        l_hello.setFont(new Font("Helvetica", Font.BOLD, 30));
        view.add(l_hello, c);
        c.gridx = 1; c.gridy = 1; c.gridwidth = 1;
        l_user.setText("dot dot dot");
        l_user.setFont(new Font("Helvetica", Font.BOLD, 25));
        view.add(l_user, c);
//        cb.weighty = 1.0;
        cb.weightx = 1.0; cb.fill = cb.BOTH;
        cb.gridx = 1; cb.gridy = 2; cb.gridwidth = 1; cb.gridheight = 1;
        b_add.setBorderPainted(false);
        b_add.setFocusPainted(false);
        b_add.setBackground(bc);
        b_add.setFont(new Font("Helvetica", Font.BOLD, 20));
        view.add(b_add, cb);
        cb.gridx = 1; cb.gridy = 3; cb.gridwidth = 1;
        b_remove.setBorderPainted(false);
        b_remove.setFocusPainted(false);
        b_remove.setBackground(bc);
        b_remove.setFont(new Font("Helvetica", Font.BOLD, 20));
        view.add(b_remove, cb);
        cb.gridx = 1; cb.gridy = 4; cb.gridwidth = 1;
        b_log_out.setBorderPainted(false);
        b_log_out.setFocusPainted(false);
        b_log_out.setBackground(bc);
        b_log_out.setFont(new Font("Helvetica", Font.BOLD, 20));
        view.add(b_log_out, cb);

        b_add.addActionListener(e -> {
            this.removeAll();
            this.add(new add_Admin());
            this.revalidate();
        });
        b_remove.addActionListener(e -> {

        });
        b_log_out.addActionListener(e -> {
            ms.getWindow().setLogin(new Login());
            ms.getWindow().setContentPane(ms.getWindow().getLogin());
            ms.getWindow().revalidate();
        });
    }
}
