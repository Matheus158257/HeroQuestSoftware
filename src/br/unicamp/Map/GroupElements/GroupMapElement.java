package br.unicamp.Map.GroupElements;

import br.unicamp.Map.MapElements.MapElement;

public class GroupMapElement {
	
	protected int sizeX;
	protected int sizeY;
	protected int x0;
	protected int y0;
	protected MapElement mapElements[][];
	protected int ID;
	
	public GroupMapElement ( int sizeX, int sizeY, int x0,int y0,int ID) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.x0 = x0;
		this.y0 = y0;
		this.mapElements = new MapElement[this.sizeX][this.sizeY];
		this.ID = ID;
	}
	
	protected void strucSpace() {}
	
	public int getX0() {
		return this.x0;
	}
	
	public int getY0() {
		return this.y0;
	}
	
	public int getSizeX() {
		return this.sizeX;
	}
	
	public int getSizeY() {
		return this.sizeY;
	}
	
	public int getID() {
		return this.sizeY;
	}
}
