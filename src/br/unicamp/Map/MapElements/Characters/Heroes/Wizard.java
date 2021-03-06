package br.unicamp.Map.MapElements.Characters.Heroes;

import java.util.ArrayList;

import br.unicamp.Dices.CombatDice;
import br.unicamp.Dices.RedDice;
import br.unicamp.Exceptions.OutOfBoundsException;
import br.unicamp.Exceptions.SpellNotCastedException;
import br.unicamp.Interfaces.Caster;
import br.unicamp.Items.Spells.Fireball;
import br.unicamp.Items.Spells.MagicMissile;
import br.unicamp.Items.Spells.Spell;
import br.unicamp.Items.Spells.Teleport;
import br.unicamp.Items.Weapons.Dagger;
import br.unicamp.Items.Weapons.Weapon;
import br.unicamp.Map.Map;



public class Wizard extends Hero implements  Caster{
	
	public static final int ATK = 1; // Attack Points
	public static final int DEF = 2; // Defense Points
	public static final int LP = 3; // Life Points
	public static final int MP = 4; // Mana Points
	
	public Wizard (int x0, int y0){
		super(x0,y0,"Wizard",Wizard.ATK,Wizard.DEF,Wizard.LP,Wizard.MP,true);
		
		Weapon dagger1 = new Dagger();
		Weapon dagger2 = new Dagger();
		Weapon dagger3 = new Dagger();
		this.bag.putIntoTheBag(dagger1);
		this.bag.putIntoTheBag(dagger2);
		this.bag.putIntoTheBag(dagger3);
		
		this.equipWeapon(dagger1);
		this.equipWeapon(dagger2);

		this.spells.add(new MagicMissile());
		this.spells.add(new Fireball());
		this.spells.add(new Teleport());
	}
	

	@Override
	public String toString() {
		return "W";
	}
	
	@Override
	public String toString(boolean complete) {
		if(complete) {
			return("Wizard (ATK:" + this.attackPoints + "|DEF:" + this.defensePoints + "|LP:" + this.lifePoints + "|MP:" + this.mana + ")");
		} else {
			return this.toString();
		}
	}

	// ----------------- Spell Methods
	
//	private void heroGetSpell(Spell newSpell){
//	heroSpells[actualSpellsNo]= newSpell;
//	actualSpellsNo++;
//}
	
	@Override
	public void castSpell(Map map, RedDice redDice, CombatDice combatDice) {
		showSpellOptions();
		try {
			int spellNumber = readSpellsNumber();
			if (spellNumber>-1) {
				try {
					this.spells.get(spellNumber).beCasted(this,map,redDice,combatDice,"Hero");
				} catch (SpellNotCastedException e) {
					System.out.println(e.getMessage());
				}
				this.spells.remove(spellNumber);
			}
			} catch (IndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
	}
	
	@Override
	public Boolean castSpell(Map map, Hero hero, RedDice redDice, CombatDice combatDice) {
		return false;
	}

	
}
 