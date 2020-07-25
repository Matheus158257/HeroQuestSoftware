package br.unicamp.Map.MapElements.StaticElements.VariableElements;

import br.unicamp.Interfaces.Collectable;
import br.unicamp.Map.Map;
import br.unicamp.Map.MapElements.MapElement;
import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;
import br.unicamp.Map.MapElements.StaticElements.FloorElement;

public class Treasure extends Chest {

	
	private Collectable reward;

	public Treasure(int x, int y,  Collectable reward) {
		super(x, y);
		this.reward = reward;
	}
	
	@Override
	public String toString() {
		if(this.isVisible()) {
			return "C";
		} else {
			return "-";
		}

	}
	
	
	public void updateChestOnMap(Map map) {
		int chestX = this.getX();
		int chestY = this.getY();
		map.clearTile(chestX, chestY, true);
	}
	
	
	@Override
	public boolean getOpened(Character character) {
		Hero hero = (Hero)character;
		hero.collect(this.reward);
		System.out.println("Found a Treasure! A " + this.reward + " was put into the Bag.");
		return true;
	}

}
