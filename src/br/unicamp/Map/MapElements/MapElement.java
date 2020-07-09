package br.unicamp.Map.MapElements;

public abstract class MapElement {

//	private int x;
//	private int y;
//	private char symbol;

	
	private Coordinate coord;
	
	public MapElement(int x, int y) {
		this.coord = new Coordinate(x,y);
	}
	
	public int getX() {
		return this.coord.getX();
	}
	
	public int getY() {
		return this.coord.getY();
	}
	
	
	
	
	
//	public char getSymbol() {
//		return this.symbol;
//	}
	
	
}
