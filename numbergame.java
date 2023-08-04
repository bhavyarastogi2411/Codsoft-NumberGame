import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerLimit = 1;
        int upperLimit = 100;
        int maxAttempts = 10;
        boolean playAgain = true;
        int roundsPlayed = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Guess the Number game!");

        while (playAgain) {
            roundsPlayed++;
            int targetNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            int attempts = 0;

            System.out.println("\nRound " + roundsPlayed + ":");
            System.out.println("Guess a number between " + lowerLimit + " and " + upperLimit + ".");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    break;
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Oops! You've reached the maximum number of attempts. The correct number was " + targetNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.println("\nGame over! You played " + roundsPlayed + " rounds and your average number of attempts per round was " + (double) totalAttempts / roundsPlayed);
        scanner.close();
    }
}