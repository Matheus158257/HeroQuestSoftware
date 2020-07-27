package br.unicamp.Dices;

import java.util.Random;

public class RedDice extends Dice {


	public RedDice() {

	}
	
	// Returns a random number between 1 and 6 for each die
	private int rollDice() {
		int result = 0;
		Random r = new Random();
		result = r.nextInt(high-low+1) + low;
		return result;
	}
	
	// Returns the numeric result of rolling a given number of Red Dice
	public int getResult(int numberOfDice) {
		int result = 0;
		for (int i=1;i<=numberOfDice; i++) {
			result += rollDice();
		}
		return result;
	}
}
