package humans.models;

import java.util.Objects;
import java.util.UUID;

public class Person {

    private UUID id;

    private String name;
    private String surname;
    private int age;
    private double height;
    private double weight;
    private boolean habits;
    private String nation;
    private Address adress;

    public Person(String name, String surname, int age, double height,
            double weight, boolean habits, String nation, Address adress) {
        super();
        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.habits = habits;
        this.nation = nation;
        this.adress = adress;
    }

    @Override
    public String toString() {
        return name + " " + surname + ", " + age + " y. o.\n" + " Adress: "
                + adress.toString();
    }

    public UUID Id() {
        return id;
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

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Address getAdress() {
        return adress;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        return Objects.equals(id, other.id);
    }

}
