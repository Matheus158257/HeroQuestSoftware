package br.unicamp.Map.MapElements.Characters.Heroes;

import br.unicamp.Items.Weapons.LongSword;
import br.unicamp.Items.Weapons.Weapon;

public class Barbarian extends Hero {
	
	public Barbarian (int x0, int y0){
		super(x0,y0,"Barbarian",3,2,8,2);
		Weapon longSword = new LongSword();
		this.equipWeapon(longSword);
	}
	
	@Override
	public String toString() {
		return "B";
	}
	
	 
}
