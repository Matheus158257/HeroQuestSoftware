package br.unicamp.Items.Weapons;

import br.unicamp.Interfaces.Collectable;
import br.unicamp.Interfaces.Usable;
import br.unicamp.Map.MapElements.Characters.Character;

public class Weapon implements Collectable{
	
	protected int range;
	protected int attackBonus;
	protected boolean destroys;
	protected boolean OTHERBONUS;
	
	public Weapon(int attackBonus){
		this.attackBonus=attackBonus;
	}


	@Override
	public void report() {
		String message = "Weapon: "  + "(range " + String.valueOf(range) + ") (attackBonus" + String.valueOf(attackBonus) + ")";
		System.out.println(message);
	}

}
