package br.unicamp.Map.MapElements.Characters;

import br.unicamp.Items.Bag;

import br.unicamp.Items.Spells.Spell;
import br.unicamp.Items.Weapons.*;
import br.unicamp.Map.Map;
import br.unicamp.Map.MapElements.MapElement;
import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;
import br.unicamp.Map.MapElements.Characters.Monsters.Monster;

import java.util.ArrayList;
import java.util.Scanner;

import br.unicamp.Dices.*;
import br.unicamp.Exceptions.ItemNotInBagException;
import br.unicamp.Exceptions.LifeOnMaximumException;
import br.unicamp.Exceptions.NotSpellerException;
import br.unicamp.Game.MoveCommand;

public abstract class Character extends MapElement{


	public final static int HANDS = 2;

	protected String name;
	protected int attackPoints;
	protected int defensePoints;
	protected int lifePoints;
	protected int maxLifePoints;
	protected int mana;
	protected Bag bag;

	protected Weapon weapons[];
	protected int occupiedHands = 0;
	protected ArrayList<Spell> spells = new ArrayList<Spell>();

	protected boolean isSpeller;

	public Character(int x0, int y0, String name,int attackPoints,int defensePoints, int lifePoints, int mana,Boolean isSpeller){
		super(x0,y0);
		this.name = name;
		this.attackPoints = attackPoints;
		this.defensePoints = defensePoints;
		this.lifePoints = lifePoints;
		this.maxLifePoints = lifePoints;
		this.mana = mana;
		this.bag = new Bag();
		this.weapons = new Weapon[2];	
		this.isSpeller = isSpeller;
	}

	protected void giveAttackBonus(int bonus) {
		this.attackPoints+=bonus;
	}

	protected void giveDefenseBonus(int bonus) {
		this.defensePoints+=bonus;
	}
	
	public void beHealed(int heallingPoints) throws LifeOnMaximumException {
		if (this.lifePoints == this.maxLifePoints) {
			throw new LifeOnMaximumException("When your life is on maximum you can't be healed.");
		} else {
			this.lifePoints+=heallingPoints;
		}
	}
	


