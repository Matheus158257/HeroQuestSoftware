package br.unicamp.Map.MapElements.Characters.Heroes;

import br.unicamp.Map.*;
import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.StaticElements.VariableElements.Trap;
import br.unicamp.Dices.CombatDice;
import br.unicamp.Dices.Dice;
import br.unicamp.Dices.RedDice;
import br.unicamp.Interfaces.Collectable;
import br.unicamp.Items.Bag;
import br.unicamp.Items.Potion;
import br.unicamp.Items.Armor.Armor;
import br.unicamp.Items.Weapons.Dagger;
import br.unicamp.Items.Weapons.LongSword;
import br.unicamp.Items.Weapons.ShortSword;
import br.unicamp.Items.Weapons.Weapon;

public class Hero extends Character {
	
	protected Armor armor;
	protected Bag bag;
	private int equippedWeapons = 0;
	
	public Hero(int x0, int y0, String name,int attackPoints,int defensePoints, int lifePoints, int mana){
		super(x0,y0,name,attackPoints,defensePoints,lifePoints,mana);
		weapons = new Weapon[2];	
		this.bag = new Bag();
		
	}
	protected void equipArmor(Armor newArmor){
		this.bag.removeItem(newArmor);
		this.armor = newArmor;
		this.defensePoints += newArmor.getArmorDefensePoints();
	}
	
	protected void equipWeapon(Weapon newWeapon){
		//TODO Resolver estouro de tamanho do vetor
		this.bag.removeItem(newWeapon);//tira a arma da sacola e p�es nas m�os do h�roi
		if(newWeapon.getIsShort()){
			weapons[equippedWeapons]=newWeapon;
			equippedWeapons++;
			//PEGA OS PONTOS DE ATAQUE DA ARMA E ATACA AQUI?
			//newWeapon.getAttackBonus();
		}else{
			weapons[equippedWeapons]=newWeapon;
			//Solu��o para que o heroi n�o tente pegar mais uma arma
			equippedWeapons+=2;
			//PEGA OS PONTOS DE ATAQUE DA ARMA E ATACA AQUI?
			//newWeapon.getAttackBonus();
		}
	}
	
	protected void unequipArmor(Armor removArmor){
		this.bag.putIntoTheBag(removArmor);
		this.defensePoints -= removArmor.getArmorDefensePoints();		
	}
	
	protected void unequipWeapon(Weapon removWeapon){
		this.bag.putIntoTheBag(removWeapon);
		if(removWeapon.getIsShort()){
			weapons[equippedWeapons]=null;
			equippedWeapons--;
		}else{
			weapons[equippedWeapons]=null;
			weapons[equippedWeapons--]=null;
			//Livra as duas m�os
			equippedWeapons=equippedWeapons-2;
		}
		
	}
	
	protected void searchForTraps(Map map){}
	protected void jumpTrap(Map map, Trap trap){}
	
	public void drinkPotion(Potion potion) {
		this.lifePoints += potion.getHealingPoints();
		this.bag.removeItem(potion);
	}
	
	protected void play(Dice gameDice){
		//implementar chamando o metodo gameDice.roll()
	}
	
	@Override
	public boolean isFree() {
		return false;
	}
	
	
	public void collect(Collectable reward) {
		this.bag.putIntoTheBag(reward);
		
	}
	
	public void reportBagElements() {
		this.bag.reportItemsOnBag();
		
	}
	
	//-------------------- NPCs actions
	@Override
	protected void dummyWalk(Character character, RedDice redDice) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void dummyAction(Character character, CombatDice combatDice) {
		// TODO Auto-generated method stub
		
	}

	//--------------------
	
	
	@Override
	public boolean getOpened(Character character) {
		return false;
	}
	@Override
	public boolean goThrough(Character character) {
		return false;
	}
	
	

}
