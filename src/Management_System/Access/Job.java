package Management_System.Access;

public class Job {

    private String id;
    private String name;
    private String min_salary;

    public Job(String id, String name, String min_salary){
        this.id = id;
        this.name = name;
        this.min_salary = min_salary;
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

}
