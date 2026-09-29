import java.util.Random;
import java.util.Scanner;

// Task 1 - Number Game
// The computer picks a number between 1 and 100 and the user keeps guessing
// until they get it right.
public class NumberGame {

    static final int MIN = 1;
    static final int MAX = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int secret = rand.nextInt(MAX - MIN + 1) + MIN;
        int attempts = 0;
        boolean guessed = false;

        System.out.println("=== Number Guessing Game ===");
        System.out.println("I'm thinking of a number between " + MIN + " and " + MAX + ".");

        while (!guessed) {
            System.out.print("Enter your guess: ");

            if (!sc.hasNext()) {   // input ended, nothing more to read
                System.out.println("\nNo more input. Bye!");
                break;
            }

            String input = sc.next();
            int guess;
            try {
                guess = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("That's not a number, try again.");
                continue;
            }

            if (guess < MIN || guess > MAX) {
                System.out.println("Please guess between " + MIN + " and " + MAX + ".");
                continue;
            }

            attempts++;

            if (guess < secret) {
                System.out.println("Too Low!");
            } else if (guess > secret) {
                System.out.println("Too High!");
            } else {
                System.out.println("Correct! You got it in " + attempts + " attempt(s).");
                guessed = true;
            }
        }
        sc.close();
    }
}
