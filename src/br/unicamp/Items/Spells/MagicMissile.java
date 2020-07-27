package br.unicamp.Items.Spells;


import br.unicamp.Dices.CombatDice;
import br.unicamp.Dices.RedDice;
import br.unicamp.Exceptions.SpellNotCastedException;
import br.unicamp.Map.Map;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;
import br.unicamp.Map.MapElements.Characters.Monsters.Monster;

public class MagicMissile extends Spell {
	
	public static final int POINTS = 2;
	public static final int RANGE = 3;
	public MagicMissile() {
		super(POINTS);
	}

	
	@Override
	public String toString() {
		String description = "";
		description += "Magic Missile - ";
		description += "2 of damage on target each from 3 missiles";
		return description;
	}


	@Override
	public void beCasted(Hero attacker, Map map, RedDice redDice, CombatDice combatDice, String speller) throws SpellNotCastedException {
		Monster defensor =  map.checkMonsterTargets(RANGE, attacker);
		if (defensor != null){
			for (int i=0; i<3; i++) {
				defensor.defenseAgainstMagic(combatDice, this.points, speller, map);
			}
		}else {
			throw new SpellNotCastedException("No visible monsters on the Heros range");
		}
	}
	
	@Override
	public void beCasted(Monster attacker,Hero defensor, Map map, RedDice redDice, CombatDice combatDice, String speller) throws SpellNotCastedException {
		int distance = map.maxAbsDistanceOneDimension(attacker, defensor);
		if (distance<=RANGE) {
			for (int i=0; i<3; i++) {
				defensor.defenseAgainstMagic(combatDice, this.points, speller, map);
			}
		}else {
			throw new SpellNotCastedException("No hero on the monster range");
		}
	}
}



