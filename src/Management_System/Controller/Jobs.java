package Management_System.Controller;

import Management_System.Connection.Connection;
import Management_System.Access.Job;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Jobs {

    Connection connect = new Connection();

    public static ArrayList<Job> getJobs(){
        Connection connect = new Connection();
        ArrayList<Job> job = new ArrayList<Job>();
        Job j;
        try {
            ResultSet myrs = connect.mystmt().executeQuery("SELECT * FROM job ORDER BY job_name DESC");
            while(myrs.next()){
                j = new Job(
                        Integer.toString(myrs.getInt("job_id")),
                        myrs.getString("job_name"),
                        String.format("%.0f", myrs.getDouble("min_salary"))
                );
                job.add(j);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return job;
    }

    public ArrayList<Job> job(String search){
        ArrayList<Job> job = new ArrayList<Job>();
        for(int i = 0; i< getJobs().size(); i++) {
            if (getJobs().get(i).getId().equals(search) || getJobs().get(i).getName().contains(search)) job.add(getJobs().get(i));
        }
        return job;
    }

    public void addJob(String name, double min_salary){
        try {
            PreparedStatement prepstmt =  connect.prepstmt("INSERT INTO job(job_name, min_salary) " +
                    "VALUES(?,?)");
            prepstmt.setString(1, name);
            prepstmt.setDouble(2, min_salary);

            int i = prepstmt.executeUpdate();
            if(i > 0){
                System.out.println("is added");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteJob(int id){
        try {
            PreparedStatement prepstmt = connect.prepstmt("DELETE FROM job WHERE job_id = ?");
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
