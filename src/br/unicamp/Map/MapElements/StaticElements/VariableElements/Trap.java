package br.unicamp.Map.MapElements.StaticElements.VariableElements;

import br.unicamp.Map.MapElements.Characters.Character;

public class Trap extends VariableElement {

	public Trap(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "T";
	}
	
	@Override
	public boolean isFree() {
		return true;
	}

	@Override
	public boolean interact(Character character) {
		// Do nothing? Maybe disarm?
		return false;
	}
	
}
