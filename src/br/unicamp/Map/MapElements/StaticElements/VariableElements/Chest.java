package br.unicamp.Map.MapElements.StaticElements.VariableElements;

import br.unicamp.Exceptions.OccupiedTileException;
import br.unicamp.Exceptions.OutOfBoundsException;
import br.unicamp.Map.Map;
import br.unicamp.Map.MapElements.MapElement;
import br.unicamp.Map.MapElements.Characters.Character;

public abstract class Chest extends VariableElement{

	public Chest(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "C";
	}

	@Override
	public boolean interact(Character character, String iteration) {
		Boolean result = false;
		if (iteration == "OC") {
			result = true;
		}
		return result;
	}

	public abstract void updateChestOnMap(MapElement[][] map);


}
