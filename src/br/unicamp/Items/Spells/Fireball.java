package br.unicamp.Items.Spells;

import java.util.ArrayList;

import br.unicamp.Dices.CombatDice;
import br.unicamp.Dices.RedDice;
import br.unicamp.Exceptions.SpellNotCastedException;
import br.unicamp.Map.Map;
import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;
import br.unicamp.Map.MapElements.Characters.Monsters.Monster;

public class Fireball extends Spell {
	
	public static final int POINTS = 6;
	public static final int EXTRA_POINTS = 3;
	public static final int RANGE = 3;
	public Fireball() {
		super(POINTS);
	}
	//o alvo leva dado de 6 pontos
	//personagens nas posi��es adjascentes leam 3 pontos de dano
	/*protected void castFireball(Character goal){
		goal.receiveDamage(6);
		//chama fun�ao para "ver se h� alvos nas adjascencias do alvo"
		//se tiver, receber o(s) alvos adjascentes
		//chamar a goal.receiveDamage(3) para cada alvo
		//se n�o, fim da fun��o
	}*/
	
	
	
	@Override
	public String toString() {
		String description = "";
		description += "Fireball - ";
		description += "6 of damage on target - ";
		description += "3 of damage on target bounds";
		return description;
	}
	@Override
	public void beCasted(Hero attacker, Map map, RedDice redDice, CombatDice combatDice, String speller) throws SpellNotCastedException {
		Monster mainDefensor =  map.checkMonsterTargets(RANGE, attacker);
		System.out.println(mainDefensor.getX());
		System.out.println(mainDefensor.getY());
		if(mainDefensor != null) {
			ArrayList<Monster> monstersAround = map.getMonstersAround(RANGE, mainDefensor);
			mainDefensor.defenseAgainstMagic(combatDice, this.points, speller, map);
			for (Monster monsterAround: monstersAround) {
				monsterAround.defenseAgainstMagic(combatDice,EXTRA_POINTS, speller, map);
			}
		}else{
			throw new SpellNotCastedException("No visible monsters on the Heros range");
		}
		
		
	}
	@Override
	public void beCasted(Monster attacker, Hero defensor, Map map, RedDice redDice, CombatDice combatDice,
			String speller) throws SpellNotCastedException {
		int distance = map.oneAxeMaxAbsoluteDistanceBetweenCharacters(attacker, defensor);
		if (distance<=RANGE) {
				defensor.defenseAgainstMagic(combatDice, this.points, speller, map);
		}else {
			throw new SpellNotCastedException("No hero on the monster range");
		}
	}
	
	
}
