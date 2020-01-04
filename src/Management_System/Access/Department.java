package Management_System.Access;

public class Department {

    private String  id;
    private String name;
    private String branch_address;
    private String branch_city;

    public Department(String id, String name, String branch_address, String branch_city){
        this.id = id;
        this.name = name;
        this.branch_address = branch_address;
        this.branch_city = branch_city;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBranch_address() {
        return branch_address;
    }

    public String getBranch_city() {
        return branch_city;
    }

}
