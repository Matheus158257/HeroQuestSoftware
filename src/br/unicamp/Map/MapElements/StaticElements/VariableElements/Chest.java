package br.unicamp.Map.MapElements.StaticElements.VariableElements;

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
		if(this.isVisible()) {
			return "C";
		} else {
			return "-";
		}
	}


	public abstract void updateChestOnMap(Map map);

	
}
