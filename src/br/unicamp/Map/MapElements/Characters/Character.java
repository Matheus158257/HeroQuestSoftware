package br.unicamp.Map.MapElements.Characters;

import br.unicamp.Items.Bag;
import br.unicamp.Items.Armor.*;
import br.unicamp.Items.Weapons.*;
import br.unicamp.Map.MapElements.MapElement;
import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;
import br.unicamp.Dices.*;
import br.unicamp.Game.Command;
import br.unicamp.Interfaces.Collectable;

public abstract class Character extends MapElement{
	
	public final static int HANDS = 2;
	
	protected String name;
	protected int attackPoints;
	protected int defensePoints;
	protected int lifePoints;
	protected int mana;
	protected Bag bag;
	
	protected Weapon weapons[];
	protected int occupiedHands = 0;
	
	public Character(int x0, int y0, String name,int attackPoints,int defensePoints, int lifePoints, int mana){
		super(x0,y0);
		this.name = name;
		this.attackPoints = attackPoints;
		this.defensePoints = defensePoints;
		this.lifePoints = lifePoints;
		this.mana = mana;
		this.bag = new Bag();
	}
	
	public void giveAttackBonus(int bonus) {
		this.attackPoints+=bonus;
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
	
	public int getAttackRange() {
		int range=0;
		for(Weapon w:this.weapons) {
			if(w!=null && range<w.getRange()) {
					range =w.getRange();
			}
		}
		
		return range;
	}
	
	public int getDamagePoints() {
		return this.attackPoints;
		// TODO metodo que retorna e dano infligido pelas armas atualmente equipadas
	}
	
	public boolean takeDamage(int damage) {
		this.lifePoints-=damage;
		
		if(this.lifePoints<=0) {
			return true; // has died
		} else {
			return false; // is still alive
		}
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
	
	protected void equipWeapon(Weapon newWeapon) {
		if (this.occupiedHands < Character.HANDS) {
				this.bag.removeItem(newWeapon); //tira a arma da sacola e p�es nas m�os do h�roi
				if(newWeapon.getIsShort()){
					weapons[this.occupiedHands]=newWeapon;
					this.occupiedHands++;
				}else{
					weapons[this.occupiedHands]=newWeapon;
					this.occupiedHands+=2;
				}
		}else {
			System.out.println("LOG: Both hands are occupied.");
		}
	}
	
	
	protected void unequipWeapon(Weapon removWeapon){
		this.bag.putIntoTheBag(removWeapon);
		if(removWeapon.getIsShort()){
			weapons[occupiedHands]=null;
			occupiedHands--;
		}else{
			for(Weapon w:weapons) {
				w = null;
			}
			occupiedHands=0;
		}
		this.giveAttackBonus(-1*removWeapon.getAttackBonus());
		
	}
	
	//-------------------- NPCs actions
	protected abstract void dummyWalk(Character character, RedDice redDice, MapElement map[][]);
	protected abstract void dummyAction(Character character, CombatDice combatDice,MapElement map[][]);
	
	
	@Override
	public boolean interact(Character character, String interactable) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean getOpened(Character character) {
		return false;
	}
	@Override
	public boolean goThrough(Character character) {
		return false;
	}


	
}
