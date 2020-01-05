package Management_System.Controller;

import Management_System.Connection.Connection;
import Management_System.Access.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Employees {

    Connection connect = new Connection();

    public static ArrayList<Employee> getEmployee(){
        Connection connect = new Connection();
        ArrayList<Employee> employee = new ArrayList<Employee>();
        Employee emp;
        try {
            ResultSet myrs = connect.mystmt().executeQuery("SELECT employee.employee_id, employee.first_name, employee.last_name, employee.email, employee.phone_number, job.job_name, employee.salary, department.department_name, branch.branch_address, branch.branch_city FROM employee " +
                    "INNER JOIN department ON department.department_id = employee.department_id " +
                    "INNER JOIN branch ON department.branch_id = branch.branch_id " +
                    "INNER JOIN job ON job.job_id = employee.job_id " +
                    "INNER JOIN history ON employee.employee_id = history.employee_id " +
                    "WHERE history.end_date is null " +
                    "ORDER BY employee.employee_id DESC");
            while(myrs.next()){
                emp = new Employee(
                        Integer.toString(myrs.getInt("employee_id")),
                        myrs.getString("first_name"),
                        myrs.getString("last_name"),
                        myrs.getString("email"),
                        myrs.getString("phone_number"),
                        String.format("%.0f", myrs.getDouble("salary")),
                        myrs.getString("job_name"),
                        myrs.getString("department_name"),
                        myrs.getString("branch_address"),
                        myrs.getString("branch_city")
                );
                employee.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public ArrayList<Employee> employee(String search){
        ArrayList<Employee> employee = new ArrayList<Employee>();
        for(int i = 0; i< getEmployee().size(); i++) {
            if (getEmployee().get(i).getId().equals(search) || getEmployee().get(i).getFirst_name().equals(search) || getEmployee().get(i).getLast_name().equals(search) || getEmployee().get(i).getEmail().contains(search) || getEmployee().get(i).getPhone_number().contains(search) || getEmployee().get(i).getJob_name().contains(search) || getEmployee().get(i).getBranch_address().contains(search) || getEmployee().get(i).getBranch_city().equals(search)) employee.add(getEmployee().get(i));
        }
        return employee;
    }

    //need to enter while entering new history for employee
    public void addEmployee(int id, String fname, String lname, String email, String phone_number, int job_id, int department_id, double salary){
        try {
            PreparedStatement prepstmt =  connect.prepstmt("INSERT INTO employee (employee_id, first_name, last_name, email, phone_number, job_id, department_id, salary) " +
                    "VALUES(?,?,?,?,?,?,?,?)");
            prepstmt.setInt(1, id);
            prepstmt.setString(2, fname);
            prepstmt.setString(3, lname);
            prepstmt.setString(4, email);
            prepstmt.setString(5, phone_number);
            prepstmt.setInt(6, job_id);
            prepstmt.setInt(7, department_id);
            prepstmt.setDouble(8, salary);

            int i = prepstmt.executeUpdate();
            if(i > 0){
                System.out.println("is added");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //need to find a more efficient way
    public void updateEmployee(int id, String u_fname, String u_lname, String u_email, String u_phone_number, int u_job_id, int u_department_id, double u_salary) {
        try {
            int i;
            if(u_fname != null || u_fname != "") {
                PreparedStatement prepstmt = connect.prepstmt("UPDATE employee SET first_name = ? WHERE employee_id = ?");
                prepstmt.setString(1, u_fname);
                i = prepstmt.executeUpdate();
                if (i > 0) {
                    System.out.println("first name updated");
                }
            }
            if(u_lname != null || u_lname != "") {
                PreparedStatement prepstmt = connect.prepstmt("UPDATE employee SET last_name = ? WHERE employee_id = ?");
                prepstmt.setString(1, u_lname);
                i = prepstmt.executeUpdate();
                if (i > 0) {
                    System.out.println("last name updated");
                }
            }
            if(u_email != null || u_email != "") {
                PreparedStatement prepstmt = connect.prepstmt("UPDATE employee SET email = ? WHERE employee_id = ?");
                prepstmt.setString(1, u_email);
                i = prepstmt.executeUpdate();
                if (i > 0) {
                    System.out.println("email updated");
                }
            }
            if(u_phone_number != null || u_phone_number != "") {
                PreparedStatement prepstmt = connect.prepstmt("UPDATE employee SET phone_number = ? WHERE employee_id = ?");
                prepstmt.setString(1, u_phone_number);
                i = prepstmt.executeUpdate();
                if (i > 0) {
                    System.out.println("phone number updated");
                }
            }
            if(u_job_id > 0) {
                PreparedStatement prepstmt = connect.prepstmt("UPDATE employee SET job_id = ? WHERE employee_id = ?");
                prepstmt.setInt(1, u_job_id);
                i = prepstmt.executeUpdate();
                if (i > 0) {
                    System.out.println("job updated");
                }
            }
            if(u_department_id > 0) {
                PreparedStatement prepstmt = connect.prepstmt("UPDATE employee SET department_id = ? WHERE employee_id = ?");
                prepstmt.setInt(1, u_department_id);
                i = prepstmt.executeUpdate();
                if (i > 0) {
                    System.out.println("department updated");
                }
            }
            if(u_salary > 0) {
                PreparedStatement prepstmt = connect.prepstmt("UPDATE employee SET salary = ? WHERE employee_id = ?");
                prepstmt.setDouble(1, u_salary);
                i = prepstmt.executeUpdate();
                if (i > 0) {
                    System.out.println("salary updated");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
