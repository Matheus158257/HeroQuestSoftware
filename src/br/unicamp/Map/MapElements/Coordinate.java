package br.unicamp.Map.MapElements;

public class Coordinate {

	private int x;
	private int y;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void changeCoordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean isSameCoordinates(int x, int y) {
		if (this.x != x) {
			return false;
		} else if (this.y != y) {
			return false;
		} else {
			return true;
		}
	}
	
	@ Override
	public boolean equals(Object obj) {
		Coordinate coord = (Coordinate) obj;
		
		if (coord.getX() == this.x && coord.getY() == this.y) {
			return true;
		} else {
			return false;
		}
	}
	
}
