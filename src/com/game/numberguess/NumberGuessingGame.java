package com.game.numberguess;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

	public static void main(String[] args) {


		Scanner br = new Scanner(System.in);
		int guess = 1;
		while (guess != 0) {
			try {
				game(br);
				System.out.println("Would you like to play again? (0 - No) ");
				guess = br.nextInt();
			} catch (NumberFormatException | InputMismatchException | IOException ime) {
				System.out.println("You need to write a number :)");
				br.nextLine();
			} 
		}
		br.close();
	}

	public static void game(Scanner br) throws NumberFormatException, IOException {
		int guess = 0, tryCount = 0, randomNumber = new Random().nextInt(101);
		System.out.println("Try to guess my number. Write one number from 0 to 100.");
		while (guess != randomNumber) {
			guess = br.nextInt();
			tryCount++;
			if (guess == randomNumber) {
				System.out.println(
						"Correct! My number was " + randomNumber + ", and you needed " + tryCount + " tries. ");
			} else if (guess > 100 || guess < 0) {
				System.out.println("Told you the number is between 0 and 100 :( ");
			} else if (guess < randomNumber) {
				System.out.println("Try again with a higher number. ");
			} else {
				System.out.println("Try again with a lower number. ");
			}
		}
	}
}