	public void changePosition(MoveCommand direction) {

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


	public Boolean isSpeller(){
		return this.isSpeller;
	}

	public int getWeaponRange() {
		int range=0;
		for(Weapon w:this.weapons) {
			if(w!=null && range<w.getRange()) {
				range =w.getRange();
			}
		}

		return range;
	}

	public int getAttackPoints() {
		return this.attackPoints;
	}

	public int getDefensePoints() {
		return this.defensePoints;
	}

	public boolean takeDamage(int damage) {
		this.lifePoints-=damage;

		if(this.lifePoints<=0) {
			this.lifePoints=0;
			return true; // has died
		} else {
			return false; // is still alive
		}
	}

	
	public void defenseAgainstMagic(CombatDice combatDice, int damage, String speller,Map map){
		int defenceResult = 0;
		String message="";
		if (speller =="Hero") {
			defenceResult+=combatDice.rollMonsterDefenseDice(this.mana);
			message+="The monster got " + String.valueOf(defenceResult) + " monster shields";
		}
		if (speller =="Monster") {
			defenceResult+=combatDice.rollHeroDefenseDice(this.mana);
			message+="The hero got " + String.valueOf(defenceResult) + " hero shields";
		}
		
		System.out.println(this.toString(true));
		System.out.println(message);
		
		if(damage>=defenceResult) {//necessario para nao dar vida ao Character na defeas
			receiveDamage(damage,defenceResult);
		}//se for menor n�o acontece nada
		
		
		if(this.lifePoints<=0) {
			if (speller =="Hero") {
				Monster monster = (Monster) this;
				map.killMonster(monster);
			}
		}
	}

	protected void receiveDamage(int damage, int defense){
		lifePoints = lifePoints-damage+defense;
	}

	protected void equipFirstWeapon() {
		equipWeapon((Weapon)this.bag.getItem(0));
	}

	public void attack() {
		if (this.occupiedHands==1) {
			if(this.weapons[0].getDestroys()) {
				System.out.println("LOG: Destroying weapon " + this.weapons[0]);
				this.weapons[0] = null;
				this.occupiedHands--;		
			}

		} else if(this.occupiedHands==2) {

			if(this.weapons[0].getIsShort()) {

				if(this.weapons[0].getDestroys()) {
					System.out.println("LOG: Destroying weapon " + this.weapons[0]);
					this.weapons[0] = null;
					this.occupiedHands--;
				}
				if(this.weapons[1].getDestroys()) {
					System.out.println("LOG: Destroying weapon " + this.weapons[1]);
					this.weapons[1] = null;
					this.occupiedHands--;
				}
			} else {
				if(this.weapons[0].getDestroys()) {
					System.out.println("LOG: Destroying weapon " + this.weapons[0]);
					this.weapons[0] = null;
					this.occupiedHands--;
				}
			}
		}
	}

	//@Override
	protected void equipWeapon(Weapon newWeapon){

		try {
			this.bag.removeItem(newWeapon);
		}catch(ItemNotInBagException e) {
			System.out.println(e.getMessage());
		}

		if(newWeapon.getIsShort()){
			if(this.occupiedHands ==2) {
				if(this.weapons[1]==null) {//long sword na 0
					this.unequipWeapon();
					this.weapons[0] = newWeapon;
				}else {
					if(this.weapons[0].getAttackBonus()>weapons[1].getAttackBonus()) {
						this.unequipWeapon(weapons[1],1);
					}else {
						this.unequipWeapon(weapons[0],0);
						this.weapons[0] = weapons[1];
						this.weapons[1] = null;
					}
				}

			}else {
				this.weapons[occupiedHands]=newWeapon;

			}
			occupiedHands++;
		} else {
			unequipWeapon();
			this.weapons[0]=newWeapon;
			occupiedHands+=2;
		}
		this.giveAttackBonus(newWeapon.getAttackBonus());
	}

	private void unequipWeapon(Weapon weapon,int arrayPosition){;
	this.bag.putIntoTheBag(weapon);
	if(weapon.getIsShort()){
		this.weapons[arrayPosition]=null;
		this.occupiedHands--;
	}
	this.giveAttackBonus(-1*weapon.getAttackBonus());
	}

	private void unequipWeapon() {
		for(Weapon w:this.weapons) {
			if (w!=null) {
				this.giveAttackBonus(-1*w.getAttackBonus());
				this.bag.putIntoTheBag(w);
			}
		}
		this.weapons[0] = null;
		this.weapons[1] = null;
		this.occupiedHands=0;
	}


	public void changeWeapon(Weapon newWeapon) {
		equipWeapon(newWeapon);
	}

	public abstract String toString(boolean complete);

	

	//-------------------- NPCs actions

	protected void showSpellOptions() {
		int i =0;
		for(Spell spell: this.spells) {
			System.out.print(String.valueOf(i) + " - ");
			System.out.println(spell);
			i+=1;
		}
	}
	
	protected int readSpellsNumber()  {

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.print ("Type a number from spells") ;
		String command = keyboard.nextLine();
		int position;
		try {
			position = Integer.valueOf(command);
		}catch(NumberFormatException e) {
			System.out.println("Please write a number");
			position = -1;
		}
		
		return position;
	}
	

	@Override
	public boolean getOpened(Character character) {
		return false;
	}
	@Override
	public boolean goThrough(Character character) {
		return false;
	}


	public void castSpell(Map map, RedDice redDice1, CombatDice combatDice) throws NotSpellerException {
		throw new NotSpellerException();
	}
	
	public Boolean castSpell(Map map,Hero hero, RedDice redDice1, CombatDice combatDice) throws NotSpellerException {
		throw new NotSpellerException();
		
	}
	
	
}
