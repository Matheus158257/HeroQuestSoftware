package br.unicamp.Interfaces;

import br.unicamp.Map.MapElements.Characters.Character;

public interface Openable {

	// Returns a boolean answering if interactions has effect
	public boolean interact(Character character, String interactable);

	public  boolean getOpened(Character character);
	
}
