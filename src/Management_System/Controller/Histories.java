package Management_System.Controller;

import Management_System.Connection.Connection;
import Management_System.Access.History;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Histories {

    Connection connect = new Connection();

    public static ArrayList<History> getHistory(){
        Connection connect = new Connection();
        ArrayList<History> history = new ArrayList<History>();
        History h;
        try {
            ResultSet myrs = connect.mystmt().executeQuery("SELECT history.employee_id, employee.first_name, employee.last_name, history.hire_date, history.end_date, job.job_name, department.department_name, branch.branch_address, branch.branch_city FROM history " +
                    "INNER JOIN department ON department.department_id = history.department_id " +
                    "INNER JOIN branch ON department.branch_id = branch.branch_id " +
                    "INNER JOIN job ON job.job_id = history.job_id " +
                    "INNER JOIN employee ON employee.employee_id = history.employee_id");
            while(myrs.next()){
                h = new History(
                        Integer.toString(myrs.getInt("employee_id")),
                        myrs.getString("first_name"),
                        myrs.getString("last_name"),
                        myrs.getString("hire_date"),
                        myrs.getString("end_date"),
                        myrs.getString("job_name"),
                        myrs.getString("department_name"),
                        myrs.getString("branch_address"),
                        myrs.getString("branch_city")
                );
                history.add(h);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return history;
    }

    public ArrayList<History> history(String search){
        ArrayList<History> history = new ArrayList<History>();
        for(int i = 0; i< getHistory().size(); i++) {
            if (getHistory().get(i).getId().equals(search) || getHistory().get(i).getFirst_name().equals(search) || getHistory().get(i).getLast_name().equals(search) || getHistory().get(i).getBranch_address().contains(search) || getHistory().get(i).getBranch_city().equals(search)) history.add(getHistory().get(i));
        }
        return history;
    }

    //need to enter while entering new data for employee
    public void addHistory(int job_id, int department_id){
        try {
            PreparedStatement prepstmt =  connect.prepstmt("INSERT INTO history(hire_dat, job_id, department_id) " +
                    "VALUES(CURDATE(),?,?)");
            prepstmt.setInt(1, job_id);
            prepstmt.setInt(2, department_id);

            int i = prepstmt.executeUpdate();
            if(i > 0){
                System.out.println("is added");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //to update when is the end date of the employee
    public void updateHistory(int id) {
        try {
            PreparedStatement prepstmt = connect.prepstmt("UPDATE history set end_date = CURDATE() WHERE employee_id = ?");
            prepstmt.setInt(1, id);
            int i = prepstmt.executeUpdate();
            if (i > 0) {
                System.out.println("update history");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
