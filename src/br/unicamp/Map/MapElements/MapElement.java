package br.unicamp.Map.MapElements;

public abstract class MapElement {

//	private int x;
//	private int y;
//	private char symbol;

	
	private Coordinate coord;
	
	public MapElement(int x, int y) {
		this.coord = new Coordinate(x,y);
	}
	
	public abstract boolean isFree();
	
	public void changeCoordinates(int x, int y) {
		this.coord.changeCoordinates(x, y);
	}
	
	public void incrementCoordinates(int x, int y) {
		int newX = this.getX()+x;
		int newY = this.getY()+y;
		this.coord.changeCoordinates(newX, newY);
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
