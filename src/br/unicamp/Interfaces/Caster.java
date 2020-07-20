package br.unicamp.Interfaces;

import br.unicamp.Map.MapElements.Characters.Monsters.Monster;
import br.unicamp.Dices.*;
import br.unicamp.Items.Spells.Spell;

public interface Caster {
	
	public void castSpell(Spell castSpell, Monster targetMontser, RedDice redDice1, CombatDice combatDice);
}
