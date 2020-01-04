package Management_System.Access;

public class Employee {

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private double salary;
    private String job_name;
    private String department_name;
    private String branch_address;
    private String branch_city;

    public Employee(int id, String first_name, String last_name, String email, String phone_number, double salary, String job_name, String department_name, String branch_address, String branch_city){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.salary = salary;
        this.job_name = job_name;
        this.department_name = department_name;
        this.branch_city = branch_city;
        this.branch_address = branch_address;
    }


    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public double getSalary() {
        return salary;
    }

    public String getJob_name() {
        return job_name;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public String getBranch_address() {
        return branch_address;
    }

    public String getBranch_city() {
        return branch_city;
    }


}
