package br.unicamp.Map.MapElements.Characters;

import br.unicamp.Items.Armor.*;
import br.unicamp.Items.Weapons.*;
import br.unicamp.Map.MapElements.MapElement;
import br.unicamp.Dices.*;
import br.unicamp.Game.Command;
import br.unicamp.Interfaces.Collectable;

public abstract class Character extends MapElement{
	private String name;
	private int attackPoints;
	private int defensePoints;
	private int lifePoints;
	private int mana;
	protected Armor armor;
	protected Weapon weapons[];
	
	public Character(int x0, int y0, String name,int attackPoints,int defensePoints, int lifePoints, int mana){
		super(x0,y0);
		this.name = name;
		this.attackPoints = attackPoints;
		this.defensePoints = defensePoints;
		this.lifePoints = lifePoints;
		this.mana = mana;
	}

	public void changePosition(Command direction) {
		
		switch (direction) {
		case UP:
			this.incrementCoordinates(0,-1);
			break;
		case RIGHT:
			this.incrementCoordinates(1,0);
			break;
		case DOWN:
			this.incrementCoordinates(0,1);
			break;
		case LEFT:
			this.incrementCoordinates(-1,0);
			break;
		default:
			break;
				
		}
	}
	
	public void changePosition(int newX, int newY) {
		this.changeCoordinates(newX, newY);
	}
	
	protected int getMana(){
		return mana;
	}
	 
	protected void defenseAgainstMagic(Dice combatDice){
		//TODO
		//para se defender podem ser lancados dados de combate
		//tantos quanto os pontos de mana
	}
	
	protected void receiveDamage(int damage){
		lifePoints = lifePoints-damage;
	}

	
}
