package br.unicamp.Map.MapElements.Characters.Monsters;

import br.unicamp.Dices.CombatDice;
import br.unicamp.Dices.RedDice;
import br.unicamp.Exceptions.SpellNotCastedException;
import br.unicamp.Interfaces.Caster;
import br.unicamp.Map.Map;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;


public class SkeletonWizard extends Monster implements Caster {

	public static final int ATK = 1;
	public static final int DEF = 1;
	public static final int LP = 4;
	public static final int MP = 1;
	
	
	public SkeletonWizard(int x0, int y0) {
		super(x0,y0,"Skeleton", SkeletonWizard.ATK, SkeletonWizard.DEF, SkeletonWizard.LP, SkeletonWizard.MP,true);
	}

	@Override
	public String toString() {
		if(this.isVisible()) {
			return "K";
		} else {
			return "-";
		}
	}
	
	@Override
	public String toString(boolean complete) {
		if(complete) {
			return("Skeleton Wizard (ATK:" + this.attackPoints + "|DEF:" + this.defensePoints + "|LP:" + this.lifePoints + "|MP:" + this.mana + ")");
		} else {
			return this.toString();
		}
	}


	@Override
	public void castSpell(Map map, RedDice redDice, CombatDice combatDice) {}
	
	@Override
	public Boolean castSpell(Map map,Hero hero, RedDice redDice, CombatDice combatDice) {
		Boolean result = false;
		if (this.spells.size()>0){
			try {
				this.spells.get(0).beCasted(this,hero,map,redDice,combatDice, "Monster");
			} catch (SpellNotCastedException e) {
				System.out.println(e.getMessage());
			}
			this.spells.remove(0);
			result = true;
		}
		return result;
	}
}
