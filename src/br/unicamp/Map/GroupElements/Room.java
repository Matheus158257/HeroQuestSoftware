package br.unicamp.Map.GroupElements;

public class Room extends GroupMapElement {


	private boolean lights;
	
	public Room(int x0, int y0, int dimX, int dimY) {
		super(x0,y0,dimX,dimY);
		this.lights = false;
	}

	public void lightsOn() {
		this.lights = true;
	}
	
	public boolean isLit() {
		return this.lights;
	}
	
}
