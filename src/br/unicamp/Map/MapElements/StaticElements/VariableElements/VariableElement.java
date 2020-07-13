package br.unicamp.Map.MapElements.StaticElements.VariableElements;

import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.StaticElements.StaticElement;
import br.unicamp.Interfaces.Interactable;

public abstract class VariableElement extends StaticElement implements Interactable {

	public VariableElement(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isFree() {
		return false;
	}


}
