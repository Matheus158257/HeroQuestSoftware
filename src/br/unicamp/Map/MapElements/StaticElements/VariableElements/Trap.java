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
	
	// Tem que poder desarmar
	@Override
	public boolean interact(Character character, String iteration) {
		Boolean result = false;
		return result;
	}

}
