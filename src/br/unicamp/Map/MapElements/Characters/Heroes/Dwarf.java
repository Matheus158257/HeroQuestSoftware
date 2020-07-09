package br.unicamp.Map.MapElements.Characters.Heroes;

import br.unicamp.Items.Weapons.ShortSword;
import br.unicamp.Items.Weapons.Weapon;

public class Dwarf extends Hero{
	
	public Dwarf (){
		super("Dwarf",2,2,7,3);
		Weapon shortSword = new ShortSword();
		this.equipWeapon(shortSword);
	}
	
	@Override
	public String toString() {
		return "D";
	}

}
