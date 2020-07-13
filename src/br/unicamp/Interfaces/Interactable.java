package br.unicamp.Interfaces;

import br.unicamp.Exceptions.OccupiedTileException;
import br.unicamp.Exceptions.OutOfBoundsException;
import br.unicamp.Map.Map;
import br.unicamp.Map.MapElements.Characters.Character;

public interface Interactable {

	

	// Returns a boolean answering if interactions has effect
	public abstract boolean interact(Character character);
	
}
