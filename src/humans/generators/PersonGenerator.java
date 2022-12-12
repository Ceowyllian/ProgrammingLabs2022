package humans.generators;

import humans.models.Person;

import java.util.List;


public class PersonGenerator extends BaseGenerator<Person> {

    private static final String[] defaultNames = {
        "Mila", "Kennard", "Deborah", "Jade", "Petra", "Octavia", "Chip", "Pleun",
        "Khloe", "Esmond"
    };
    private static final String[] defaultSurnames = {
        "Farley", "Dottie", "Krystelle", "Selby", "Stijn", "Tony", "Leonard", "Suzanne",
        "Ruby", "Nixon"
    };
    private static final String[] defaultNations = {
        "German", "American", "Frenchman", "Englishman", "Swede", "Canadian", "Irishman"
    };

    public final List<String> names;
    public final List<String> surnames;
    public final List<String> nations;
    public final int minAge;
    public final int maxAge;
    public final double minHeight;
    public final double maxHeight;
    public final double minWeight;
    public final double maxWeight;
    private final AddressGenerator addresses;

    public PersonGenerator(
        List<String> names,
        List<String> surnames,
        List<String> nations,
        int minAge,
        int maxAge,
        int minHeight,
        int maxHeight,
        int minWeight,
        int maxWeight,
        AddressGenerator addresses
    ) {
        this.names = getDefault(names, defaultNames);
        this.surnames = getDefault(surnames, defaultSurnames);
        this.nations = getDefault(nations, defaultNations);
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.addresses = addresses;
    }

    @Override
    public Person create() {
        return new Person(
            random.choose(names),
            random.choose(surnames),
            random.choose(nations),
            random.getInt(minAge, maxAge),
            random.getDouble(minHeight, maxHeight),
            random.getDouble(minWeight, maxWeight),
            random.getBool(),
            addresses.create()
        );
    }
}
