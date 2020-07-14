package br.unicamp.Items.Armor;

import br.unicamp.Interfaces.Collectable;
import br.unicamp.Interfaces.Usable;
import br.unicamp.Map.MapElements.Characters.Character;

public class Armor implements Collectable,Usable{
	
	
	private int defensePoins;

	public Armor(int defensePoins) {
		this.defensePoins = defensePoins;
	}

	
	@Override
	public void report() {
		String message = "Armor: " + String.valueOf(defensePoins) + " defensePoins points";
		System.out.println(message);
	}

}
