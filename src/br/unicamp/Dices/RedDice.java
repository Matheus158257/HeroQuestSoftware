package br.unicamp.Dices;

import java.util.Random;

public class RedDice extends Dice {


	public RedDice() {

	}
	
	//returns a random number between 1 and 6 for each dice
	private int rollDice() {
		int result = 0;
		Random r = new Random();
		result = r.nextInt(high-low+1) + low;
		return result;
	}
	
	public int getResult(int numberOfDice) {
		int result = 0;
		for (int i=1;i<=numberOfDice; i++) {
			result += rollDice();
		}
		return result;
	}
}
