package humans.storage;

import humans.models.Person;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;


public class PersonStorage {

    private static HashSet<Person> storage;

    private PersonStorage() {
    }

    public static void initialize(int initialCapacity) {
        if (storage == null) storage = new HashSet<>(initialCapacity);
    }

    private static <T extends Comparable<V>, V extends Comparable<T>> boolean compare(
        String operator, T left, V right
    ) {
        return switch (operator) {
            case "=" -> left.equals(right);
            case "!=" -> !left.equals(right);
            case ">" -> left.compareTo(right) > 0;
            case "<" -> left.compareTo(right) < 0;
            default -> throw new IllegalArgumentException();
        };
    }

    private static <T extends Comparable<T>> T fieldValue(String field, Person p) {
        return switch (field) {
            case "name" -> (T) p.getName();
            case "surname" -> (T) p.getSurname();
            case "nation" -> (T) p.getNation();
            case "age" -> (T) (Integer) p.getAge();
            case "height" -> (T) (Double) p.getHeight();
            case "weight" -> (T) (Double) p.getWeight();
            default -> throw new IllegalArgumentException();
        };
    }

    private static <T extends Comparable<T>> Predicate<Person> createPredicate(
        String field, String operator, T constant
    ) {
        return p -> compare(operator, fieldValue(field, p), constant);
    }

    public static <T extends Comparable<T>> List<Person> filter(
        String field, String operator, T constant
    ) {
        List<Person> result = new LinkedList<>();
        Predicate<Person> rule = createPredicate(field, operator, constant);
        storage.stream()
               .filter(rule)
               .iterator()
               .forEachRemaining(result::add);
        return result;
    }

    public static Person findById(UUID id) {
        return storage.stream()
                      .filter(p -> (p.id == id))
                      .findFirst()
                      .orElse(null);
    }

    public static void create(Person person) {
        storage.add(person);
    }

    public static void create(List<Person> people) {
        storage.addAll(people);
    }
}
