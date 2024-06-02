import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int score = 0;

        while (playAgain) {
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Select difficulty level:");
            System.out.println("1. Easy (1-50, 10 attempts)");
            System.out.println("2. Medium (1-100, 7 attempts)");
            System.out.println("3. Hard (1-200, 5 attempts)");
            System.out.print("Enter your choice (1-3): ");
            int difficulty = scanner.nextInt();

            int numberToGuess = 0;
            int maxAttempts = 0;
            switch (difficulty) {
                case 1:
                    numberToGuess = random.nextInt(50) + 1;
                    maxAttempts = 10;
                    break;
                case 2:
                    numberToGuess = random.nextInt(100) + 1;
                    maxAttempts = 7;
                    break;
                case 3:
                    numberToGuess = random.nextInt(200) + 1;
                    maxAttempts = 5;
                    break;
                default:
                    System.out.println("Invalid choice! Defaulting to Easy level.");
                    numberToGuess = random.nextInt(50) + 1;
                    maxAttempts = 10;
                    break;
            }

            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("I have generated a random number. Can you guess it?");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all your attempts. The correct number was " + numberToGuess + ".");
            } else {
                score += (maxAttempts - attempts + 1);
                System.out.println("Your score for this round is: " + (maxAttempts - attempts + 1));
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

            if (!playAgain) {
                System.out.println("Thanks for playing! Your total score is: " + score);
            }
        }

        scanner.close();
    }
}
