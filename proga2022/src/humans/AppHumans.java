package humans;

import java.util.List;

import humans.generators.AddressGenerator;
import humans.generators.PersonGenerator;

public class AppHumans {

    public static void main(String[] args) {
        String[] states = { "Germany", "USA", "France", "UK", "Sweden",
                "Canada", "Spain", "Ireland" };
        String[] cities = { "Vulmell", "Applenum", "Elktail", "Hampshaw",
                "Bentlock", "Vulfield" };
        String[] streets = { "Hamlet street", "Gibmore street",
                "Hinmouth avenue", "Wintertor avenue", "Rothestock lane",
                "Applesons alley" };
        AddressGenerator randomAddress = new AddressGenerator(states, cities, streets);

        List<Address> addresses = randomAddress.create(20);
        String[] names = { "Mila", "Kennard", "Deborah", "Jade", "Petra",
                "Octavia", "Chip", "Pleun", "Khloe", "Esmond" };
        String[] surnames = { "Farley", "Dottie", "Krystelle", "Selby", "Stijn",
                "Tony", "Leonard", "Suzanne", "Ruby", "Nixon" };
        String[] nations = { "German", "American", "Frenchman", "Englishman",
                "Swede", "Canadian", "Irishman" };
        PersonGenerator randomPerson = new PersonGenerator(names, surnames, nations, addresses);

        List<Person> people = randomPerson.create(15);

        for (Person person : people) {
            System.out.println(person.toString());
        }

    }
}
