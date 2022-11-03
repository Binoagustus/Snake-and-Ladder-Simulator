package com.snakeandladder;

import java.util.Random;

public class SnakeandLadder {
	final static int WINPOINT = 100;
	int playerPosition = 0;
	int num;
	
	public int simulator(int dieValue) {
		
		playerPosition = playerPosition + dieValue;
		System.out.println("Current position "+playerPosition);
		
			if(playerPosition > WINPOINT) {
				playerPosition = playerPosition - dieValue;
				System.out.println("Player is at the position "+playerPosition);
				return playerPosition;		
			}
			
			//ladder
			if(playerPosition == 8) {
				playerPosition = playerPosition + 22;
				System.out.println("Ladder upward to "+playerPosition+" from position 8");
				return playerPosition;
			} else if(playerPosition == 87) {
				playerPosition = playerPosition + 11;
				System.out.println("Ladder upward to "+playerPosition+" from position 87");
				return playerPosition;
			} 
			
			//snake
			if(playerPosition == 97) {
				playerPosition = playerPosition - 19;
				System.out.println("Snake bite you");
				System.out.println("Move backward to "+playerPosition+" from position 97");
				return playerPosition;	
			} else if(playerPosition == 48) {
				playerPosition = playerPosition - 22;
				System.out.println("Snake bite you");
				System.out.println("Move backward to "+playerPosition+" from position 48");
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
		SnakeandLadder sim = new SnakeandLadder();
		int dice = sim.dieRoll();
	    sim.simulator(dice);
	    
	}

}
