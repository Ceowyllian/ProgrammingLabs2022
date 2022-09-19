package guess;

import java.io.PrintStream;
import java.util.Scanner;

public class App {

	public static int random_int(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	public static void main(String[] args) {
		int number = random_int(0, 10);
		int attempts = 3;

		PrintStream console = System.out;
		Scanner read = new Scanner(System.in);

		for (int i = 1; i <= attempts; i++) {
			console.print("Enter number: ");
			int input = read.nextInt();
			if (input == number) {
				console.println("\nYou guessed!");
				break;
			} else {
				console.printf("\nWrong answer! Attempts left: %s%n", attempts - i);
			}
		}
		console.printf("The number is: %s%n", number);
	}
}
