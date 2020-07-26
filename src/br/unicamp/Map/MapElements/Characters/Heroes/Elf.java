package br.unicamp.Map.MapElements.Characters.Heroes;

import java.util.ArrayList;


import java.util.Scanner;
import br.unicamp.Dices.CombatDice;
import br.unicamp.Dices.RedDice;
import br.unicamp.Exceptions.OutOfBoundsException;
import br.unicamp.Exceptions.SpellNotCastedException;
import br.unicamp.Interfaces.Caster;
import br.unicamp.Items.Spells.SimpleHeal;
import br.unicamp.Items.Spells.Spell;
import br.unicamp.Items.Weapons.ShortSword;
import br.unicamp.Items.Weapons.Weapon;
import br.unicamp.Map.Map;

public class Elf extends Hero implements Caster{
	
	public static final int ATK = 2; // Attack Points
	public static final int DEF = 2; // Defense Points
	public static final int LP = 6; // Life Points
	public static final int MP = 4; // Mana Points
	
	
	public Elf (int x0, int y0){
		super(x0,y0,"Elf",Elf.ATK,Elf.DEF,Elf.LP,Elf.MP,true);
		Weapon shortSword =  new ShortSword();
		this.bag.putIntoTheBag(shortSword);
		this.equipWeapon(shortSword);
		this.spells.add(new SimpleHeal());
		
	}


	@Override
	public String toString() {
		return "E";
	}



	@Override
	public String toString(boolean complete) {
		if(complete) {
			return("Elf (ATK:" + this.attackPoints + "|DEF:" + this.defensePoints + "|LP:" + this.lifePoints + "|MP:" + this.mana + ")");
		} else {
			return this.toString();
		}
	}
	
	
	// ----------------- Spell Methods
	
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

