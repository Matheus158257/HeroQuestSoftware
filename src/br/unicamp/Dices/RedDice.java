package br.unicamp.Dices;

import java.util.Random;

public class RedDice extends Dice {


	public RedDice() {

	}
	
	//returns a random number between 1 and six for each dice
	private int rollDices() {
		int result = 0;
		Random r = new Random();
		result = r.nextInt(high-low+1) + low;
		return result;
	}
	
	public int getResult(int NumberOfDices) {
		int walkPositions = 0;
		for (int i=1;i<=NumberOfDices; i++) {
			walkPositions += rollDices();
		}
		return walkPositions;
	}
}
