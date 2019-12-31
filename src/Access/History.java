package Access;

public class History {

    private int id;
    private String hire_date;
    private String first_name;
    private String last_name;
    private String start_date;
    private String end_date;
    private String job_name;
    private String department_name;
    private String branch_address;
    private String branch_city;

    public History(int id, String first_name, String last_name, String hire_date, String start_date, String end_date, String job_name, String department_name, String branch_address, String branch_city){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.hire_date = hire_date;
        this.start_date = start_date;
        this.end_date = end_date;
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

    public String getHire_date() {
        return hire_date;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
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
