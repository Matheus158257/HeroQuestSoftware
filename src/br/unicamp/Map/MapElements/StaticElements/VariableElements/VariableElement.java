package br.unicamp.Map.MapElements.StaticElements.VariableElements;

import br.unicamp.Map.MapElements.Coordinate;
import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.StaticElements.StaticElement;

public abstract class VariableElement extends StaticElement{

	public VariableElement(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isFree() {
		return false;
	}

	@Override
	public Coordinate reposition(Character character) {
		// TODO Auto-generated method stub
		return null;
	}

}
