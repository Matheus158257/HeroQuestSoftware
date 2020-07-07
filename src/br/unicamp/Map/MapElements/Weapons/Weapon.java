package br.unicamp.Map.MapElements.Weapons;

public class Weapon {
	
	protected int range;
	protected int attackBonus;
	protected boolean destroys;
	protected boolean OTHERBONUS;
	
	public Weapon(int attackBonus){
		this.attackBonus=attackBonus;
	}
}
