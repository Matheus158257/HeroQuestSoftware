package br.unicamp.Map.MapElements.Characters.Heroes;

import br.unicamp.Items.Weapons.LongSword;
import br.unicamp.Items.Weapons.Weapon;

public class Barbarian extends Hero {
	
	public static final int ATK = 3; // Attack Points
	public static final int DEF = 2; // Defense Points
	public static final int LP = 8; // Life Points
	public static final int MP = 0; // Mana Points
	
	public Barbarian (int x0, int y0){
		super(x0,y0,"Barbarian",Barbarian.ATK,Barbarian.DEF,Barbarian.LP,Barbarian.MP);
		Weapon longSword = new LongSword();
		this.equipWeapon(longSword);
	}
	
	
	@Override
	public String toString() {
		return "B";
	}
	
	@Override
	public String toString(boolean complete) {
		if(complete) {
			return("Barbarian (ATK:" + this.attackPoints + "|DEF:" + this.defensePoints + "|LP:" + this.lifePoints + "|MP:" + this.mana + ")");
		} else {
			return this.toString();
		}
	}
	
	 
}
