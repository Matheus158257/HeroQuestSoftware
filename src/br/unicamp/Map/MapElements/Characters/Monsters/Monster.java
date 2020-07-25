package br.unicamp.Map.MapElements.Characters.Monsters;


import br.unicamp.Dices.CombatDice;
import br.unicamp.Dices.RedDice;
import br.unicamp.Map.MapElements.MapElement;
import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Items.Bag;
import br.unicamp.Items.Weapons.Weapon;

public abstract class Monster extends Character {
	
	protected Bag bag;

 
	public Monster(int x0, int y0,String name,int attackPoints,int defensePoints, int lifePoints, int mana){
		super(x0,y0,name,attackPoints,defensePoints,lifePoints,mana);
	}

	@Override
	public boolean isFree() {
		return false;
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

}
