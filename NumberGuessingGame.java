package com.pack2;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    // Method to play one round of the game
    public static boolean playRound(Scanner sc, int roundLimit) {
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1; // random number 1 to 100
        int attempts = 0;
        boolean isCorrect = false;

        System.out.println("\n🎯 A number is chosen between 1 and 100");
        System.out.println("You have " + roundLimit + " attempts to guess it!");

        while (attempts < roundLimit) {
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();
            attempts++;

            if (guess == numberToGuess) {
                System.out.println("✅ Correct! You guessed it in " + attempts + " attempts.");
                isCorrect = true;
                break;
            } else if (guess > numberToGuess) {
                System.out.println("📉 Too high! Try again.");
            } else {
                System.out.println("📈 Too low! Try again.");
            }
        }

        if (!isCorrect) {
            System.out.println("❌ You ran out of attempts. The number was: " + numberToGuess);
        }

        return isCorrect;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;
        int rounds = 0;
        int attemptLimit = 7;
        boolean playAgain;

        System.out.println("===== 🎮 Welcome to the Number Guessing Game 🎮 =====");

        do {
            rounds++;
            boolean won = playRound(sc, attemptLimit);

            if (won) {
                score++;
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = sc.next();
            playAgain = choice.equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("\n===== 🏆 Game Over! =====");
        System.out.println("Total Rounds Played: " + rounds);
        System.out.println("Rounds Won: " + score);
        System.out.println("Final Score: " + score + " / " + rounds);

        sc.close();
    }
}

