package Management_System.Access;

public class Branch {

    private int id;
    private String address;
    private String city;

    public Branch(int id, String address,  String city){
        this.id = id;
        this.address = address;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

}
