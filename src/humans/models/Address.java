package humans.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Objects;
import java.util.UUID;


@JsonAutoDetect
public class Address {

    public final UUID id = UUID.randomUUID();

    private String state;
    private String city;
    private String street;
    private int house;

    public Address(String state, String city, String street, int house) {
        this.state = state;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return this.state + ", " + this.city + ", " + this.street + ", " + this.house;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id.equals(address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
