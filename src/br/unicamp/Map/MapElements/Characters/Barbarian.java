package br.unicamp.Map.MapElements.Characters;

import br.unicamp.Items.Weapons.LongSword;
import br.unicamp.Items.Weapons.Weapon;

public class Barbarian extends Hero {
	
	public Barbarian (){
		super("Barbarian",3,2,8,2);
		Weapon longSword = new LongSword();
		this.equipWeapon(longSword);
	}
	
	 
}
