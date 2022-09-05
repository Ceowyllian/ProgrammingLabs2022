package humans.generators;

import java.util.LinkedList;
import java.util.List;

import humans.models.Address;

public class AddressGenerator extends BaseGenerator<Address> {
    private String[] states;
    private String[] cities;
    private String[] streets;

    public AddressGenerator(String[] states, String[] cities,
            String[] streets) {
        this.states = states;
        this.cities = cities;
        this.streets = streets;
    }

    @Override
    public Address create() {
        return new Address(random.choose(states), random.choose(cities),
                random.choose(streets), random.getInt(1, 25));
    }

    @Override
    public List<Address> create(int amount) {
        LinkedList<Address> list = new LinkedList<Address>();
        for (int i = 0; i < amount; i++)
            list.add(create());
        return list;
    }
}
