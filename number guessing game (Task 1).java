import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1;
            int numberOfAttempts = 0;
            boolean guessedCorrectly = false;
            int maxAttempts = 10;
            int lowerBound = 1;
            int upperBound = 100;

            System.out.println("Guess a number between 1 and 100:");

            while (numberOfAttempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfAttempts++;

                if (userGuess > randomNumber) {
                    System.out.println("Your guess is too high.");
                    upperBound = userGuess - 1;  
                } else if (userGuess < randomNumber) {
                    System.out.println("Your guess is too low.");
                    lowerBound = userGuess + 1; 
                } else {
                    System.out.println("Congratulations! You guessed correctly! The number was " + randomNumber);
                    guessedCorrectly = true;
                }

                if (!guessedCorrectly) {
                    System.out.println("Hint: The number is between " + lowerBound + " and " + upperBound);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you ran out of guesses. The correct answer was " + randomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        scanner.close();
        System.out.println("Thank you for playing!");
    }
}
