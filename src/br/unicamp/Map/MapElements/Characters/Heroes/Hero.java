package br.unicamp.Map.MapElements.Characters.Heroes;

import br.unicamp.Map.*;
import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.StaticElements.VariableElements.Trap;
import br.unicamp.Dices.Dice;
import br.unicamp.Interfaces.Collectable;
import br.unicamp.Items.Bag;
import br.unicamp.Items.Armor.*;
import br.unicamp.Items.Weapons.*;

public class Hero extends Character {
	
	protected Bag bag;
	
	public Hero(int x0, int y0, String name,int attackPoints,int defensePoints, int lifePoints, int mana){
		super(x0,y0,name,attackPoints,defensePoints,lifePoints,mana);
		weapons = new Weapon[2];	
		this.bag = new Bag();
		
	}
	protected void equipArmor(Armor newArmor){}
	
	protected void equipWeapon(Weapon newWeapon){
		//rever esta funcao para poder ser chamada sempre, n�o so na instancia��o do heroi
		//quantas armas cada personagem pode ter? At� duas, uma em cada m�o, se  n�o for a espada longa

		//		weapons[0]= newWeapon;
	}
	
	protected void unequipArmor(Armor removArmor){}
	protected void unequipWeapon(Weapon removWeapon){}
	protected void searchForTraps(Map map){}
	protected void jumpTrap(Map map, Trap trap){}
	
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
}
