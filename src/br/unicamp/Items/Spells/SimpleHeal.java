package br.unicamp.Items.Spells;

import br.unicamp.Dices.CombatDice;
import br.unicamp.Dices.RedDice;
import br.unicamp.Exceptions.LifeOnMaximumException;
import br.unicamp.Map.Map;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;
import br.unicamp.Map.MapElements.Characters.Monsters.Monster;

public class SimpleHeal extends Spell {

	public static final int POINTS = 1;
	public SimpleHeal() {
		super(POINTS);
	}

	//cura um valor de 1 a 6 pontos de vida. Obtido jogando-se o dado vermelho
	
	@Override
	public String toString() {
		String description = "";
		description += "Simple Heal - ";
		description += "1 of recover";
		return description;
	}

	@Override
	public void beCasted(Hero attacker, Map map, RedDice redDice, CombatDice combatDice, String speller) {
		int nHeals = redDice.getResult(1);
		try {
			attacker.beHealed(nHeals);
		} catch (LifeOnMaximumException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void beCasted(Monster attacker, Hero defensor, Map map, RedDice redDice, CombatDice combatDice,
			String speller) {
		int nHeals = redDice.getResult(1);
		try {
			attacker.beHealed(nHeals);
		} catch (LifeOnMaximumException e) {
			System.out.println(e.getMessage());
		}
		
	}


}
