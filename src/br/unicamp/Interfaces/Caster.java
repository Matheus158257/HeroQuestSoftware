package br.unicamp.Interfaces;



import br.unicamp.Dices.*;
import br.unicamp.Map.Map;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;


public interface Caster {
	//used by Heros
	public void castSpell(Map map, RedDice redDice1, CombatDice combatDice);
	//used by Monsters
	public Boolean castSpell(Map map, Hero hero, RedDice redDice, CombatDice combatDice);

}
