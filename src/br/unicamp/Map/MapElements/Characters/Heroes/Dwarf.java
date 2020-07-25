package br.unicamp.Map.MapElements.Characters.Heroes;

import br.unicamp.Items.Weapons.ShortSword;
import br.unicamp.Items.Weapons.Weapon;

public class Dwarf extends Hero{
	
	public static final int ATK = 2; // Attack Points
	public static final int DEF = 2; // Defense Points
	public static final int LP = 7; // Life Points
	public static final int MP = 3; // Mana Points
	
	public Dwarf (int x0, int y0){
		super(x0,y0,"Dwarf",Dwarf.ATK,Dwarf.DEF,Dwarf.LP,Dwarf.MP,false);
		Weapon shortSword = new ShortSword();
		this.equipWeapon(shortSword);
	}
	
	@Override
	public String toString() {
		return "D";
	}

}
