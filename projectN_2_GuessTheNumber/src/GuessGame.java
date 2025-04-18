import java.util.Scanner;
import java.util.Random;

public class GuessGame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int playAgain = 0, highScoreDif1 = 0, highScoreDif2 = 0, highScoreDif3 = 0;

        do {
            System.out.println("Welcome to... Guess the number!" +
                    "\n\nSelect difficulty:" +
                    "\n1) 30 attempts, number to guess between 1-100, 90s to guess, best score: "+ highScoreDif1 +
                    "\n2) 20 attempts, number to guess between 1-1000, 60s to guess, best score: "+ highScoreDif2 +
                    "\n3) 10 attempts, number to guess between 1-10000, 30s to guess, best score: " + highScoreDif3 +
                    "\n\nChoose your option (default 3): ");
            int difficulty = s.nextInt();
            int attempts, numberToGuess;
            long timeLimit;

            switch (difficulty) {
                case 1:
                    attempts = 30; timeLimit = 90000; numberToGuess = r.nextInt(100) + 1;
                    break;
                case 2:
                    attempts = 20; timeLimit = 60000; numberToGuess = r.nextInt(1000) + 1;
                    break;
                default:
                    attempts = 10; timeLimit = 30000; numberToGuess = r.nextInt(10000) + 1;
            }

            long startTime = System.currentTimeMillis();
            while (((System.currentTimeMillis() - startTime) < timeLimit) && (attempts > 0)) {
                System.out.println("Give me your guess...");
                int guess = s.nextInt();

                if (guess == numberToGuess) {
                    System.out.println("\nCorrect! Well played" +
                            "\nTime left (in milliseconds): " + (System.currentTimeMillis() - startTime) +
                            "\nAttempts left: " + attempts);
                    if (difficulty == 1 && highScoreDif1 < attempts ) {
                        System.out.println("\nNew best high score!");
                        highScoreDif1 = attempts;
                    } else if (difficulty == 2 && highScoreDif2 < attempts) {
                        System.out.println("\nNew best high score!");
                        highScoreDif2 = attempts;
                    } else if (highScoreDif3 < attempts) {
                        System.out.println("\nNew best high score!");
                    }
                    break;
                } else if (guess > numberToGuess) {
                    System.out.println("Try a little lower...");
                    attempts--;
                } else {
                    System.out.println("Try a little higher...");
                    attempts--;
                }
            }
            if (((System.currentTimeMillis() - startTime) > timeLimit) || (attempts <= 0)) {
                System.out.println("You lose... Better luck next time!");
            }
            System.out.println("\nWanna play again? 0 = Yes, Anything else = No");
            playAgain = s.nextInt();
        } while (playAgain == 0);


    }
}
