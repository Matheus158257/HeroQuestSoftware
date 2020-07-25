package br.unicamp.Map.MapElements.Characters.Monsters;

import br.unicamp.Map.MapElements.Characters.Character;

public class Skeleton extends Monster {

	public static final int ATK = 2;
	public static final int DEF = 1;
	public static final int LP = 3;
	public static final int MP = 0;
	
	public Skeleton(int x0, int y0) {
		super(x0,y0,"Skeleton", Skeleton.ATK, Skeleton.DEF, Skeleton.LP, Skeleton.MP);
		// TODO Auto-generated constructor stub
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
