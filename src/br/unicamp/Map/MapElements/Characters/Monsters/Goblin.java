package br.unicamp.Map.MapElements.Characters.Monsters;

import br.unicamp.Items.Weapons.Dagger;
import br.unicamp.Items.Weapons.Weapon;

public class Goblin extends Monster {

	public Goblin(){
		super("Goblin",0,0,0,0);
		Dagger dagger1 = new Dagger();
		Dagger dagger2 = new Dagger();
		Dagger dagger3 = new Dagger();
		Dagger dagger4 = new Dagger();
//		this.equipWeapon(dagger1);
//		this.equipWeapon(dagger2);
//		this.equipWeapon(dagger3);
//		this.equipWeapon(dagger4);
	}
	
	@Override
	public String toString() {
		return "G";
	}
	
}
