package br.unicamp.Map.MapElements.Characters.Monsters;

import br.unicamp.Game.MoveCommand;
import br.unicamp.Items.Weapons.Dagger;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;


public class Goblin extends Monster {

	public static final int ATK = 1; // Attack Points
	public static final int DEF = 2; // Defense Points
	public static final int LP = 4; // Life Points
	public static final int MP = 0; // Mana Points
	public static final int noDaggers = 4; //Dagger numbers

	public Goblin(int x0, int y0){
		super(x0,y0,"Goblin", Goblin.ATK, Goblin.DEF, Goblin.LP, Goblin.MP,false);

		Dagger dagger1 = new Dagger();
		Dagger dagger2 = new Dagger();
		Dagger dagger3 = new Dagger();
		Dagger dagger4 = new Dagger();
		this.bag.putIntoTheBag(dagger1);
		this.bag.putIntoTheBag(dagger2);
		this.bag.putIntoTheBag(dagger3);
		this.bag.putIntoTheBag(dagger4);
		this.equipWeapon(dagger1);
		this.equipWeapon(dagger2);

	}

	@Override
	public String toString() {
		if(this.isVisible()) {
			return "G";
		} else {
			return "-";
		}
	}

	@Override
	public String toString(boolean complete) {
		if(complete) {
			return("Goblin (ATK:" + this.attackPoints + "|DEF:" + this.defensePoints + "|LP:" + this.lifePoints + "|MP:" + this.mana + ")");
		} else {
			return this.toString();
		}
	}

	@Override
	public MoveCommand nextStep(Hero player) {
		int xP = player.getX();
		int yP = player.getY();
		int xG = this.getX();
		int yG = this.getY();
		int xDif, yDif;
		
		if(xP > xG){
			xDif=xP-xG;
		} else {
			xDif=xG-xP;
		}
		
		if(yP > yG){
			yDif=yP-yG;
		} else {
			yDif=yG-yP;
		}
		
		if(xDif>yDif) {
			if(xP > xG){
				return MoveCommand.RIGHT;
			} else {
				return MoveCommand.LEFT;
			}
		} else {
			if(yP > yG){
				return MoveCommand.DOWN;
			} else {
				return MoveCommand.UP;
			}
		}
				
	}
}
