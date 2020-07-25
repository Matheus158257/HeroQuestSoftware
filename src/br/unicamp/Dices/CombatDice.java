package br.unicamp.Dices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class CombatDice extends Dice {
	
	
	private HashMap<Integer, CombatDiceSymbol> hmap = new HashMap<Integer, CombatDiceSymbol>();
	public CombatDice() {
		 hmap.put(1,  CombatDiceSymbol.SKULL);
	     hmap.put(2,  CombatDiceSymbol.SKULL);
	     hmap.put(3,  CombatDiceSymbol.SKULL);
	     hmap.put(4,  CombatDiceSymbol.HERO_SHIELD);
	     hmap.put(5,  CombatDiceSymbol.HERO_SHIELD);
	     hmap.put(6,  CombatDiceSymbol.MONSTER_SHIELD);
	}
	
	
	public int rollAttackDice(int numberOfDice) {
		int result=0;
		ArrayList<CombatDiceSymbol> diceArray = this.getResult(numberOfDice);
		
		for (CombatDiceSymbol D : diceArray) {
			if (D==CombatDiceSymbol.SKULL) {
				result++;
			}
		}
		return result;
	}
	
	public int rollHeroDefenseDice(int numberOfDice) {
		int result=0;
		ArrayList<CombatDiceSymbol> diceArray = this.getResult(numberOfDice);
		for (CombatDiceSymbol D : diceArray) {
			if (D==CombatDiceSymbol.HERO_SHIELD) {
				result++;
			}			
		}
		return result;
	}
	
	public int rollMonsterDefenseDice(int numberOfDice) {
		int result=0;
		ArrayList<CombatDiceSymbol> diceArray = this.getResult(numberOfDice);
		for (CombatDiceSymbol D : diceArray) {
			if (D==CombatDiceSymbol.MONSTER_SHIELD) {
				result++;
			}			
		}
		return result;
	}
	
	//-------------
	
	//returns a random CombatDiceSymbol for each dice
	private CombatDiceSymbol rollDice() {
		Random r = new Random();
		int n = r.nextInt(high-low+1) + low;
		return hmap.get(n);
	}
	
	private ArrayList<CombatDiceSymbol> getResult(int numberOfDice) {
		ArrayList<CombatDiceSymbol> combatDiceSymbols = new ArrayList<CombatDiceSymbol>();
		for (int i=1;i<=numberOfDice; i++) {
			combatDiceSymbols.add(rollDice());
		}
		return combatDiceSymbols;
	}
	
}
