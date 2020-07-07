package br.unicamp.Map.MapElements.Characters;

import br.unicamp.Map.*;
import br.unicamp.Map.MapElements.Armor.Armor;
import br.unicamp.Map.MapElements.Weapons.Weapon;

public class Hero extends Character {
	
	public Hero(String name,int attackPoints,int defensePoints, int lifePoints, int mana){
		super(name,attackPoints,defensePoints,lifePoints,mana);
		weapons = new Weapon[2];		
	}
	protected void equipArmor(Armor newArmor){}
	
	protected void equipWeapon(Weapon newWeapon){//rever esta funcao para poder ser chamada sempre, não so na instanciação do heroi
		//quantas armas cada personagem pode ter? Até duas, uma em cada mão, se  não for a espada longa
		weapons[0]= newWeapon;
	}
	
	protected void unequipArmor(Armor removArmor){}
	protected void unequipWeapon(Weapon removWeapon){}
	protected void searchForTraps(Map map){}
	protected void jumpTrap(Map map, Trap trap){}
	
	protected void play(Dice gameDice){
		//implementar chamando o metodo gameDice.roll()
	}
	
}
