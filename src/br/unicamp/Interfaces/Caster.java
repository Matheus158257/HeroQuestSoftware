package br.unicamp.Interfaces;

import br.unicamp.Dices.*;
import br.unicamp.Items.Spells.Spell;

public interface Caster {
	
	public void castSpell(Spell castSpell, Character target, RedDice redDice1, CombatDice combatDice);
}
