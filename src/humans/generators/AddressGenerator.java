package humans.generators;

import humans.models.Address;

import java.util.List;


public class AddressGenerator extends BaseGenerator<Address> {

    private static final String[] defaultStates = {
        "Germany", "USA", "France", "UK", "Sweden", "Canada", "Spain", "Ireland"
    };
    private static final String[] defaultCities = {
        "Vulmell", "Applenum", "Elktail", "Hampshaw", "Bentlock", "Vulfield"
    };
    private static final String[] defaultStreets = {
        "Hamlet street", "Gibmore street", "Hinmouth avenue", "Wintertor avenue",
        "Rothestock lane", "Applesons alley"
    };
    public final List<String> states;
    public final List<String> cities;
    public final List<String> streets;
    public final int minHouseNumber;
    public final int maxHouseNumber;

    public AddressGenerator(
        List<String> states,
        List<String> cities,
        List<String> streets,
        int minHouseNumber,
        int maxHouseNumber
    ) {
        this.states = getDefault(states, defaultStates);
        this.cities = getDefault(cities, defaultCities);
        this.streets = getDefault(streets, defaultStreets);
        this.minHouseNumber = minHouseNumber;
        this.maxHouseNumber = maxHouseNumber;
    }

    @Override
    public Address create() {
        return new Address(
            random.choose(states),
            random.choose(cities),
            random.choose(streets),
            random.getInt(minHouseNumber, maxHouseNumber)
        );
    }
}
