package br.unicamp.Map.MapElements.StaticElements.VariableElements;

import br.unicamp.Interfaces.Collectable;
import br.unicamp.Map.Map;
import br.unicamp.Map.MapElements.MapElement;
import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.Characters.Monsters.Monster;
import br.unicamp.Map.MapElements.StaticElements.FloorElement;

public class ChestTrap extends Chest {

	private Monster monster;
	
	public ChestTrap(int x, int y, Monster monster) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.monster = monster;
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
		map.addMonster(this.monster);
	}

	
	
	@Override
	public boolean getOpened(Character character) {
//		System.out.println("A MONSTER APPEARED");
		System.out.println("It was a trap! Watch out, a " + this.monster.toString(true) + " appeared!");
		return true;
	}

}
