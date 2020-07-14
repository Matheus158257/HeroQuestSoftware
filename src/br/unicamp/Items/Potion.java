package br.unicamp.Items;

import br.unicamp.Interfaces.Collectable;
import br.unicamp.Interfaces.Usable;
import br.unicamp.Map.MapElements.Characters.Character;

public class Potion implements Collectable, Usable {
	
	
	private int healingPoints;

	public Potion(int healingPoints){
		this.healingPoints = healingPoints;
	}

	
	@Override
	public void report() {
		String message = "Potion: " + String.valueOf(healingPoints) + " healingPoints points";
		System.out.println(message);
	}
}
