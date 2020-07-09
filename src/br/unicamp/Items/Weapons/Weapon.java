package br.unicamp.Items.Weapons;

public class Weapon {
	
	protected int range;
	protected int attackBonus;
	protected boolean destroys;
	protected boolean OTHERBONUS;
	
	public Weapon(int attackBonus){
		this.attackBonus=attackBonus;
	}
}
