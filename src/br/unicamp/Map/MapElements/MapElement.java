package br.unicamp.Map.MapElements;

import br.unicamp.Interfaces.Openable;
import br.unicamp.Interfaces.Repositions;
import br.unicamp.Map.MapElements.Characters.Character;

public abstract class MapElement implements Openable,Repositions{

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
	
	public boolean allowAtack() {
		return true;
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
	
	public Coordinate getThrough2(Character character) {
		return null;
	}
	
	
}
