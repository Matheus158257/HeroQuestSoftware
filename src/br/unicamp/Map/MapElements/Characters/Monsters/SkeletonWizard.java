package br.unicamp.Map.MapElements.Characters.Monsters;

import br.unicamp.Dices.CombatDice;
import br.unicamp.Dices.RedDice;
import br.unicamp.Interfaces.Caster;
import br.unicamp.Map.MapElements.Spell.Spell;

public class SkeletonWizard extends Monster implements Caster {

	public static final int ATK = 1;
	public static final int DEF = 1;
	public static final int LP = 1;
	public static final int MP = 1;
	
	
	public SkeletonWizard(int x0, int y0) {
		super(x0,y0,"Skeleton", SkeletonWizard.ATK, SkeletonWizard.DEF, SkeletonWizard.LP, SkeletonWizard.MP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "K";
	}

	@Override
	public void castSpell(Spell castSpeell, Monster targetMontser, RedDice redDice1, CombatDice combatDice) {
		int result = redDice1.rollDices();
		if(result<this.getMana()){
			// verifica os pontos de dano da spell lançada
			// int damage = castSpeell.getDamage();
			// verifica se o alvo tem defesa e retona quantos pontos ele tem de defesa
			// int targetDefensePoints = targetMontser.defenseAgainstMagic(combatDice);
			// targetMontser.receiveDamage(damage,targetDefensePoints);
		}		
	}
	
}
