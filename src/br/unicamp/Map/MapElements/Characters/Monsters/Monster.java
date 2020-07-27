package br.unicamp.Map.MapElements.Characters.Monsters;


import java.util.HashMap;
import java.util.Random;


import br.unicamp.Game.MoveCommand;
import br.unicamp.Map.MapElements.Coordinate;
import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;


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

	
	@Override
	public boolean getOpened(Character character) {
		return false;
	}
	@Override
	public boolean goThrough(Character character) {
		return false;
	}
	
	@Override
	public Coordinate reposition(Character character) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateWeapon() {
		if (this.occupiedHands<Character.HANDS) {
			if(!this.bag.isEmpty()) {
				this.equipFirstWeapon();
			}
		}
	}

}
