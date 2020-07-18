package br.unicamp.Map.MapElements.StaticElements;

import br.unicamp.Map.MapElements.Characters.Character;

public class FloorElement extends StaticElement {

	public FloorElement(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public FloorElement(int x, int y, boolean seen) {
		super(x, y);
		if(seen) {
			this.beSeen();
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		if(this.isVisible()) {
			return " ";
		} else {
			return "-";
		}
	}

	@Override
	public boolean isFree() {
		return true;
	}




}
