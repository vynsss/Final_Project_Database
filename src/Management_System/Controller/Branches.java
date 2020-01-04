package Management_System.Controller;

import Management_System.Access.Branch;
import Management_System.Connection.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Branches {

    Connection connect = new Connection();

    public static ArrayList<Branch> getBranches(){
        Connection connect = new Connection();
        ArrayList<Branch> branch = new ArrayList<Branch>();
        Branch b;
        try {
            ResultSet myrs = connect.mystmt().executeQuery("SELECT * FROM branch ORDER BY branch_city DESC");
            while(myrs.next()){
                b = new Branch(
                        Integer.toString(myrs.getInt("branch_id")),
                        myrs.getString("branch_address"),
                        myrs.getString("branch_city")
                );
                branch.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return branch;
    }

    public ArrayList<Branch> branch(String search){
        ArrayList<Branch> branch = new ArrayList<Branch>();
        for(int i = 0; i< getBranches().size(); i++) {
            if (getBranches().get(i).getId().equals(search) || getBranches().get(i).getAddress().contains(search) || getBranches().get(i).getCity().equals(search)) branch.add(getBranches().get(i));
        }
        return branch;
    }

    public void addBranch(String address, String city){
        try {
            PreparedStatement prepstmt =  connect.prepstmt("INSERT INTO branch(branch_address, branch_city) " +
                "VALUES(?,?)");
            prepstmt.setString(1, address);
            prepstmt.setString(2, city);

            int i = prepstmt.executeUpdate();
            if(i > 0){
                System.out.println("is added");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBranch(int id){
        try {
            PreparedStatement prepstmt = connect.prepstmt("DELETE FROM branch WHERE branch_id = ?");
            prepstmt.setInt(1, id);
            int i = prepstmt.executeUpdate();
            if (i > 0) {
                System.out.println("branch id" + id + "is deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
