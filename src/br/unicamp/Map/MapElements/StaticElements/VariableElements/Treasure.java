package br.unicamp.Map.MapElements.StaticElements.VariableElements;

import br.unicamp.Interfaces.Collectable;
import br.unicamp.Map.MapElements.MapElement;
import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;
import br.unicamp.Map.MapElements.Characters.Monsters.Monster;
import br.unicamp.Map.MapElements.StaticElements.FloorElement;

public class Treasure extends Chest {

	
	private Collectable reward;
	private Boolean collected;

	public Treasure(int x, int y,  Collectable reward) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.reward = reward;
		this.collected = false;
	}
	
	@Override
	public String toString() {
		String symbol = "C";
		if (this.collected) {
			symbol = " ";
		}
		return symbol;
	}
	
	public void updateChestOnMap(MapElement[][] map) {
		int chestX = this.getX();
		int chestY = this.getY();
		map[chestX][chestY] = new FloorElement(chestX,chestY, true);
		
	}
	

	
	private void open(Character character) {
		Hero hero = (Hero)character;
		hero.collect(this.reward);
	}

}
