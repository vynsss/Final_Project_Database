package Management_System.Access;

public class Job {

    private int id;
    private String name;
    private double min_salary;

    public Job(int id, String name, double min_salary){
        this.id = id;
        this.name = name;
        this.min_salary = min_salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMin_salary() {
        return min_salary;
    }

}
