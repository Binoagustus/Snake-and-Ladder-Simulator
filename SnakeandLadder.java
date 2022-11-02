package com.snakeandladder;

public class SnakeandLadder {
	int[] board = new int[100];
	final static int WINPOINT = 100;
	int position = 1;
	
	public void simulator() {
		for(int i = 0; i < 100; i++) {
			board[i] = i + position;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Snake and Ladder Simulator");
		SnakeandLadder sim = new SnakeandLadder();
		sim.simulator();
	}

}
