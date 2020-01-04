package Management_System.UI;

import Management_System.Controller.Admins;

import javax.swing.*;
import java.awt.*;

public class Login extends JPanel{
    Admins admin = new Admins();

    //panel
    private JPanel lpanel = new JPanel();
    private JPanel intropanel = new JPanel();
    //label
    private JLabel title = new JLabel("Management System");
    private JLabel create = new JLabel("Created by:");
    private JLabel brenda = new JLabel("Brenda Spears");
    private JLabel sreeya = new JLabel("Sreeya Reddy");
    private JLabel vicky = new JLabel("Vicky Vanessa");

    private JLabel l_login = new JLabel("Admin Log In");
    private JLabel l_username = new JLabel("Username:");
    private JLabel l_password = new JLabel("Password");
    //field
    private JTextField text_username = new JTextField(20);
    private JPasswordField text_password = new JPasswordField(20);
    //button
    private JButton b_login = new JButton("Log In");

    public Login(){
        this.setSize(1140, 720);
        intropanel.setPreferredSize(new Dimension(600,700));
        lpanel.setPreferredSize(new Dimension(600, 700));

         this.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5)); //to give space between border and panel

        this.setLayout(new BorderLayout(10,0)); //set space between panel
        intropanel.setLayout(new GridBagLayout());
        lpanel.setLayout(new GridBagLayout());

        intropanel.setBackground(new Color(173, 196, 206));
        lpanel.setBackground(new Color(241, 240, 232));
        this.setBackground(new Color(238, 224,201));

        this.add(intropanel, BorderLayout.WEST);
        this.add(lpanel, BorderLayout.CENTER);

        GridBagConstraints ci = new GridBagConstraints();
        ci.insets = new Insets(1,3,1,3);

        //intropanel
        title.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
        ci.gridx = 0; ci.gridy = 1; ci.gridwidth = 5; ci.gridheight = 2; ci.weighty = .5; ci.weightx = .2;
        intropanel.add(title, ci);

        create.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));
        ci.gridx = 7; ci.gridy = 7; ci.gridwidth = 1; ci.gridheight = 1; ci.weighty = 0;
        intropanel.add(create, ci);

        brenda.setFont(new Font("Helvetica Neue", Font.BOLD, 12));
        ci.gridx = 7; ci.gridy = 8; ci.gridwidth = 1; ci.gridheight = 1;
        intropanel.add(brenda, ci);

        sreeya.setFont(new Font("Helvetica Neue", Font.BOLD, 12));
        ci.gridx = 7; ci.gridy = 9; ci.gridwidth = 1; ci.gridheight = 1;
        intropanel.add(sreeya, ci);

        vicky.setFont(new Font("Helvetica Neue", Font.BOLD, 12));
        ci.gridx = 7; ci.gridy = 10; ci.gridwidth = 1; ci.gridheight = 1;
        intropanel.add(vicky, ci);


        //lpanel
        l_login.setFont(new Font("Helvetica Neue", Font.BOLD, 25));
        ci.gridx = 0; ci.gridy = 1; ci.gridwidth = 2; ci.gridheight = 2; ci.weightx = .2;
        lpanel.add(l_login, ci);

        l_username.setFont(new Font("Helvetica Neue", Font.BOLD, 12));
        ci.gridx = 0; ci.gridy = 4; ci.gridwidth = 1; ci.gridheight = 1; ci.weighty = 0;
        lpanel.add(l_username, ci);

        l_password.setFont(new Font("Helvetica Neue", Font.BOLD, 12));
        ci.gridx = 0; ci.gridy = 5; ci.gridwidth = 1;
        lpanel.add(l_password, ci);

        ci.gridx = 1; ci.gridy = 4; ci.gridwidth = 1;
        lpanel.add(text_username, ci);

        ci.gridx = 1; ci.gridy = 5; ci.gridwidth = 1;
        lpanel.add(text_password, ci);

        b_login.setBounds(395, 270, 100, 25);
        ci.gridx = 1; ci.gridy = 6; ci.gridwidth = 1;
        lpanel.add(b_login, ci);


        intropanel.setVisible(true);
        lpanel.setVisible(true);
        this.setVisible(true);

        //action listenet
        b_login.addActionListener(e -> {
            String username = text_username.getText();
            String password = String.valueOf(text_password.getPassword());

            System.out.println("username:" + username + "\npassword:" + password);
            if(admin.chekadmin(username, password)) System.out.println(username + "logged in");

            text_username.setText("");
            text_password.setText("");
        });
    }


}
