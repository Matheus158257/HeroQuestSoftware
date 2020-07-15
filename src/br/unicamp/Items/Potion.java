package br.unicamp.Items;

import br.unicamp.Interfaces.Collectable;
import br.unicamp.Interfaces.Usable;
import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;

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
	
	@Override
	public void use(Hero hero) {
		hero.drinkPotion(this);
	}
	
	public int getHealingPoints() {
		return this.healingPoints;
	}
}
