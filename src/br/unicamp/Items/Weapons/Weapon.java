package br.unicamp.Items.Weapons;

import br.unicamp.Interfaces.Collectable;
import br.unicamp.Interfaces.Usable;
import br.unicamp.Map.MapElements.Characters.Character;

public class Weapon implements Collectable{
	
	protected int range;
	protected int attackBonus;// dados de ataque
	protected boolean destroys;
	protected boolean OTHERBONUS;
	protected boolean isShort;
	
	public Weapon(int attackBonus){
		this.attackBonus=attackBonus;
	}
	
	public boolean getIsShort(){
		return isShort;
	}
	
	public int getAttackBonus(){
		return attackBonus;
	}

	@Override
	public void report() {
		String message = "Weapon: "  + "(range " + String.valueOf(range) + ") (attackBonus" + String.valueOf(attackBonus) + ")";
		System.out.println(message);
	}

}
