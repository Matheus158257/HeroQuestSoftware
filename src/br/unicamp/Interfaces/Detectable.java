package br.unicamp.Interfaces;

import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;

public interface Detectable {

	// Returns a boolean answering if interactions has effect
	
	public boolean getDetected(Character character);
	
	public boolean trapsHero(Character character);
	
}
