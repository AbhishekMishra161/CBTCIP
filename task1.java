package internship;

import java.util.Random;
import java.util.Scanner;

public class task1 {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_ROUNDS = 3;

    public static void main (String args[]) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;
        
        System.out.println("NUMBER GUESSING GAME");
        System.out.println("Total Number of Rounds : 3");
        System.out.println("Attempts To Guess Number in Each Round : 10/n ");
        for (int i = 1; i <= MAX_ROUNDS; i++) {
            int number = random.nextInt(MAX_RANGE) + MIN_RANGE;
            int attempts = 0;

            System.out.printf("Round %d: Guess the number between %d and %d in %d attempts.",i, MIN_RANGE, MAX_RANGE, MAX_ATTEMPTS);
            while(attempts < MAX_ATTEMPTS){
                System.out.println("Enter your guess : ");
                int guess_number = scanner.nextInt();
                attempts = attempts + 1;

                if (guess_number == number) {
                    int score = MAX_ATTEMPTS - attempts;
                    totalScore = totalScore + score;
                    System.out.printf("Hurray! Number guessed successfully. Attempts = %d. Round score = %d\n",attempts, score);
                    break;
                }

                else if (guess_number < number){
                    System.out.printf("The number is greater than %d. Attempts left = %d.\n",guess_number,MAX_ATTEMPTS-attempts);
                }

                else if (guess_number > number) {
                    System.out.printf("The number is less than %d. Attempts left = %d.\n",guess_number,MAX_ATTEMPTS - attempts);
                }
            }

            if (attempts == MAX_ATTEMPTS) {
                System.out.printf("\nRound = %d\n", i);
                System.out.println("Attempts = 0");
                System.out.printf("The Random Number Is : %d\n\n",number);
            }
        }

        System.out.printf("Game over. Total Score = %d\n", totalScore);
        scanner.close();
    }
}