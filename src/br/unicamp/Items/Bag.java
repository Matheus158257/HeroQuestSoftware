package br.unicamp.Items;

import java.util.ArrayList;

import br.unicamp.Exceptions.ItemNotInBagException;
import br.unicamp.Interfaces.Collectable;

public class Bag {

	private ArrayList<Collectable> bagElements;

	public Bag() {
		this.bagElements = new ArrayList<Collectable>();
	}

	public boolean isEmpty() {
		boolean empty = true;
		for(Collectable item : bagElements) {
			if(item!=null) {
				empty=false;
			}
		}
		return empty;
	}

	public void putIntoTheBag(Collectable item) {
		this.bagElements.add(item);
	}

	public void reportItemsOnBag() {
		int i = 0;
		for (Collectable collectable: this.bagElements) {
			collectable.report(i);
			i+=1;
		}

	}

	public void removeItem(Collectable item) throws ItemNotInBagException {
		if(bagElements.contains(item)) {
			bagElements.remove(item);
		}else {
			throw new ItemNotInBagException();
		}


	}
	public int getSize() {
		return bagElements.size();

	}


	public Collectable getItem(int position) {
		return bagElements.get(position);

	}


	public Collectable takeItem() {
		Collectable caughtItem = bagElements.remove(bagElements.size()-1);
		return caughtItem;
	}


}
