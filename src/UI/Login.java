package UI;

import Controller.Admins;

import javax.swing.*;
import java.awt.*;

public class Login extends JPanel{
    Admins admin = new Admins();

    //panel
    private JPanel lpanel = new JPanel();
    private JPanel intropanel = new JPanel();
    //label
    private JLabel username = new JLabel();
    private JLabel title = new JLabel("Management System");
    private JLabel create = new JLabel("Created by:");
    private JLabel brenda = new JLabel("Brenda Spears");
    private JLabel sreeya = new JLabel("Sreeya Reddy");
    private JLabel vicky = new JLabel("Vicky Vanessa");
    //field
    private JTextField text_username = new JTextField();
    //button
    private JButton login = new JButton();

    public Login(){
        this.setSize(950, 450);
        intropanel.setPreferredSize(new Dimension(380,480));
        lpanel.setPreferredSize(new Dimension(570, 480));

        //panel
        this.setLayout(new BorderLayout(5,0));
        intropanel.setLayout(new GridBagLayout());
        lpanel.setLayout(new GridBagLayout());

        intropanel.setBackground(new Color(255, 255, 0));
        lpanel.setBackground(new Color(0, 5, 198));
        this.setBackground(new Color(255, 0,0));

        this.add(intropanel, BorderLayout.WEST);
        this.add(lpanel, BorderLayout.CENTER);

        this.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));

        //intropanel
        GridBagConstraints ci = new GridBagConstraints();
        ci.insets = new Insets(1,3,1,3);

        title.setFont(new Font("Helvetuca Neuve", Font.PLAIN, 30));
        ci.gridx = 0; ci.gridy = 1; ci.gridwidth = 2; ci.gridheight = 2; ci.weighty = .5;
        intropanel.add(title, ci);

        create.setFont(new Font("Helvetuca Neuve", Font.PLAIN, 12));
        ci.gridx = 2; ci.gridy = 7; ci.gridwidth = 1; ci.gridheight = 1; ci.weighty = 0;
        intropanel.add(create, ci);

        brenda.setFont(new Font("Helvetuca Neuve", Font.BOLD, 12));
        ci.gridx = 2; ci.gridy = 8; ci.gridwidth = 1; ci.gridheight = 1;
        intropanel.add(brenda, ci);

        sreeya.setFont(new Font("Helvetuca Neuve", Font.BOLD, 12));
        ci.gridx = 2; ci.gridy = 9; ci.gridwidth = 1; ci.gridheight = 1;
        intropanel.add(sreeya, ci);

        vicky.setFont(new Font("Helvetuca Neuve", Font.BOLD, 12));
        ci.gridx = 2; ci.gridy = 10; ci.gridwidth = 1; ci.gridheight = 1;
        intropanel.add(vicky, ci);


        //lpanel


        intropanel.setVisible(true);
        lpanel.setVisible(true);
        this.setVisible(true);
    }

}
