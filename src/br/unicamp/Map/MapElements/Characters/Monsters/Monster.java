package br.unicamp.Map.MapElements.Characters.Monsters;

import br.unicamp.Map.MapElements.Characters.Character;

public class Monster extends Character {
	
	public Monster(int x0, int y0,String name,int attackPoints,int defensePoints, int lifePoints, int mana){
		super(x0,y0,name,attackPoints,defensePoints,lifePoints,mana);
	}

	@Override
	public boolean isFree() {
		return false;
	}

	@Override
	public boolean interact(Character character) {
		// TODO Attack? Or should attack be implemented differently? Maybe implement close attack?
		return false;
	}

}
