package br.unicamp.Map.MapElements.Characters;

import br.unicamp.Items.Armor.*;
import br.unicamp.Items.Weapons.*;
import br.unicamp.Map.MapElements.MapElement;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;
import br.unicamp.Dices.*;
import br.unicamp.Game.Command;
import br.unicamp.Interfaces.Collectable;

public abstract class Character extends MapElement{
	protected String name;
	protected int attackPoints;
	protected int defensePoints;
	protected int lifePoints;
	protected int mana;
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
	
	public int getMana(){
		return mana;
	}
	 
	protected int defenseAgainstMagic(CombatDice combatDice){
		//TODO
		int result=0;
		//combatDice.rollDices();
		//retonar os pontos de defesa
		//para se defender podem ser lancados dados de combate
		//tantos quanto os pontos de mana
		return result;
	}
	
	protected void receiveDamage(int damage, int defense){
		lifePoints = lifePoints-damage+defense;
	}
	
	//-------------------- NPCs actions
	protected abstract void dummyWalk(Character character, RedDice redDice);
	protected abstract void dummyAction(Character character, CombatDice combatDice);
	
	
}
