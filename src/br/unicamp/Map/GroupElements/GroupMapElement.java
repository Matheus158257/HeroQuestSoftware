package br.unicamp.Map.GroupElements;

import br.unicamp.Map.MapElements.MapElement;

public class GroupMapElement {
	
	private int x0;
	private int y0;
	private int dimX;
	private int dimY;
	
	public GroupMapElement(int x0, int y0, int dimX, int dimY) {
		this.x0=x0;
		this.y0=y0;
		this.dimX=dimX;
		this.dimY=dimY;
	}
	
	
	public int getX0() {
		return this.x0;
	}

	public int getY0() {
		return this.y0;
	}
	
	public int getDimX() {
		return this.dimX;
	}
	
	public int getDimY() {
		return this.dimY;
	}

}
