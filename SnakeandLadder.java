package com.snakeandladder;

import java.util.Random;
import java.util.Scanner;

public class SnakeandLadder {
	final static int WINPOINT = 100;
	int playerPosition = 0;
	int num;
	
	public int simulator(int dieValue) {
		
		playerPosition = playerPosition + dieValue;
		System.out.println("Current position "+playerPosition);
			
			//exact winning position
			if(playerPosition > WINPOINT) {
				playerPosition = playerPosition - dieValue;
				System.out.println("\nPlayer is back at the position "+playerPosition);
				return playerPosition;		
			}
			
			//ladder
			if(playerPosition == 8) {
				playerPosition = playerPosition + 22;
				System.out.println("\nLadder upward to "+playerPosition+" from position 8\n");
				return playerPosition;
			} else if(playerPosition == 87) {
				playerPosition = playerPosition + 11;
				System.out.println("\nLadder upward to "+playerPosition+" from position 87\n");
				return playerPosition;
			} 
			
			//snake
			if(playerPosition == 97) {
				playerPosition = playerPosition - 19;
				System.out.println("\nSnake bite you");
				System.out.println("Moved backward to "+playerPosition+" from position 97\n");
				return playerPosition;	
			} else if(playerPosition == 48) {
				playerPosition = playerPosition - 22;
				System.out.println("\nSnake bite you");
				System.out.println("Moved backward to "+playerPosition+" from position 48\n");
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
		int count  = 0;
		int position;
		SnakeandLadder sim = new SnakeandLadder();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter r to roll the dice ");
		String roll = sc.next();
		do {
			int dice = sim.dieRoll();
			System.out.println("\nDice value is "+dice);
			count++;
			position = sim.simulator(dice);
			
			if(position == WINPOINT) {
				System.out.println("********You won the match********");
				break;
			}
		} while("r".equals(roll));
		
		System.out.println("Dice is rolled "+count+" times");
	} 
}
