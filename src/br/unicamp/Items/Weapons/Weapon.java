package br.unicamp.Items.Weapons;

import br.unicamp.Interfaces.Collectable;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;

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
	

	@Override
	public void report(int i) {
		String message = String.valueOf(i) + " - "+ "Weapon: "  + "(range " + String.valueOf(range) + ") (attackBonus" + String.valueOf(attackBonus) + ")";
		System.out.println(message);
	}
	
	@Override
	public void report() {
		String message = "Weapon: "  + this.getData();
		System.out.println(message);
	}

	public String getData() {
		String message = "(Range: " + String.valueOf(range) + ") (+" + String.valueOf(attackBonus) + " Attack Points)";
		return message;
	}

	@Override
	public void use(Hero hero) {
		hero.changeWeapon(this);
		
	}
	
}
