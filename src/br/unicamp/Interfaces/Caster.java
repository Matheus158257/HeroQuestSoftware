package br.unicamp.Interfaces;

import br.unicamp.Map.MapElements.Characters.Monsters.Monster;
import br.unicamp.Map.MapElements.Spell.Spell;
import br.unicamp.Dices.*;

public interface Caster {
	
	public void castSpell(Spell castSpeell, Monster targetMontser, RedDice redDice1, CombatDice combatDice);
}
