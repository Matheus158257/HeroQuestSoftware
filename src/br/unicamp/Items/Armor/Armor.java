package br.unicamp.Items.Armor;

import br.unicamp.Interfaces.Collectable;
import br.unicamp.Interfaces.Usable;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;

public class Armor implements Collectable,Usable{
	
	
	private int defensePoints;


	public Armor(int defensePoints) {
		this.defensePoints = defensePoints;
	}
	
	@Override
	public void report(int i) {
		String message = String.valueOf(i) + " - "+ "Armor: " + String.valueOf(defensePoints) + " defensePoins points";
		System.out.println(message);
	}
	
	@Override
	public void report() {
		String message = "Armor: " + String.valueOf(defensePoints) + " defensePoins points";
		System.out.println(message);
	}

	public int getDefensePoints(){
		return defensePoints;
	}
	
	@Override
	public void use(Hero hero) {
		hero.changeArmor(this);
	}

}
