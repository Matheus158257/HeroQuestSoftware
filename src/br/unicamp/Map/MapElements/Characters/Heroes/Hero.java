package br.unicamp.Map.MapElements.Characters.Heroes;

import br.unicamp.Map.*;
import br.unicamp.Map.MapElements.MapElement;
import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.StaticElements.VariableElements.Trap;

import br.unicamp.Dices.CombatDice;
import br.unicamp.Dices.Dice;
import br.unicamp.Dices.RedDice;
import br.unicamp.Exceptions.ItemNotInBagException;
import br.unicamp.Exceptions.LifeOnMaximumException;
import br.unicamp.Interfaces.Collectable;
import br.unicamp.Items.Bag;
import br.unicamp.Items.Potion;
import br.unicamp.Items.Armor.Armor;
import br.unicamp.Items.Weapons.Dagger;
import br.unicamp.Items.Weapons.LongSword;
import br.unicamp.Items.Weapons.ShortSword;
import br.unicamp.Items.Weapons.Weapon;

public abstract class Hero extends Character {
	
	protected Armor armor;
	

	public Hero(int x0, int y0, String name,int attackPoints,int defensePoints, int lifePoints, int mana, Boolean isSpeller){
		super(x0,y0,name,attackPoints,defensePoints,lifePoints,mana,isSpeller);

		
	}
	
	private void equipArmor(Armor newArmor){
		try {
			this.bag.removeItem(newArmor);
		}catch(ItemNotInBagException e) {
			//N�o faz nada. Para o caso em que � a armadura inicial
		}
		this.armor = newArmor;
    
		this.giveDefenseBonus(newArmor.getDefensePoints());
	}
	
	
	
	private void unequipArmor(){
		this.bag.putIntoTheBag(this.armor);
		this.giveDefenseBonus(-1*this.armor.getDefensePoints());
	}

	public void changeArmor(Armor armor) {
		if (this.armor != null) {
			this.bag.putIntoTheBag(this.armor);
			unequipArmor();
			equipArmor(armor);
		}else {
			equipArmor(armor);
		}
	}
	
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
		
		//Report equipped Items
//		this.reportEquippedItems();
		
		//Report 
	}
	
//	private void reportEquippedItems() {
//		String report = ("Player has equipped:\n- Armor: ");
//		if(this.armor != null) {
//			report += this.armor;
//		}
//		report+=("\n- Weapons:");
//		for(Weapon w:this.weapons) {
//			if(w != null) {
//				report += (" " + w);
//			}
//		}
//		System.out.println(report);
//	}
	


	//--------------------
	public void status() {
		
		System.out.println("OVERALL STATUS: ");
		String lifePoints = "Life Points: " + String.valueOf(this.lifePoints);
		lifePoints += " - MAX Life Points: " + String.valueOf(this.maxLifePoints);
		System.out.println(lifePoints);
		String manaPoints = "Mana Points: " + String.valueOf(this.mana);
		System.out.println(manaPoints);
		String atackPoints = "Attack Points: " + String.valueOf(this.attackPoints);
		System.out.println(atackPoints);
		String defensePoints = "Defense Points: " + String.valueOf(this.defensePoints);
		System.out.println(defensePoints);
		System.out.println("-------------------------------------------------------------------");
		
		System.out.println("EQUIPMENT STATUS: ");
		if (this.weapons[0] != null) {
			this.weapons[0].report();

		}
		if (this.weapons[1] != null) {
			this.weapons[1].report();
		}
		if (this.armor != null) {
			this.armor.report();
		}
		
//		System.out.print("\n");
		

	}
	
	@Override
	public boolean getOpened(Character character) {
		return false;
	}
	@Override
	public boolean goThrough(Character character) {
		return false;
	}




	//--------------------
	



	public void useBagItem(int position) throws ItemNotInBagException{
		if (position < this.bag.getSize()) {
			Collectable item = this.bag.getItem(position);
			item.use(this);
			
		}else {
			throw new ItemNotInBagException();
		}
		
	}



	public void drinkPotion(Potion potion) throws LifeOnMaximumException {
		if (this.lifePoints == this.maxLifePoints) {
			throw new LifeOnMaximumException("When your life is on maximum you can't use a Potion.");
		} else {
			this.lifePoints+=potion.getHealingPoints();
			try {
				this.bag.removeItem(potion);
			} catch (ItemNotInBagException e) {
				System.out.println(e.getMessage());
			}
		}
	}



}
