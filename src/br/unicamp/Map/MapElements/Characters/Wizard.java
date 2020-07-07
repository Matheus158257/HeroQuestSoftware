package br.unicamp.Map.MapElements.Characters;

import br.unicamp.Map.MapElements.Spell.Fireball;
import br.unicamp.Map.MapElements.Spell.MagicMissile;
import br.unicamp.Map.MapElements.Spell.Spell;
import br.unicamp.Map.MapElements.Spell.Teleport;
import br.unicamp.Map.MapElements.Weapons.Dagger;
import br.unicamp.Map.MapElements.Weapons.Weapon;


public class Wizard extends Hero {
	public static final int MAX_HERO_SPELLS = 4;
	private Spell heroSpells[];
	private int actualSpellsNo = 0;
	
	public Wizard (){
		super("Wizard",1,2,4,6);
		Weapon dagger1 = new Dagger();
		Weapon dagger2 = new Dagger();
		Weapon dagger3 = new Dagger();
		this.equipWeapon(dagger1);
		this.equipWeapon(dagger2);
		this.equipWeapon(dagger3);
		Spell magicmissile = new MagicMissile();
		heroGetSpell(magicmissile);
		Spell fireball = new Fireball();
		heroGetSpell(fireball);
		Spell teleport = new Teleport();
		heroGetSpell(teleport);
	}
	
	private void heroGetSpell(Spell newSpell){
		heroSpells[actualSpellsNo]= newSpell;
		actualSpellsNo++;
	}

}
 