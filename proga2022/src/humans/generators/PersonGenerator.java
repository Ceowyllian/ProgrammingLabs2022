package humans.generators;

import java.util.LinkedList;
import java.util.List;

import humans.models.Address;
import humans.models.Person;

public class PersonGenerator extends BaseGenerator<Person> {

    private String[] names;
    private String[] surnames;
    private String[] nations;
    private List<Address> addresses;

    public PersonGenerator(String[] names, String[] surnames, String[] nations,
            List<Address> addresses) {
        super();
        this.names = names;
        this.surnames = surnames;
        this.nations = nations;
        this.addresses = addresses;
    }

    @Override
    public Person create() {
        return new Person(
                random.choose(names), 
                random.choose(surnames),
                random.getInt(14, 90), 
                random.getDouble(150., 200.),
                random.getDouble(45., 90.), 
                random.getBool(),
                random.choose(nations), 
                random.choose(addresses));
    }

    @Override
    public List<Person> create(int amount) {
        LinkedList<Person> list = new LinkedList<Person>();
        for (int i = 0; i < amount; i++)
            list.add(create());
        return list;
    }
}
