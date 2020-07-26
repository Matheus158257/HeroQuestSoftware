package br.unicamp.Interfaces;

import br.unicamp.Map.MapElements.Coordinate;
import br.unicamp.Map.MapElements.Characters.Character;

public interface Repositions {

	// Returns a boolean answering if interactions has effect
	public  boolean goThrough(Character character);
	
	public  Coordinate reposition(Character character);
}
