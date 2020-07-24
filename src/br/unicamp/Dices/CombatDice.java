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
	
	//returns a random CombatDiceSymbol for each dice
	private CombatDiceSymbol rollDice() {
		Random r = new Random();
		int n = r.nextInt(high-low+1) + low;
		return hmap.get(n);
	}
	
	public ArrayList<CombatDiceSymbol> getRedDicesResult(int numberOfDice) {
		ArrayList<CombatDiceSymbol> combatDicesSymbols = new ArrayList<CombatDiceSymbol>();
		for (int i=1;i<=numberOfDice; i++) {
			combatDicesSymbols.add(rollDice());
		}
		return combatDicesSymbols;
	}
	
	
}
