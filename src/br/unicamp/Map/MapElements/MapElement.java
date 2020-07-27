package br.unicamp.Map.MapElements;

import br.unicamp.Interfaces.Detectable;
import br.unicamp.Interfaces.Openable;
import br.unicamp.Interfaces.Repositions;
import br.unicamp.Map.MapElements.Characters.Character;
import br.unicamp.Map.MapElements.Characters.Heroes.Hero;

public abstract class MapElement implements Openable,Repositions, Detectable{

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
	
	public boolean allowAtack() {
		return true;
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
	
	@Override
	public boolean trapsHero(Character character) {
		return false;
	};

	@Override
	public boolean getDetected(Character character){
		return false;
	}

	
	
}
