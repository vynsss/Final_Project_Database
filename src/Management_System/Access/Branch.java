package Management_System.Access;

public class Branch {

    private String id;
    private String address;
    private String city;

    public Branch(String id, String address,  String city){
        this.id = id;
        this.address = address;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

}
