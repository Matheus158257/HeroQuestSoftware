package br.unicamp.Map.MapElements;

public abstract class MapElement {

	private int x;
	private int y;
	private char symbol;
	
	public MapElement(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public char getSymbol() {
		return this.symbol;
	}
	
	
}
