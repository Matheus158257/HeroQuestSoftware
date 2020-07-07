package br.unicamp.Map.MapElements.Characters;

import br.unicamp.Map.MapElements.Weapons.Dagger;

public class Goblin extends Monster {

	public Goblin(){
		super("Goblin",0,0,0,0);
		Dagger dagger1 = new Dagger();
		Dagger dagger2 = new Dagger();
		Dagger dagger3 = new Dagger();
		Dagger dagger4 = new Dagger();
		this.equipWeapon(dagger1);
		this.equipWeapon(dagger2);
		this.equipWeapon(dagger3);
		this.equipWeapon(dagger4);
	}
}
