package br.unicamp.Map.MapElements.Characters;

import br.unicamp.Map.MapElements.Weapons.LongSword;
import br.unicamp.Map.MapElements.Weapons.Weapon;

public class Barbarian extends Hero {
	
	public Barbarian (){
		super("Barbarian",3,2,8,2);
		Weapon longSword = new LongSword();
		this.equipWeapon(longSword);
	}
	
	 
}
