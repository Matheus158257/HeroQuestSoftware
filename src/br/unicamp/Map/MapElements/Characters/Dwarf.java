package br.unicamp.Map.MapElements.Characters;

import br.unicamp.Map.MapElements.Weapons.ShortSword;
import br.unicamp.Map.MapElements.Weapons.Weapon;

public class Dwarf extends Hero{
	
	public Dwarf (){
		super("Dwarf",2,2,7,3);
		Weapon shortSword = new ShortSword();
		this.equipWeapon(shortSword);
	}

}
