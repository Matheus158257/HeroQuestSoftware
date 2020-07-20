package br.unicamp.Map.MapElements.Characters.Monsters;


import br.unicamp.Dices.CombatDice;
import br.unicamp.Dices.RedDice;
import br.unicamp.Map.MapElements.Characters.Character;

public class Monster extends Character {

 
	public Monster(int x0, int y0,String name,int attackPoints,int defensePoints, int lifePoints, int mana){
		super(x0,y0,name,attackPoints,defensePoints,lifePoints,mana);
	}

	@Override
	public boolean isFree() {
		return false;
	}

	
	//-------------------- NPCs actions
	
	@Override
	public void dummyWalk(Character character, RedDice redDice) {
		if (this.isVisible()) {
			
		}

	}

	@Override
	public void dummyAction(Character character, CombatDice combatDice) {
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

	@Override
	public boolean interact(Character character, String interactable) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
