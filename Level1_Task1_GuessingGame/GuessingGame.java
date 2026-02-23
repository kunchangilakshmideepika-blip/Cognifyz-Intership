package Level1_Task1_GuessingGame;

import java.util.Scanner;
import java.util.Random;

public class GuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int randomNumber = r.nextInt(100) + 1;
        int userGuess = 0;
        int count = 0;

        System.out.println("Welcome to Guessing Game");
        System.out.println("Guess a number between 1 and 100");

        while (userGuess != randomNumber) {

            System.out.print("Enter your guess: ");
            userGuess = sc.nextInt();
            count++;

            if (userGuess > randomNumber) {
                System.out.println("Number is too high");
            } 
            else if (userGuess < randomNumber) {
                System.out.println("Number is too low");
            } 
            else {
                System.out.println("Correct! You guessed in " + count + " attempts");
            }
        }

        sc.close();
    }
}