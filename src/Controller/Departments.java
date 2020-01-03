package Controller;

import Connection.Connection;
import Access.Department;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Departments {

    Connection connect = new Connection();

    public static ArrayList<Department> getDepartments(){
        Connection connect = new Connection();
        ArrayList<Department> department = new ArrayList<Department>();
        Department d;
        try {
            ResultSet myrs = connect.mystmt().executeQuery("SELECT department.department_id, department.department_name, branch.branch_address, branch.branch_city FROM department INNER JOIN branch ON department.branch_id = branch.branch_id ORDER BY department_name DESC");
            while(myrs.next()){
                d = new Department(
                        myrs.getInt("department_id"),
                        myrs.getString("department_name"),
                        myrs.getString("branch_address"),
                        myrs.getString("branch_city")
                );
                department.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    public ArrayList<Department> department(int id, String address, String city){
        ArrayList<Department> department = new ArrayList<Department>();
        for(int i = 0; i< getDepartments().size(); i++) {
            if (getDepartments().get(i).getId() == id) department.add(getDepartments().get(i));
            else if (getDepartments().get(i).getBranch_address().equals(address)) department.add(getDepartments().get(i));
            else if (getDepartments().get(i).getBranch_city().equals(city)) department.add(getDepartments().get(i));
        }
        return department;
    }

    public void addDepartment(String name, int branch_id){
        try {
            PreparedStatement prepstmt =  connect.prepstmt("INSERT INTO branch(department_name, branch_id) " +
                    "VALUES(?,?,?)");
            prepstmt.setString(1, name);
            prepstmt.setInt(2, branch_id);

            int i = prepstmt.executeUpdate();
            if(i > 0){
                System.out.println("is added");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDepartment(int id){
        try {
            PreparedStatement prepstmt = connect.prepstmt("DELETE FROM department WHERE branch_id = ?");
            prepstmt.setInt(1, id);
            int i = prepstmt.executeUpdate();
            if (i > 0) {
                System.out.println("department id" + id + "is deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
