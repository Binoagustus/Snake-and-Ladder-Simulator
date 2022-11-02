package com.snakeandladder;

import java.util.Random;

public class SnakeandLadder {
	int[] board = new int[100];
	final static int WINPOINT = 100;
	int position = 1;
	int num;
	
	public void simulator() {
		for(int i = 0; i < 100; i++) {
			board[i] = i + position;
		}
	}
	
	public int dieRoll() {
		    Random dice = new Random();
		    num=dice.nextInt(7);
		    return (num==0?1:num);
	}
	
	public static void main(String[] args) {
		System.out.println("Snake and Ladder Simulator");
		SnakeandLadder sim = new SnakeandLadder();
		sim.simulator();
		int die = sim.dieRoll();
		System.out.println(die);
	}

}
