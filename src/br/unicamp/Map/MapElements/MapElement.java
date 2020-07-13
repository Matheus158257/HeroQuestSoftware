package br.unicamp.Map.MapElements;

import br.unicamp.Interfaces.Interactable;

public abstract class MapElement implements Interactable{

	private boolean visible;
	private Coordinate coord;
	
	public MapElement(int x, int y) {
		this.coord = new Coordinate(x,y);
		this.visible = false;
	}
	
	public abstract boolean isFree();
	
	public void changeCoordinates(int x, int y) {
		this.coord.changeCoordinates(x, y);
	}
	
	public boolean isVisible() {
		return this.visible;
	};
	
	public void changeVisibility() {
		if(visible) {
			this.visible = false;
		} else {
			this.visible = true;
		}
	}
	
	public void beSeen() {
		this.visible = true;
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
