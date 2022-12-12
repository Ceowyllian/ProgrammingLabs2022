package humans.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Objects;
import java.util.UUID;


@JsonAutoDetect
public class Person {

    public final UUID id = UUID.randomUUID();
    private String name;
    private String surname;
    private String nation;
    private int age;
    private double height;
    private double weight;
    private boolean habits;
    private Address address;

    public Person(
        String name,
        String surname,
        String nation,
        int age,
        double height,
        double weight,
        boolean habits,
        Address address
    ) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.habits = habits;
        this.nation = nation;
        this.address = address;
    }

    @Override
    public String toString() {
        return name + " " + surname + ", " + age + " y. o.\n" + " Adress: " +
            address.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean hasHabits() {
        return this.habits;
    }

    public void setHabits(boolean habits) {
        this.habits = habits;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person other = (Person) o;
        return Objects.equals(id, other.id);
    }
}
