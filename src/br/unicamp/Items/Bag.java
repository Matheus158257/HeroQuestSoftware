package br.unicamp.Items;

import java.util.ArrayList;

import br.unicamp.Interfaces.Collectable;

public class Bag {

	private ArrayList<Collectable> bagElements;

	public Bag() {
		this.bagElements = new ArrayList<Collectable>();
	}
	
	public void putIntoTheBag(Collectable reward) {
		this.bagElements.add(reward);
	}
	
	public void reportItemsOnBag() {
		for (Collectable collectable: this.bagElements)
			collectable.report();

	}

	public void removeItem(Collectable item) {
		bagElements.remove(item);
		
	}
	
	
}
