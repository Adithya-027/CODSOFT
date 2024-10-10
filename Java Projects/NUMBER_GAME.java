import java.util.Random;
import java.util.Scanner;

public class NUMBER_GAME {
    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final int MAX_ATTEMPTS = 10;
    private static int gamesPlayed = 0;
    private static int gamesWon = 0;

    // Method to generate a random number between MIN and MAX (inclusive)
    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX - MIN + 1) + MIN;
    }

    // Method to get the user's guess
    public static int getUserGuess(Scanner scanner) {
        System.out.print("Enter your guess (between " + MIN + " and " + MAX + "): ");
        return scanner.nextInt();
    }

    // Method to provide feedback on the user's guess
    public static void provideFeedback(int guess, int number) {
        if (guess < number) {
            System.out.println("Too low! Try again.");
        } else if (guess > number) {
            System.out.println("Too high! Try again.");
        } else {
            System.out.println("Congratulations! You've guessed the number.");
        }
    }

    // Method to play a single game
    public static void playGame(Scanner scanner) {
        int number = generateRandomNumber();
        int guess = 0;
        int attempts = 0;

        while (guess != number && attempts < MAX_ATTEMPTS) {
            guess = getUserGuess(scanner);
            provideFeedback(guess, number);
            attempts++;
        }

        if (guess == number) {
            gamesWon++;
            System.out.println("You won this game!");
        } else {
            System.out.println("Sorry, you've used all your attempts. The number was " + number + ".");
        }

        gamesPlayed++;
    }

    // Main method to control the flow of the game
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {  // Use try-with-resources to ensure Scanner is closed
            String playAgain;

            do {
                playGame(scanner);
                System.out.print("Do you want to play again? (yes/no): ");
                playAgain = scanner.next();
            } while (playAgain.equalsIgnoreCase("yes"));

            System.out.println("Thanks for playing!");
            System.out.println("Games played: " + gamesPlayed);
            System.out.println("Games won: " + gamesWon);
            System.out.println("Games lost: " + (gamesPlayed - gamesWon));
        }
    }
}
