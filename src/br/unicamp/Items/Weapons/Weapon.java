package br.unicamp.Items.Weapons;

import br.unicamp.Interfaces.Collectable;
import br.unicamp.Interfaces.Usable;
import br.unicamp.Map.MapElements.Characters.Character;

public class Weapon implements Collectable{
	
	private int range;
	private int attackBonus;// dados de ataque
	private boolean destroys;
	private boolean isShort;
	
	public Weapon(int range, int attackBonus, boolean destroys, boolean isShort){
		this.range=range;
		this.attackBonus=attackBonus;
		this.destroys=destroys;
		this.isShort=isShort;
	}
	
	public boolean getIsShort(){
		return this.isShort;
	}
	
	public int getAttackBonus(){
		return this.attackBonus;
	}
	
	public int getRange() {
		return this.range;
	}

//	@Override
	public void report() {
		String message = "Weapon: "  + "(range " + String.valueOf(range) + ") (attackBonus" + String.valueOf(attackBonus) + ")";
		System.out.println(message);
	}

	public String getData() {
		String message = "(range " + String.valueOf(range) + ") (attackBonus" + String.valueOf(attackBonus) + ")\n";
		return message;
	}
	
}
