package br.unicamp.Items.Spells;

import java.util.Random;

import br.unicamp.Dices.CombatDice;
import br.unicamp.Dices.RedDice;
import br.unicamp.Map.Map;
import br.unicamp.Map.MapElements.MapElement;
import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;
import br.unicamp.Map.MapElements.Characters.Monsters.Monster;

public class Teleport extends Spell {

	public static final int POINTS = 0;
	public static final int RANGE = 33;//MÁXIMO DO MAPA
	public Teleport() {
		super(POINTS);
	}
	
	


	
	@Override
	public String toString() {
		String description = "";
		description += "Teleport - ";
		description += "Move to a randon visible position on map";
		return description;
	}



	private int getRandomNumberBetweenLimits(int low, int high) {
		int result = 0;
		Random r = new Random();
		result = r.nextInt(high-low+1) + low;
		return result;
	}

	@Override
	public void beCasted(Hero attacker, Map map, RedDice redDice, CombatDice combatDice, String speller) {
		Boolean running = true;
		int newX = 0;
		int newY = 0;
		while(running) {
			newX = getRandomNumberBetweenLimits(0,33);
			newY = getRandomNumberBetweenLimits(0,24);
			if (map.isFree(newX,newY)) {
				map.telePortCharacter(attacker,newX,newY);
				running = false;
			}
		}
		
	}





	@Override
	public void beCasted(Monster attacker, Hero defensor, Map map, RedDice redDice, CombatDice combatDice,
			String speller) {
			Boolean running = true;
			int x = 0;
			int y = 0;
			while(running) {
				x = getRandomNumberBetweenLimits(0,33);
				y = getRandomNumberBetweenLimits(0,24);
				if (map.isFree(x,y)) {
					map.addElement(attacker);
					running = false;
				}
			}
	}



}
