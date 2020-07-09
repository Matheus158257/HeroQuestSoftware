package br.unicamp.Map.MapElements.Characters;

import br.unicamp.Items.Spells.Fireball;
import br.unicamp.Items.Spells.MagicMissile;
import br.unicamp.Items.Spells.Spell;
import br.unicamp.Items.Spells.Teleport;
import br.unicamp.Items.Weapons.Dagger;
import br.unicamp.Items.Weapons.Weapon;


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
 