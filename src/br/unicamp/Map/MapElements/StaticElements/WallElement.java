package br.unicamp.Map.MapElements.StaticElements;

public class WallElement extends StaticElement {

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
