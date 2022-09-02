package humans;

import java.util.LinkedList;

public class App {

	public static void main(String[] args) {
		Address address = new Address("Ukraine", "Kyiv", "Streeeeeeet", 25);

		Human user = new Human("John", "Doe", 23, 175.23, 67.3, true, Nation.UKRANIAN, address);
		System.out.println(user);
		System.out.print(address);
		LinkedList<Human> people = new LinkedList<>();
		people.add(user);
	}
}
