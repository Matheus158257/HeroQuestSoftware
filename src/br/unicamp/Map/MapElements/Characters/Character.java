package br.unicamp.Map.MapElements.Characters;

import br.unicamp.Items.Bag;
import br.unicamp.Items.Weapons.*;
import br.unicamp.Map.MapElements.MapElement;
import br.unicamp.Dices.*;
import br.unicamp.Exceptions.ItemNotInBagException;
import br.unicamp.Game.Command;

public abstract class Character extends MapElement{
	protected String name;
	protected int attackPoints;
	protected int defensePoints;
	protected int lifePoints;
	protected int maxLifePoints;
	protected int mana;
	protected Bag bag;
	
	protected Weapon weapons[];
	protected int equippedWeapons = 0;
	
	public Character(int x0, int y0, String name,int attackPoints,int defensePoints, int lifePoints, int mana){
		super(x0,y0);
		this.name = name;
		this.attackPoints = attackPoints;
		this.defensePoints = defensePoints;
		this.lifePoints = lifePoints;
		this.maxLifePoints = lifePoints;
		this.mana = mana;
		this.bag = new Bag();
	}
	
	protected void giveAttackBonus(int bonus) {
		this.attackPoints+=bonus;
	}
	
	protected void giveDefenseBonus(int bonus) {
		this.defensePoints+=bonus;
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
	
	
	//@Override
		protected void equipWeapon(Weapon newWeapon){
			//TODO Resolver estouro de tamanho do vetor
			try {
				this.bag.removeItem(newWeapon);
			}catch(ItemNotInBagException e) {
				//Não faz nada. Para o caso em que é a arma inicial
			}
			if(newWeapon.getIsShort()){
				if(equippedWeapons ==2) {
					if(weapons[1]==null) {//long sword na 0
						this.unequipWeapon();
						weapons[0] = newWeapon;
					}else {
						if(weapons[0].getAttackBonus()>weapons[1].getAttackBonus()) {
							this.unequipWeapon(weapons[1],1);
						}else {
							this.unequipWeapon(weapons[0],0);
							weapons[0] = weapons[1];
							weapons[1] = null;
						}
					}
					
				}else {
					weapons[equippedWeapons]=newWeapon;
					
				}
			equippedWeapons++;
			} else {
				unequipWeapon();
				weapons[0]=newWeapon;
				equippedWeapons+=2;
			}
			this.giveAttackBonus(newWeapon.getAttackBonus());
		}

		private void unequipWeapon(Weapon weapon,int arrayPosition){;
			this.bag.putIntoTheBag(weapon);
			if(weapon.getIsShort()){
				weapons[arrayPosition]=null;
				equippedWeapons--;
			}
			this.giveAttackBonus(-1*weapon.getAttackBonus());
		}
		
		private void unequipWeapon() {
			for(Weapon w:weapons) {
				if (w!=null) {
					this.giveAttackBonus(-1*w.getAttackBonus());
				}
				w = null;
			}
			equippedWeapons=0;
		}
		

		public void changeWeapon(Weapon newWeapon) {
			equipWeapon(newWeapon);
		}
		
	
	//-------------------- NPCs actions
	protected abstract void dummyWalk(Character character, RedDice redDice);
	protected abstract void dummyAction(Character character, CombatDice combatDice);
	
	
}
