package br.unicamp.Map.MapElements.StaticElements;

import br.unicamp.Map.MapElements.MapElement;
import br.unicamp.Map.MapElements.Characters.Character;

public abstract class StaticElement extends MapElement {

	public StaticElement(int x, int y) {
		super(x, y);
		

	}

	//--------------------
	
	@Override
	public boolean getOpened(Character character) {
		return false;
	}
	@Override
	public boolean goThrough(Character character) {
		return false;
	}
	
	
}
