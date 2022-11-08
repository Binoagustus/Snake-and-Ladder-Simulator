package com.snakeandladder;

import java.util.Random;
import java.util.Scanner;

public class SnakeandLadder {
	final static int WINPOINT = 100;
	int playerPosition = 0;
	int player;
	int num;

	public int simulator(int dieValue, int player) {

		playerPosition = playerPosition + dieValue;
		System.out.println("Current position of player" + player + " is " + playerPosition);

		// exact winning position
		if (playerPosition > WINPOINT) {
			playerPosition = playerPosition - dieValue;
			System.out.println("\nPlayer " + player + " is back at the position " + playerPosition);
			return playerPosition;
		}

		// ladder
		if (playerPosition == 8) {
			playerPosition = playerPosition + 22;
			System.out.println("\nPlayer" + player + " took ladder upward to " + playerPosition + " from position 8\n");
			return playerPosition;
		} else if (playerPosition == 87) {
			playerPosition = playerPosition + 11;
			System.out
					.println("\nPlayer" + player + " took ladder upward to " + playerPosition + " from position 87\n");
			return playerPosition;
		}

		// snake
		if (playerPosition == 97) {
			playerPosition = playerPosition - 19;
			System.out.println("\nSnake bite you");
			System.out.println("Player" + player + " moved backward to " + playerPosition + " from position 97\n");
			return playerPosition;
		} else if (playerPosition == 48) {
			playerPosition = playerPosition - 22;
			System.out.println("\nSnake bite you");
			System.out.println("Player" + player + " moved backward to " + playerPosition + " from position 48\n");
			return playerPosition;
		}

		return playerPosition;
	}

	public int dieRoll() {
		Random dice = new Random();
		num = dice.nextInt(7);
		return (num == 0 ? 1 : num);
	}

	public static void main(String[] args) {
		System.out.println("Snake and Ladder Simulator");
		int count1 = 0;
		int count2 = 0;
		int position;
		int currentPlayer = -1;
		int player1, player2;
		int diceLadder1, diceLadder2;
		SnakeandLadder sim = new SnakeandLadder();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter r to roll the dice ");
		String roll = sc.next();
		do {
			System.out.println(currentPlayer == -1 ? "\n First player turn" : "\n Second Player Turn");
			int dice = sim.dieRoll();
			System.out.println("\nDice value is " + dice);

			if (currentPlayer == -1) {
				count1++;
				player1 = sim.simulator(dice, 1);
				if ((player1 == 30) || (player1 == 98)) {
					diceLadder1 = sim.dieRoll();
					sim.simulator(diceLadder1, 1);
				}
				if (player1 == WINPOINT) {
					System.out.println("********Player1 won the match********");
					break;
				}

			} else {
				count2++;
				player2 = sim.simulator(dice, 2);
				if ((player2 == 30) || (player2 == 98)) {
					diceLadder2 = sim.dieRoll();
					sim.simulator(diceLadder2, 2);
				}

				if (player2 == WINPOINT) {
					System.out.println("********Player2 won the match********");
					break;
				}
			}
			currentPlayer = -currentPlayer;
		} while ("r".equals(roll));

		System.out.println("Dice is rolled by player1 " + count1 + " times");
		System.out.println("Dice is rolled by player2 " + count2 + " times");
	}
}
