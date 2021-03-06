package br.unicamp.Map.MapElements.Characters.Monsters;

import br.unicamp.Game.MoveCommand;
import br.unicamp.Items.Bag;
import br.unicamp.Items.Weapons.LongSword;
import br.unicamp.Items.Weapons.Weapon;
import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;

public class Skeleton extends Monster {

	public static final int ATK = 2;
	public static final int DEF = 1;
	public static final int LP = 3;
	public static final int MP = 0;
	
	public Skeleton(int x0, int y0) {
		super(x0,y0,"Skeleton", Skeleton.ATK, Skeleton.DEF, Skeleton.LP, Skeleton.MP,false);
		// TODO Randomize Weapon
		Weapon longSword = new LongSword();
		this.bag.putIntoTheBag(longSword);
		this.equipWeapon(longSword);
	}

	@Override
	public String toString() {
		if(this.isVisible()) {
			return "S";
		} else {
			return "-";
		}
	}
	
	@Override
	public String toString(boolean complete) {
		if(complete) {
			return("Skeleton (ATK:" + this.attackPoints + "|DEF:" + this.defensePoints + "|LP:" + this.lifePoints + "|MP:" + this.mana + ")");
		} else {
			return this.toString();
		}
	}

	
}
