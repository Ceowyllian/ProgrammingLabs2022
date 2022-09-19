package humans.storage;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.List;


import humans.models.Person;

public class PersonStorage {

    private PersonStorage() {
    }

    private static HashSet<Person> storage;

    public static void initialize(int initialCapacity) {
        if (storage == null)
            storage = new HashSet<Person>(initialCapacity);
    }

    private static boolean compare(
        String operator, Comparable left, Comparable right) {

        return switch (operator) {
            case "=" -> left.equals(right);
            case "!=" -> !left.equals(right);
            case ">" -> left.compareTo(right) > 0;
            case "<" -> left.compareTo(right) < 0;
            default -> throw new IllegalArgumentException(
                "Unexpected value: " + operator);
        };
    }

    public static <T extends Comparable<T>> List<Person> filter(
        String field, String operator, T constant) {

        List<Person> result = new LinkedList<Person>();
        Predicate<Person> by_field = switch (field) {
            case "name" -> p -> compare(operator, p.getName(), constant);
            case "surname" -> p -> compare(operator, p.getSurname(), constant);
            case "age" -> p -> compare(operator, p.getAge(), constant);
            case "height" -> p -> compare(operator, p.getHeight(), constant);
            case "weight" -> p -> compare(operator, p.getWeight(), constant);
            case "habits" -> p -> compare(operator, p.hasHabits(), constant);
            default -> throw new IllegalArgumentException("No such field: " + field);
        };
        storage
            .stream()
            .filter(by_field)
            .iterator()
            .forEachRemaining(result::add);
        return result;
    }

    public static Person find_by_id(UUID id) {
        Iterator<Person> querySet = storage
            .stream()
            .filter(p -> (p.Id() == id))
            .iterator();
        if (querySet.hasNext())
            return querySet.next();
        return null;
    }

    public static boolean create(Person person) {
        return storage.add(person);
    }

    public static void create(List<Person> people) {
        storage.addAll(people);
    }

}
