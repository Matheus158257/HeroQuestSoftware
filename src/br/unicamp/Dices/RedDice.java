package br.unicamp.Dices;

import java.util.Random;

public class RedDice extends Dice {

	
	private int low=1;
	private int high=6;

	public RedDice() {

	}
	
	//returns a random number between 1 and six for each dice
	private int rollDices() {
		int result = 0;
		Random r = new Random();
		result = r.nextInt(high-low+1) + low;
		return result;
	}
	
	public int getRedDicesResult() {
		int NumberOfDices = 2;
		int walkPositions = 0;
		for (int i=1;i<=NumberOfDices; i++) {
			walkPositions += rollDices();
		}
		return walkPositions;
	}
}
