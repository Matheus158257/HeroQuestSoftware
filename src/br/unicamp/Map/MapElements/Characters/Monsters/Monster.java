package br.unicamp.Map.MapElements.Characters.Monsters;


import java.util.HashMap;
import java.util.Random;

import br.unicamp.Dices.CombatDice;
import br.unicamp.Dices.CombatDiceSymbol;
import br.unicamp.Dices.RedDice;
import br.unicamp.Game.MoveCommand;
import br.unicamp.Map.MapElements.MapElement;
import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;
import br.unicamp.Items.Bag;
import br.unicamp.Items.Weapons.Weapon;

public abstract class Monster extends Character {
	

	private int high, low;
	private HashMap<Integer, MoveCommand> hmap = new HashMap<Integer, MoveCommand>();

 
	public Monster(int x0, int y0,String name,int attackPoints,int defensePoints, int lifePoints, int mana,Boolean isSpeller){
		super(x0,y0,name,attackPoints,defensePoints,lifePoints,mana,isSpeller);

		hmap.put(1,  MoveCommand.UP);
		hmap.put(2,  MoveCommand.DOWN);
		hmap.put(3,  MoveCommand.RIGHT);
		hmap.put(4,  MoveCommand.LEFT);
		hmap.put(5,  MoveCommand.STOP);
		this.low=1;
		this.high=5;

	}

	@Override
	public boolean isFree() {
		return false;
	}

	public MoveCommand nextStep(Hero player) {
			Random r = new Random();
			int n = r.nextInt(high-low+1) + low;
			return hmap.get(n);
	}

	
	

	//-------------------- NPCs actions
	
	// DUMMY WALK AND ACTION FORAM PARA MAP
//	@Override
//	public void dummyWalk(RedDice redDice, MapElement map[][]) {
//		int steps = redDice.getResult(1);
//		if (this.isVisible()) {
//			do{
//				while(map[this.getX()][this.getY()+1].isFree() && steps>0){ 		//DOWN
//					this.incrementCoordinates(0,1);
//					steps--;
//				}
//				while(map[this.getX()][this.getY()-1].isFree() && steps>0){ 	//UP
//					this.incrementCoordinates(0,-1);
//					steps--;
//				}
//				while(map[this.getX()][this.getY()+1].isFree() && steps>0){ 	//RIGHT
//					this.incrementCoordinates(1,0);
//					steps--;
//				}
//				while(map[this.getX()][this.getY()+1].isFree() && steps>0){ 	//LEFT
//					this.incrementCoordinates(-1,0);
//					steps--;
//				}
//			}while(steps>0);
//		}
//	}

//	public void dummyAction(Character character, CombatDice combatDice, MapElement map[][]) {
//		// TODO Auto-generated method stub
//		
//	}
	
	//--------------------
	
	@Override
	public boolean getOpened(Character character) {
		return false;
	}
	@Override
	public boolean goThrough(Character character) {
		return false;
	}

	public void updateWeapon() {
		if (this.occupiedHands<Character.HANDS) {
			if(!this.bag.isEmpty()) {
				this.equipFirstWeapon();
			}
		}
	}

}
