package br.unicamp.Map.MapElements.StaticElements;

import br.unicamp.Map.MapElements.Characters.Character;


public class WallElement extends StaticElement {


	private Boolean acceptDoor;
	public WallElement(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "X";
	}

	@Override
	public boolean isFree() {
		return false;
	}
	

}
