package br.unicamp.Interfaces;

import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;

public interface Collectable{

	public void report(int i);
	public void report();
	public void use(Hero hero);
	
}
