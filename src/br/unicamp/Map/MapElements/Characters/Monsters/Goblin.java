package br.unicamp.Map.MapElements.Characters.Monsters;

import br.unicamp.Items.Weapons.Dagger;
import br.unicamp.Items.Weapons.Weapon;

public class Goblin extends Monster {

	public static final int ATK = 1; // Attack Points
	public static final int DEF = 1; // Defense Points
	public static final int LP = 1; // Life Points
	public static final int MP = 0; // Mana Points
	
	public Goblin(int x0, int y0){
		super(x0,y0,"Goblin", Goblin.ATK, Goblin.DEF, Goblin.LP, Goblin.MP);

		//		Dagger dagger1 = new Dagger();
//		Dagger dagger2 = new Dagger();
//		Dagger dagger3 = new Dagger();
//		Dagger dagger4 = new Dagger();
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
