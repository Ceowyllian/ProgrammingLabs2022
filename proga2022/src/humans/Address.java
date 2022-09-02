package humans;

public class Address {
    private String state;
    private String city;
    private String street;
    private int house;

    public Address(String state, String city, String street, int house) {
        super();
        this.state = state;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    @Override
    public String toString() {
        return this.state + ", " + this.city + ", " + this.street + ", "
                + this.house;
    }

    public String get_country() {
        return state;
    }

    public void set_country(String state) {
        this.state = state;
    }

    public String get_city() {
        return city;
    }

    public void set_city(String city) {
        this.city = city;
    }

    public String get_street() {
        return street;
    }

    public void set_street(String street) {
        this.street = street;
    }

    public int get_house() {
        return house;
    }

    public void set_house(int house) {
        this.house = house;
    }

}
