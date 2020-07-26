package br.unicamp.Interfaces;

import br.unicamp.Dices.CombatDice;
import br.unicamp.Dices.RedDice;
import br.unicamp.Exceptions.SpellNotCastedException;
import br.unicamp.Map.Map;
import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;
import br.unicamp.Map.MapElements.Characters.Monsters.Monster;

public interface Castable {
	
	public void beCasted(Hero attacker, Map map, RedDice redDice, CombatDice combatDice, String speller) throws SpellNotCastedException;

	public void beCasted(Monster attacker, Hero defensor, Map map, RedDice redDice, CombatDice combatDice, String speller) throws SpellNotCastedException;
}
