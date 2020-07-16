package br.unicamp.Items;

import br.unicamp.Interfaces.Collectable;
import br.unicamp.Interfaces.Usable;
import br.unicamp.Map.MapElements.Characters.Character;

public class Coin implements Collectable, Usable{
	
	private int moneyPoints;

	public Coin(int moneyPoints){
		this.moneyPoints = moneyPoints;		
	}

	@Override
	public void report() {
		String message = "Coin: " + String.valueOf(moneyPoints) + " money points";
		System.out.println(message);
	}



}
