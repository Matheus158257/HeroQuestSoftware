package br.unicamp.Items.Armor;

import br.unicamp.Interfaces.Collectable;
import br.unicamp.Interfaces.Usable;
import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;

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


	@Override
	public void use(Hero hero) {
		// TODO Auto-generated method stub
		
	}

}
