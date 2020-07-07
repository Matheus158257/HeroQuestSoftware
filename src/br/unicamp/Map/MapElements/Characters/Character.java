package br.unicamp.Map.MapElements.Characters;

import br.unicamp.Map.MapElements.Armor.Armor;
import br.unicamp.Map.MapElements.Weapons.Weapon;

public abstract class Character {
	private String name;
	private int attackPoints;
	private int defensePoints;
	private int lifePoints;
	private int mana;
	protected Armor armor;
	protected Weapon weapons[];
	
	public Character(String name,int attackPoints,int defensePoints, int lifePoints, int mana){
		this.name = name;
		this.attackPoints = attackPoints;
		this.defensePoints = defensePoints;
		this.lifePoints = lifePoints;
		this.mana = mana;
	}
	
	public void moveUp(){}
	
	public void moveDown(){}
	
	public void moveRight(){}
	
	public void moveLeft(){}
	
	protected int getMana(){
		return mana;
	}
	 
	protected void defenseAgainstMagic(Dice combatDice){
		//para se defender podem ser lançados dados de combate
		//tentos quanto os pontos de mana
		//implementar
	}
	
	protected void receiveDamage(int damage){
		lifePoints = lifePoints-damage;
	}
	
}
