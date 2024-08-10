* Author: Susan Wu
* Date: 2024-6-30
* Project: Guessing Game
* Purpose: This program implements a number guessing game where the user guesses a number between 1 and 100. 
*          The program provides feedback on whether the guess is too high or too low and tracks overall statistics.
*/

import java.util.Random;
import java.util.Scanner;

public class guessNum_1{
    private static final int MAX_NUMBER = 100;
    private static int totalGames = 0;
    private static int totalGuesses = 0;
    private static int bestGame = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        introduceGame();

        while (playAgain) {
            int guessesInGame = playOneGame(scanner);
            totalGames++;
            totalGuesses += guessesInGame;
            if (guessesInGame < bestGame) {
                bestGame = guessesInGame;
            }
            playAgain = askToPlayAgain(scanner);
        } 

        scanner.close();
        reportResults();
    }

    // Method to introduce the game
    private static void introduceGame() {
        System.out.println("This program allows you to play a guessing game.");
        System.out.println("I will think of a number between 1 and " + MAX_NUMBER);
        System.out.println("and will allow you to guess until you get it.");
        System.out.println("For each guess, I will tell you whether the right answer");
        System.out.println("is higher or lower than your guess.");
    }

    // Method to play one game
    private static int playOneGame(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(MAX_NUMBER) + 1;
        int numberOfGuesses = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("I'm thinking of a number between 1 and " + MAX_NUMBER + "...");

        while (!hasGuessedCorrectly) {
            System.out.print("Your guess? ");
            int guess = scanner.nextInt();
            numberOfGuesses++;

            if (guess < numberToGuess) {
                System.out.println("It's higher.");
            } else if (guess > numberToGuess) {
                System.out.println("It's lower.");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("You got it right in " + numberOfGuesses + " guesses.");
            }
        }
        return numberOfGuesses;
    }

    // Method to ask the user if they want to play again
    private static boolean askToPlayAgain(Scanner scanner) {
        System.out.print("Do you want to play again? ");
        String response = scanner.next();

        return response.toLowerCase().startsWith("y");
    }

    // Method to report overall results
    private static void reportResults() {
        System.out.println("Overall results:");
        System.out.println("total games = " + totalGames);
        System.out.println("total guesses = " + totalGuesses);
        System.out.printf("guesses/game = %.1f%n", (double) totalGuesses / totalGames);
        System.out.println("best game = " + bestGame);
    }
}
