package Management_System.Controller;

import Management_System.Access.Admin;
import Management_System.Connection.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Admins {

    Connection connect = new Connection();

    private static String user;

    public static ArrayList<Admin> getJobs(){
        Connection connect = new Connection();
        ArrayList<Admin> admin = new ArrayList<Admin>();
        Admin a;
        try {
            ResultSet myrs = connect.mystmt().executeQuery("SELECT * FROM admin");
            while(myrs.next()){
                a = new Admin(
                        myrs.getString("username"),
                        myrs.getString("password")
                );
                admin.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    //to check the authentication when someone is logging in or someone want to make a new user
    public boolean chekadmin(String username, String password){
        for(int i = 0; i< getJobs().size(); i++) {
            if (getJobs().get(i).getUsername().equals(username) && getJobs().get(i).getPassword().equals(password)) return true;
            else if (getJobs().get(i).getUsername().equals(username)) return false; // need to check if this work or nah
            System.out.println("hmmm");
        }
        return false;
    }

    public void addAdmin(String username, String password){
        if(!chekadmin(username, password)) {
            try {
                PreparedStatement prepstmt = connect.prepstmt("INSERT INTO admin(username, password) " +
                        "VALUES(?,?)");
                prepstmt.setString(1, username);
                prepstmt.setString(2, password);

                int i = prepstmt.executeUpdate();
                if (i > 0) {
                    System.out.println("is added");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeAdmin(String username, String password){
        try {
            PreparedStatement prepstmt = connect.prepstmt("DELETE FROM admin WHERE username = ? AND password = ?");
            prepstmt.setString(1, username);
            prepstmt.setString(2, password);
            int i = prepstmt.executeUpdate();
            if (i > 0) {
                System.out.println("admin deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
