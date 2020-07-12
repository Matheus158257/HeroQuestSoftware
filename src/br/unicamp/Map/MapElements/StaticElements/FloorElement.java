package br.unicamp.Map.MapElements.StaticElements;

public class FloorElement extends StaticElement {

	private int ID;

	public FloorElement(int x, int y, int ID) {
		super(x, y);
		// TODO Auto-generated constructor stub
		isVisible = false;
		this.ID = ID;
		
	}
	

	private boolean isVisible;

	

	@Override
	public String toString() {
		String symbol = "-";
		if (this.isVisible) {
			symbol = "+";
		}
		return symbol;
	}
	
	public int getID() {
		return this.ID;
	}

	@Override
	public boolean isFree() {
		// TODO Auto-generated method stub
		return true;
	}

}
