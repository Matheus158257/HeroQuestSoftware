package br.unicamp.Items;

import br.unicamp.Interfaces.Collectable;
import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;

public class Coin implements Collectable{
	
	private int moneyPoints;

	public Coin(int moneyPoints){
		this.moneyPoints = moneyPoints;		
	}
	
	@Override
	public String toString() {
		return "Coin";
	}

	@Override
	public void report(int i) {
		String message =  String.valueOf(i) + " - "+"Coin: " + String.valueOf(moneyPoints) + " money points";
		System.out.println(message);
	}
	
	@Override
	public void report() {}

	@Override
	public void use(Hero hero) {
		// TODO Auto-generated method stub
		System.out.println("Coins are only a prize to make you happy,\nthey don't have any function in this game.");
	}


}
