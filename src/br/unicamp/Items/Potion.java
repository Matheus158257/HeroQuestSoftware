package br.unicamp.Items;

import br.unicamp.Exceptions.LifeOnMaximumException;
import br.unicamp.Interfaces.Collectable;

import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;

public class Potion implements Collectable {
	
	
	private int healingPoints;

	public Potion(int healingPoints){
		this.healingPoints = healingPoints;
	}

	@Override
	public String toString() {
		return "Potion";
	}
	
	@Override
	public void report(int i) {
		String message = String.valueOf(i) + " - "+ "Potion: " + String.valueOf(healingPoints) + " healingPoints points";
		System.out.println(message);
	}
	
	@Override
	public void report() {}
	
	@Override
	public void use(Hero hero){
		try {
			hero.drinkPotion(this);
		} catch (LifeOnMaximumException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getHealingPoints() {
		return this.healingPoints;
	}
}
