package Management_System.Access;

public class Job {

    private String id;
    private String name;
    private String min_salary;
    private String department_name;
    private String branch_address;
    private String branch_city;

    public Job(String id, String name, String min_salary, String department_name, String branch_address, String branch_city){
        this.id = id;
        this.name = name;
        this.min_salary = min_salary;
        this.department_name = department_name;
        this.branch_address = branch_address;
        this.branch_city = branch_city;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMin_salary() {
        return min_salary;
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
